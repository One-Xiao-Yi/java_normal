/**
 * FileName: TExample
 * Author: xiaoyi
 * Description:    泛型示例
 * Date:   2019/12/315:34
 */

package tpackage;

public class TExample<T, K> {

    private T int_ex;

    private K str_ex;

    public TExample(T int_ex, K str_ex) {
        this.int_ex = int_ex;
        this.str_ex = str_ex;
    }

    public T getInt_ex() {
        return int_ex;
    }

    public void setInt_ex(T int_ex) {
        this.int_ex = int_ex;
    }

    public K getStr_ex() {
        return str_ex;
    }

    public void setStr_ex(K str_ex) {
        this.str_ex = str_ex;
    }

    public static <T, K> TExample<T, K> create(T int_ex, K str_ex)
    {
        return new TExample<>(int_ex, str_ex);
    }
}
