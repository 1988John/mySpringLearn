package com.foo.test.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangwang
 * @date 2021-04-08 16:35
 */
public class Student {
    private String No;
    private String name;

    public Student(String no, String name) {
        No = no;
        this.name = name;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("01", "f1"));
        students.add(new Student("02", "f1"));
        students.add(new Student("02", "f3"));
        return students;
    }

    @Override
    public String toString() {
        return "Student{" +
                "No='" + No + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
