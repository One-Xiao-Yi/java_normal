/**
 * FileName: ReaderExample
 * Author: xiaoyi
 * Description:    字符流
 * Date:   2019/12/317:15
 */

package iopackage;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReaderExample {

    public static void main(String[] args) {

//        File in = new File("D:\\deepin_idea_project\\java_normal\\src\\main\\java\\io_package\\readme.md");
//        reader(in);
        File out = new File("D:\\deepin_idea_project\\java_normal\\src\\main\\java\\io_package\\test.txt");
        writer(out);
    }

    public static void reader(File file)
    {
        try (Reader reader = new FileReader(file, StandardCharsets.UTF_8)){
            while (true)
            {
                int n = reader.read();
                if(n == -1)
                {
                    break;
                }
                System.out.println((char) n);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        char[] chars = new char[1024];
        try (Reader reader = new FileReader(file, StandardCharsets.UTF_8)){
            int n = 0;
            while ((n = reader.read(chars)) != -1)
            {
                System.out.println("read " + n + "chars");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void writer(File file)
    {
        try (Writer writer = new FileWriter(file)){
            writer.write('c');
            writer.write("hello".toCharArray());
            writer.write("HELLO");
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
