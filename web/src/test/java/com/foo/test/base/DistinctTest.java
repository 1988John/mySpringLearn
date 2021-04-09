package com.foo.test.base;

import static com.foo.test.pojo.Student.getStudents;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.foo.test.pojo.Student;

/**
 * @author jiangwang
 * @date 2021-04-08 16:42
 */
public class DistinctTest {
    public static void main(String[] args) {
        // 这里第一种方法我们通过新创建一个只有不同元素列表来实现根据对象某个属性去重
        List<Student> studentList = getStudents();


        System.out.print("去重前        :");
        System.out.println(studentList);
        studentList = studentList.stream().distinct().collect(Collectors.toList());
        System.out.print("distinct去重后:");
        System.out.println(studentList);
        studentList = studentList.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getName))), ArrayList::new)
        );
        System.out.print("根据名字去重后 :");
        System.out.println(studentList);
    }

}
