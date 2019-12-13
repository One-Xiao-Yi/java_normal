package testpackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestExampleTest {

    TestExample testExample;

    @BeforeEach
    void setUp() {

        this.testExample = new TestExample();

    }

    @AfterEach
    void tearDown() {

        this.testExample = null;

    }

    @Test
    void factorial() {

        assertEquals(1, testExample.factorial(1));
        assertEquals(2, testExample.factorial(2));
        assertEquals(6, testExample.factorial(3));
        assertEquals(24, testExample.factorial(4));
        assertEquals(120, testExample.factorial(5));

    }

    @Test
    void factEx() {

        assertEquals(1, testExample.factEx(1));
        assertThrows(IllegalArgumentException.class, () -> testExample.factEx(-1));

    }

    //条件测试：当满足某些条件时，运行某些测试。
    //@Disable 表示不运行此测试。
    //@EnabledOnOs 在此操作系统条件下进行测试。
    //@DisabledOnOs 不在此操作系统条件下进行测试
    //@DisabledOnJre 在此jre版本以上条件下进行测试
    //@EnabledIfSystemProperty 在某位操作系统条件下测试
    //@EnabledIfEnvironmentVariable 传入环境变量才能测试
    //@EnableIf 在之后跟随的判断条件为真时测试 @EnabledIf("java.time.LocalDate.now().getDayOfWeek()==java.time.DayOfWeek.SUNDAY") 旨在周日时测试

    //windows平台下运行此测试方法
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void configWinFile() {

        assertEquals("\\file_name", testExample.configFile("file_name"));

    }

    //linux平台下运行此测试方法
    @Test
    @EnabledOnOs(OS.LINUX)
    void configLinuxFile(){

        assertEquals("/file_name", testExample.configFile("file_name"));

    }

    //参数化测试，将参数放入集合，循环测试
    @ParameterizedTest
    @MethodSource
    void stringUtils(String input, String result) {

        assertEquals(result, testExample.stringUtils(input));

    }

    static List<Arguments> stringUtils()
    {
        return List.of(
                Arguments.arguments("abc", "Abc"),
                Arguments.arguments("green", "Green"),
                Arguments.arguments("blue", "Blue"),
                Arguments.arguments("red", "Red")
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"../test.csv"})
    void stringUtilsCsv(String input, String result) {

        System.out.println(input);
        System.out.println(result);
        System.out.println(testExample.stringUtils(input));
        assertEquals(result, testExample.stringUtils(input));

    }
}