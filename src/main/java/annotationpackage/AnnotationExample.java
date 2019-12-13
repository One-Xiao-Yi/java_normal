/**
 * FileName: AnnotationExample
 * Author: xiaoyi
 * Description:    注解示例
 * Date:   2019/12/314:45
 */

package annotationpackage;

/*
元注解：可以修饰其他注解的注解。常用的元注解：
@Target：可以定义注解能够被应用于源码的哪些位置。属性有：
1.ElementType.TYPE          类或接口
2.ElementType.FIELD         字段
3.ElementType.METHOD        方法
4.ElementType.CONSTRUCTOR   构造方法
5.ElementType.PARAMETER     方法参数

@Retention：定义一个注解的生命周期。属性有：
1.RetentionPolicy.SOURCE    仅编译器
2.RetentionPolicy.CLASS     仅.class文件
3.RetentionPolicy.RUNTIME   运行期
如果该注解不存在，则默认为RetentionPolicy.CLASS

@Repeatable：定义注解是否可重复。加上该注解，表示可重复。

@Inherited：定义子类是否可继承父类的注解。只针对ElementType.TYPE类型的注解生效，且仅支持Class，不支持Interface

定义注解步骤：
1.使用@interface定义注解
2.添加参数、默认值，常用参数定义为value()，推荐所有参数都设置默认值。
3.用元注解配置注解，其中@Target、@Retention必须配置
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({
        ElementType.METHOD,
        ElementType.FIELD
})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationExample {

    int max() default 255;

    int min() default 1;

}
