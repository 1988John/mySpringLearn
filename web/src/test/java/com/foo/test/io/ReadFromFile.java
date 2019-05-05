package com.foo.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ReadFromFile {
    /**
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     */
    public static void readFileByBytes(String fileName) {
        InputStream in = null;
        try {
            in = new FileInputStream(fileName);
            // 一次读多个字节
            byte[] tempBytes = new byte[in.available()];
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            while (in.read(tempBytes) != -1) {
                System.out.println(tempBytes.length);
                System.out.println(Arrays.toString(tempBytes));
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 显示输入流中还剩的字节数
     */
    private static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        String fileName = "/Users/fooisart/Downloads/test.csv";
        ReadFromFile.readFileByBytes(fileName);
        InputStream in = RecursiveTask.class.getResourceAsStream("/Users/fooisart/Downloads/test.csv");
        byte[] tempBytes = new byte[in.available()];
//            ReadFromFile.showAvailableBytes(in);
        // 读入多个字节到字节数组中，byteread为一次读入的字节数
        while (in.read(tempBytes) != -1) {
            System.out.println(tempBytes.length);
            System.out.println(Arrays.toString(tempBytes));
        }
//        File file = new File(fileName);
//        System.out.println();

    }
}