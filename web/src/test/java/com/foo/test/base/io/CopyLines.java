package com.foo.test.base.io;

import com.foo.common.constant.Constant;

import java.io.*;

/**
 * @author jiangwang3
 * @date 2018/8/24.
 */
public class CopyLines {
    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader(Constant.IN_PATH));
            outputStream = new PrintWriter(new FileWriter(Constant.OUT_PATH));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
