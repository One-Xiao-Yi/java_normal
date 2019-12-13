package stringpackage;

public class Main {

    public static void main(String[] args) {

        //忽略大小写比较
        System.out.println("hello".equalsIgnoreCase("HELLO"));

        //子字符串操作
        //是否包含子字符串
        System.out.println("hello".contains("ll"));
        //子字符串在字符串中的位置
        System.out.println("hello".indexOf("ll"));
        //子字符串最后一次出现位置
        System.out.println("hello".lastIndexOf("l"));
        //字符串是否以子字符串开头
        System.out.println("hello".startsWith("he"));
        //以子字符串结尾
        System.out.println("hello".endsWith("lo"));

        //切割字符串
        System.out.println("hello".substring(2, 4));

        //去除字符串前后空白字符
        // trim()  和  strip()   后者可以去除输入的空格
        // stripLeading  去除起始   stripTrailing  去除末尾
        System.out.println(" \thello\r\n ".trim());
        System.out.println(" \u3000\thello\r\n ".strip());

        //拼接字符串
        //join和+的区别
        // + 每次都会开辟新的空间，回收旧空间
        // join 一次性开辟空间
        System.out.println("h".join("e"));

    }

}
