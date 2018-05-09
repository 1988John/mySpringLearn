package com.foo.test.designPattern.observer.jdk;

/**
 * Description:
 * Created by jiangwang3 on 2018/5/8.
 */
public class App {
    public static void main(String[] args) {
        Teacher teacher=new Teacher();
        Student zhangSan=new Student("张三");
        Student LiSi=new Student("李四");
        Student WangWu=new Student("王五");

        teacher.addObserver(zhangSan);
        teacher.addObserver(LiSi);
        teacher.addObserver(WangWu);

        teacher.setHomework("第二页第六题");
        teacher.setHomework("第三页第七题");
        teacher.setHomework("第五页第八题");
    }
}
