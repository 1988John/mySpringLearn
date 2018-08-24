package com.foo.test.base.io;

import com.foo.common.constant.Constant;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author jiangwang3
 * @date 2018/8/24.
 */
public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;
        try {
            inputStream = new FileReader(Constant.IN_PATH);
            outputStream = new FileWriter(Constant.OUT_PATH);
            int c ;
            while ( (c = inputStream.read()) != -1){
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null){
                inputStream.close();
            }
            if (outputStream != null){
                outputStream.close();
            }
        }
    }
}
