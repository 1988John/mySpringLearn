package com.foo.test.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fooisart
 * @date 19:57 07-05-2019
 */
public class FileUtil {
    /**
     * 读取csv文件
     *
     * @author fooisart
     * @date 17:38 2019/4/30
     */
    public static List<String> readCsv(String fileName) throws Exception{
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
