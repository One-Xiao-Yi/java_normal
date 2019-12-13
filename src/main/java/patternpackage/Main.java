/**
 * FileName: Main
 * Author: xiaoyi
 * Description:    main
 * Date:   2019/11/2017:24
 */
package patternpackage;

/*
 *  runoo+d + 表示+号前的字符至少出现一次
 *  runoo*d * 表示*号前的字符可以不出现，也可以出现多次
 *  colou?r ? 表示?号前的字符最多只能出现一次，也可以是0次。
 *
 *  非打印字符
 *  \cx	匹配由x指明的控制字符。例如， \cM 匹配一个 Control-M 或回车符。x 的值必须为 A-Z 或 a-z 之一。否则，将 c 视为一个原义的 'c' 字符。
    \f	匹配一个换页符。等价于 \x0c 和 \cL。
    \n	匹配一个换行符。等价于 \x0a 和 \cJ。
    \r	匹配一个回车符。等价于 \x0d 和 \cM。
    \s	匹配任何空白字符，包括空格、制表符、换页符等等。等价于 [ \f\n\r\t\v]。注意 Unicode 正则表达式会匹配全角空格符。
    \S	匹配任何非空白字符。等价于 [^ \f\n\r\t\v]。
    \t	匹配一个制表符。等价于 \x09 和 \cI。
    \v	匹配一个垂直制表符。等价于 \x0b 和 \cK。

    特殊字符
    $	匹配输入字符串的结尾位置。如果设置了 RegExp 对象的 Multiline 属性，则 $ 也匹配 '\n' 或 '\r'。要匹配 $ 字符本身，请使用 \$。
    ( )	标记一个子表达式的开始和结束位置。子表达式可以获取供以后使用。要匹配这些字符，请使用 \( 和 \)。
    *	匹配前面的子表达式零次或多次。要匹配 * 字符，请使用 \*。
    +	匹配前面的子表达式一次或多次。要匹配 + 字符，请使用 \+。
    .	匹配除换行符 \n 之外的任何单字符。要匹配 . ，请使用 \. 。
    [	标记一个中括号表达式的开始。要匹配 [，请使用 \[。
    ?	匹配前面的子表达式零次或一次，或指明一个非贪婪限定符。要匹配 ? 字符，请使用 \?。
    \	将下一个字符标记为或特殊字符、或原义字符、或向后引用、或八进制转义符。例如， 'n' 匹配字符 'n'。'\n' 匹配换行符。序列 '\\' 匹配 "\"，而 '\(' 则匹配 "("。
    ^	匹配输入字符串的开始位置，除非在方括号表达式中使用，此时它表示不接受该字符集合。要匹配 ^ 字符本身，请使用 \^。
    {	标记限定符表达式的开始。要匹配 {，请使用 \{。
    |	指明两项之间的一个选择。要匹配 |，请使用 \|。

    限定符
    *	匹配前面的子表达式零次或多次。例如，zo* 能匹配 "z" 以及 "zoo"。* 等价于{0,}。
    +	匹配前面的子表达式一次或多次。例如，'zo+' 能匹配 "zo" 以及 "zoo"，但不能匹配 "z"。+ 等价于 {1,}。
    ?	匹配前面的子表达式零次或一次。例如，"do(es)?" 可以匹配 "do" 、 "does" 中的 "does" 、 "doxy" 中的 "do" 。? 等价于 {0,1}。
    {n}	n 是一个非负整数。匹配确定的 n 次。例如，'o{2}' 不能匹配 "Bob" 中的 'o'，但是能匹配 "food" 中的两个 o。
    {n,}	n 是一个非负整数。至少匹配n 次。例如，'o{2,}' 不能匹配 "Bob" 中的 'o'，但能匹配 "foooood" 中的所有 o。'o{1,}' 等价于 'o+'。'o{0,}' 则等价于 'o*'。
    {n,m}	m 和 n 均为非负整数，其中n <= m。最少匹配 n 次且最多匹配 m 次。例如，"o{1,3}" 将匹配 "fooooood" 中的前三个 o。'o{0,1}' 等价于 'o?'。请注意在逗号和两个数之间不能有空格。

    定位符
    ^	匹配输入字符串开始的位置。如果设置了 RegExp 对象的 Multiline 属性，^ 还会与 \n 或 \r 之后的位置匹配。
    $	匹配输入字符串结尾的位置。如果设置了 RegExp 对象的 Multiline 属性，$ 还会与 \n 或 \r 之前的位置匹配。
    \b	匹配一个单词边界，即字与空格间的位置。
    \B	非单词边界匹配。
 * */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Pattern pattern1 = Pattern.compile("[1-9][0-9]*");

        // [1-9][0-9]*  [1-9]表示第一个数字在1到9之间  [0-9]表示在0到9之间的数字
        Matcher matcher1 = pattern1.matcher("156");
        while (matcher1.find())
        {
            //System.out.println(matcher1.group());
        }

        Pattern pattern2 = Pattern.compile("<.*?>");

        // 限定符都是贪婪的，会尽可能多的匹配字符，在之后加上?即可完成最小或非贪婪匹配
        Matcher matcher2 = pattern2.matcher("<h1>RUNOOB-菜鸟教程</h1><h2>RUNOOB-菜鸟教程</h2><h1>RUNOOB-菜鸟教程</h1>");
        while (matcher2.find())
        {
            // System.out.println(matcher2.group());
        }

        String reg = "red black color green blue";
        Pattern pattern3 = Pattern.compile("^re.*?\\b");
        Pattern pattern4 = Pattern.compile("ue$");
        Pattern pattern5 = Pattern.compile("\\bbl.*\\b");
        Pattern pattern6 = Pattern.compile("\\Bla.*?\\b");

        Matcher matcher3 = pattern3.matcher(reg);
        Matcher matcher4 = pattern4.matcher(reg);
        Matcher matcher5 = pattern5.matcher(reg);
        Matcher matcher6 = pattern6.matcher(reg);

        while (matcher3.find())
        {
            System.out.println("matcher3:" + matcher3.group());
        }
        while (matcher4.find())
        {
            System.out.println("matcher4:" + matcher4.group());
        }
        while (matcher5.find())
        {
            System.out.println("matcher5:" + matcher5.group());
        }
        while (matcher6.find())
        {
            System.out.println("matcher6:" + matcher6.group());
        }
    }

}