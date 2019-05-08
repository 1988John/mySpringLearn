package com.foo.test.io;

import static com.foo.test.io.FileUtil.readCsv;

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

}
