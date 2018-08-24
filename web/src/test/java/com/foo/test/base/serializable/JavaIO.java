package com.foo.test.base.serializable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;

public class JavaIO {
  
  /**
   * 采用的是操作系统底层默认的编码方式，GBK等，非UTF8
   * */
  
  /**
   * 以字节为单位读取文件内容，常用于读取二进制文件，比如图片、影像、声音等文件
   * */
  public static void readFileByBytes(String filename) {
    File file=new File(filename);
    FileInputStream in=null;
    try {
      System.out.println("以字节为单位读取文件,一次读一个字节: ");
      in=new FileInputStream(file);
      int temp=0;
      while ((temp=in.read()) != -1) {
        System.out.println(temp);
      }
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
      return ;
    }
    try {
      System.out.println("以字节为单位读取文件，一次读多个字节： ");
      byte[] temp=new byte[100];
      int byteread=0;
      in=new FileInputStream(file);
      JavaIO.showAvailableBytes(in);
      while ((byteread=in.read(temp)) != -1) {
        System.out.write(temp,0,byteread);
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
   * 以字符为单位读取文件，常用于读文本，数字等类型的文件
   * */
  public static void readFileByChar(String filename) {
    File file=new File(filename);
    Reader reader=null;
    try {
      System.out.println("以字符为单位读取文件内容，一次一个字节：");
      //InputStreamReader类:是字节向字符转换的桥梁
      reader=new InputStreamReader(new FileInputStream(file));
      int temp;
      while ((temp=reader.read()) != -1) {
        if (((char)temp) != '\r') {
          System.out.println((char)temp);
        }
      } 
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      System.out.println("以字符为单位读取文件内容，一次读多个字节： ");
      char[] temp=new char[30];
      int charread=0;
      reader=new InputStreamReader(new FileInputStream(filename));
      while ((charread=reader.read(temp)) != -1) {
        if ((charread == temp.length) && (temp[temp.length-1]!='\r')) {
          System.out.println(temp);
        } else {
          for (int i=0; i<charread; i++) {
            if (temp[i] == '\r') {
              break;
            } else {
              System.out.println(temp[i]);
            }
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          
        }
      }
    }
  }
  /**
   * 以行为单位读取文件，常用于读面向行的格式化文件
   * */
  public static void readFileByLine(String filename) {
    File file=new File(filename);
    BufferedReader reader=null;
    try {
      System.out.println("以行为单位读取文件内容，一次读一整行： ");
      reader=new BufferedReader(new FileReader(file));
      String temp=null;
      int line=1;
      while ((temp=reader.readLine()) != null) {
        System.out.println("line " + line + ": " + temp);
        line++;
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          
        }
      }
    }
  }
  /**
   * 随机读取文件内容
   * */
  public static void readFileByRandomAccess(String filename) {
    RandomAccessFile randomfile=null;
    try {
      System.out.println("随机读取一段文件内容");
      randomfile=new RandomAccessFile(filename,"r");
      long fileLength=randomfile.length();
      int beginIndex=(fileLength > 4 ? 4 : 0);
      randomfile.seek(beginIndex);
      byte[] bytes=new byte[10];
      int byteread=0;
      while ((byteread=randomfile.read(bytes)) != -1) {
        System.out.write(bytes,0,byteread);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (randomfile != null) {
        try {
          randomfile.close();
        } catch (IOException e) {
          
        }
      }
    }
  }
  private static void showAvailableBytes(InputStream in) {
    try {
      System.out.println("当前字节输入流中的字节数为：" + in.available());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    String filename="E:\\BaiYiShaoNian.txt";
    JavaIO.readFileByBytes(filename);
    JavaIO.readFileByChar(filename);
    JavaIO.readFileByLine(filename);
    JavaIO.readFileByRandomAccess(filename);
  }
}