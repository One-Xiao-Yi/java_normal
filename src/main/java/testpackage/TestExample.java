/**
 * FileName: TestExample
 * Author: xiaoyi
 * Description:    单元测试
 * Date:   2019/12/317:35
 */

package testpackage;

public class TestExample {

    public int factorial(int n)
    {
        int sum = 1;
        for(int i = n; i > 0; i--)
        {
            sum = sum * i;
        }
        return sum;
    }

    public int factEx(int n)
    {
        if(n < 0)
        {
            throw new IllegalArgumentException();
        }
        return n;
    }

    public String configFile(String fileName)
    {
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("win"))
        {
            return "\\" + fileName;
        }
        if(os.contains("linux"))
        {
            return "/" + fileName;
        }
        throw new UnsupportedOperationException();
    }

    public String stringUtils(String s)
    {
        if (s.length() == 0) {
            return s;
        }
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

}
