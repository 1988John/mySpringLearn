package com.foo.test.base.serializable;

import com.alibaba.fastjson.JSON;

import java.io.*;

public class Test {

    private static final String path = "C:\\Users\\jiangwang3\\Desktop\\obj.txt";
    
    public static void main(String[] args) throws IOException, Exception {
        writeObj();


//        String filePath = "/Users/lichuang/Documents/第一次请求.json";
//        String jsonContent = FileUtil.ReadFile(path);
//        List<User> list = JSON.parseArray(jsonContent,User.class);
//
//        System.out.println(JSON.toJSONString(list));

        String s = FileUtil.ReadFile(path);
        System.out.println(s);


//        String s = readToString(path);
//        System.out.println(s);
//        readObj();
    }    

    //定义方法把对象的信息写到硬盘上------>对象的序列化。
    public static void writeObj() throws IOException{
        //把user对象的信息持久化存储。
        User user = new User("admin","123");
        //找到目标文件
        File file = new File(path);
        //建立数据输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //建立对象的输出流对象
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        //把对象写出
        String s = JSON.toJSONString(user);
        System.out.println(s);
        objectOutputStream.writeObject(JSON.toJSONString(user));
        //关闭资源
        objectOutputStream.close();
        
    }

    //把文件中的对象信息读取出来-------->对象的反序列化
    public static void readObj() throws  IOException, ClassNotFoundException{
        //找到目标文件
        File file = new File(path);
        //建立数据的输入通道
        FileInputStream fileInputStream = new FileInputStream(file);

        //建立对象的输入流对象
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        User user = (User) JSON.parseObject(objectInputStream, User.class);
        //读取对象信息
//        User user = (User) objectInputStream.readObject(); //创建对象肯定要依赖对象所属 的class文件。
        System.out.println("对象的信息："+ user);
    }

    public static String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);

            User o = JSON.parseObject(in, User.class);
            System.out.println(JSON.toJSONString(o));

            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

}