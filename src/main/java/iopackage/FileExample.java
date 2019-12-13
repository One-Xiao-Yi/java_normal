/**
 * FileName: FileExample
 * Author: xiaoyi
 * Description:    file
 * Date:   2019/12/315:53
 */

package iopackage;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/*
路径既可以是绝对路径，也可以是相对路径。
windows平台下使用 \ 分割符，在Java字符串中应使用 \\ 转义。
linux平台下使用 / 分隔符

File对象既可以表示文件，也可以表示目录。
创建File对象是，即使文件不存在也不会报错，因为创建对象并不会导致磁盘操作，但是使用该对象时，便会报错。
 */

public class FileExample {

    public static void main(String[] args) throws IOException{

        File file = new File("readme.md");
        System.out.println(file);
        //可读？可写？可执行？长度？
        //可执行对于文件夹而言，表示能否列出它包含的文件或子文件夹
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
        System.out.println(file.length());

        File current = new File(".");
        //返回构造方法传入的路径
        System.out.println(current.getPath());
        //返回绝对路径
        System.out.println(current.getAbsolutePath());
        try {
            //返回规范路径（将 . 、 .. 转换成标准的绝对路径）
            System.out.println(current.getCanonicalPath());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        //返回当前系统的分隔符
        System.out.println(File.separator);

        File newFile = new File("test.txt");
        try {
            if(newFile.createNewFile())
            {
                System.out.println("创建文件成功" + newFile.getName());
                if(newFile.delete())
                {
                    System.out.println("删除文件成功" + newFile.getName());
                }
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        File temp = File.createTempFile("tmp-", ".txt");
        temp.deleteOnExit();
        System.out.println(temp.isFile());
        System.out.println(temp.getAbsolutePath());

        File list = new File("D:\\weapp\\store");
        File[] files = list.listFiles();
        printFiles(files);
        //根据文件结尾筛选文件
        File[] js = list.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".js");
            }
        });
        printFiles(js);

        //创建文件夹
        //mkdirs 创建文件夹，并在必要时将不存在的父文件夹创建出来
        //delete删除文件夹，必须当当前文件夹为空时才执行成功
        File fileMkdir = new File("D:\\weapp\\store\\test");
        File fileMkdirs = new File("D:\\weapp\\test\\test");
        if(fileMkdir.mkdir())
        {
            System.out.println("test文件夹创建成功");
        }
        if(fileMkdirs.mkdirs())
        {
            System.out.println("test文件夹及父文件夹创建成功");
        }

    }

    public static void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }

}
