package com.foo.test.base.serializable;
 
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class Main {
 
    public static void main(String[] args) {
        //这里将javabean转化成json字符串
        Person person = new Person("1", "fastjson", 1);
        String jsonString = JSON.toJSONString(person);
        System.out.println("将javabean转化成json字符串:"+jsonString);
 
        //这里将json字符串转化成javabean对象,
        Person personSec = new Person();
        personSec = JSON.parseObject(jsonString, Person.class);
        System.out.println("将json字符串转化成javabean对象:"+personSec.getName());
 
 
        Person person1 = new Person("1","fastjson1",1);
        Person person2 = new Person("2","fastjson2",2);
        List<Person> persons = new ArrayList<Person>();
        persons.add(person1);
        persons.add(person2);
        String jsonStringSec = JSON.toJSONString(persons);//是json数组
        System.out.println("将List<JavaBean>转换成json字符串:"+jsonStringSec);
 
       // List<Person> persons2 = JSON.parseArray(jsonStringSec,Person.class);  ///这两种方法均可
        List<Person> persons2 = JSON.parseObject(jsonStringSec,new TypeReference<List<Person>>(){});///这两种方法均可
        System.out.println("将json字符串转换成List<JavaBean>:"+persons2.get(1).getName());
 
 
        List<String> list = new ArrayList<String>();
        list.add("fastjson1");
        list.add("fastjson2");
        list.add("fastjson3");
        String jsonStringThird = JSON.toJSONString(list);//是json数组
        System.out.println("将list转换为json字符串:"+jsonStringThird);
 
        List<String> list2 = JSON.parseObject(jsonStringThird,new TypeReference<List<String>>(){});
        System.out.println("将json转换为List："+list2.get(2));
 
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("key1","val1");
        map.put("key2","val2");
        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("key1",1);
        map2.put("key2",2);
        List<Map<String,Object>>  list3 = new ArrayList<Map<String, Object>>();
        list3.add(map);
        list3.add(map2);
        String jsonStringFourth = JSON.toJSONString(list3);
        System.out.println("将List<Map<String,Object>>对象转化成json字符串:"+jsonStringFourth);
        List<Map<String,Object>> list4 = JSON.parseObject(jsonStringFourth,new TypeReference<List<Map<String,Object>>>(){});
        System.out.println("将json字符串转化成List<Map<String,Object>>对象"+list4.get(1).get("key1"));
 
    }
 
}
