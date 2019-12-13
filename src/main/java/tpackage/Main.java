/**
 * FileName: Main
 * Author: xiaoyi
 * Description:    泛型
 * Date:   2019/12/315:27
 */

package tpackage;

/*
泛型就是编写模板代码来适应任何类型。
好处是使用时不必强制转换类型，编译器会自动对类型进行检查。

java的泛型实现方式是擦拭法（Type Erasure）：虚拟机对泛型一无所知，所有工作都是编译器做的。
例：编写的代码：
    TExample<Integer, String> tExample = new TExample<>(123, "asd");
    Integer n = tExample.getInt_ex();
    String str = tExample.getStr_ex();
    但实际虚拟机执行的代码：
    TExample tExample = new TExample(123, "asd");
    Integer n = (Integer) tExample.getInt_ex();
    String str = (String) tExample.getStr_ex();
所以，泛型是由编译器在编译时实行的，编译器内部永远把所有类型T时为Object处理，
但是在需要转换类型时，编译器会根据T的类型自动进行安全的类型转换。
因此，泛型有以下局限性：
1.T不能是基本类型，因为Object无法持有基本类型。
2.无法取得带泛型的Class。因为所有的泛型都是Object(TExample<Object, Object>)，所以获取的Class都是同一个Class。
3.无法判断带泛型的Class。原因同上，因为不论是TExample<String, String>还是TExample<Integer, Integer>，实例都是TExample.class
4.不能实例化T类型
 */
public class Main {

    public static void main(String[] args) {

        TExample<Integer, String> tExample = new TExample<>(123, "asd");
        Integer n = tExample.getInt_ex();
        String str = tExample.getStr_ex();

        TExample<String, String> example = TExample.create("xiao", "yi");

    }

}
