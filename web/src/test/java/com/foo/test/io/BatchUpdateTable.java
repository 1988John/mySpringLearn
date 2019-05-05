package com.foo.test.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fooisart
 * @date 17:30 30-04-2019
 */
public class BatchUpdateTable {
    private static final String SQL = "ALTER TABLE %s ADD content_id bigint(20) COMMENT '语义模板ID';";
    public static void main(String[] args) throws Exception{
        String fileName = "/Users/fooisart/Downloads/test.csv";
        List<String> list = readCsv(fileName);
        String sqls = list.stream().map(table -> String.format(SQL, table)).collect(Collectors.joining());
        System.out.println(sqls); //打印出的结果直接执行即可
    }
    /**
     * 读取csv文件
     *
     * @author fooisart
     * @date 17:38 2019/4/30
     */
    private static List<String> readCsv(String fileName) throws Exception{
        List<String> fileNameList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));//换成你的文件名
        reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
        String line;
        while((line=reader.readLine())!=null){
            fileNameList.add(line);
        }
        return fileNameList;
    }
}
