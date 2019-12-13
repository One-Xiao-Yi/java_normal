/**
 * FileName: ClassExample
 * Author: xiaoyi
 * Description:    example
 * Date:   2019/12/314:22
 */

package annotationpackage;

public class ClassExample {

    @AnnotationExample(max = 10, min = 5)
    public int n;

    public ClassExample(int n) {
        this.n = n;
    }
}
