/**
 * FileName: InputStreamExample
 * Author: xiaoyi
 * Description:    输入字节流
 * Date:   2019/12/316:42
 */

package iopackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*

 */
public class InputStreamExample {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\deepin_idea_project\\java_normal\\src\\main\\java\\io_package\\readme.md");

        //这种写法，系统将自动关闭IO操作
        try (InputStream inputStream = new FileInputStream(file)){
            while (true)
            {
                //阻塞：执行下面的read方法时，速度变慢，无法确定执行多长时间，并且只有当该代码执行完毕，才能执行后续代码
                int n = inputStream.read();
                if(n == -1)
                {
                    break;
                }
                System.out.println(n);
            }
        }

        //在读取时，一次读取一个字节不是高效的做法，一般会使用缓冲区
        byte[] bytes = new byte[1024];
        try (InputStream inputStream = new FileInputStream(file)){
            int n = 0;
            while ((n = inputStream.read(bytes)) != -1)
            {
                System.out.println("read" + n + "bytes");
            }
        }

    }

}
