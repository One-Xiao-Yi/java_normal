/**
 * FileName: OutputStreamExample
 * Author: xiaoyi
 * Description:    输出字节流
 * Date:   2019/12/316:59
 */

package iopackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamExample {

    public static void main(String[] args) {

        File file = new File("D:\\deepin_idea_project\\java_normal\\src\\main\\java\\io_package\\test.txt");

        try (OutputStream outputStream = new FileOutputStream(file)){
            outputStream.write(72);
            outputStream.write(101);
            outputStream.write(108);
            outputStream.write(108);
            outputStream.write(111);
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        try (OutputStream outputStream = new FileOutputStream(file)){
            outputStream.write("HELLO".getBytes("UTF-8"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}
