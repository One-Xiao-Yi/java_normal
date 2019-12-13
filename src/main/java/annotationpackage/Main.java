/**
 * FileName: Main
 * Author: xiaoyi
 * Description:    main
 * Date:   2019/12/314:22
 */

package annotationpackage;

import java.lang.reflect.Field;

/**
 * java的注解可分为三类：
 * 1.由编译器使用的注解，例如：@Override：让编译器检查该方法是否正确的实现了重写，
 * 这类注解不会进入.class文件，编译完成后既失效。
 * 2.由工具处理.class文件使用的注解，比如有些工具在处理.class进行动态处理，
 * 会进入.class文件，但加载结束后不会存在于内存中。一般被一些底层库使用。
 * 3.在程序运行时能够被读取的注解，被加载后一直存在于JVM中，也是最常用的注解。
 *
 * 定义一个注解时，还可以定义配置参数。参数包括：
 * 1.所有基本类型。
 * 2.String
 * 3.枚举类型
 * 4.基本类型、String以及枚举的数组
 * 因为配置参数必须是常量，在定义时就确定了每个参数的值。
 * 参数可以有默认值。
 * 大部分注解会有一个value配置参数，为此参数赋值。
 *
 *
 */

public class Main {

    public static void main(String[] args) {

        ClassExample classExample1 = new ClassExample(8);
        ClassExample classExample2 = new ClassExample(2);
        ClassExample classExample3 = new ClassExample(11);
        ClassExample classExample4 = new ClassExample(-1);

        for(ClassExample classExample:new ClassExample[]{classExample1, classExample2, classExample3, classExample4})
        {
            try {
                check(classExample);
                System.out.println("Check Ok :" + classExample.n);
            }catch (Exception e)
            {
                System.out.println("Check Error :" + classExample.n);
            }
        }

    }

    public static void check(ClassExample classExample) throws IllegalArgumentException, ReflectiveOperationException
    {
        for(Field field:classExample.getClass().getFields())
        {
            AnnotationExample annotationExample = field.getAnnotation(AnnotationExample.class);
            if(null != annotationExample)
            {
                Object value = field.get(classExample);
                if(value instanceof Integer)
                {
                    Integer n = (Integer) value;
                    if(n < annotationExample.min() || n > annotationExample.max())
                    {
                        throw new IllegalArgumentException("field :" + field.getName());
                    }
                }
            }
        }
    }

}
