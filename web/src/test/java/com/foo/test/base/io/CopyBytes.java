package com.foo.test.base.io;

import com.foo.common.constant.Constant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jiangwang3
 * @date 2018/8/24.
 */
public class CopyBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(Constant.IN_PATH);
            out = new FileOutputStream(Constant.OUT_PATH);
            int c;
            while ((c = in.read()) != -1){
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null){
                in.close();
            }
            if (out != null){
                out.close();
            }
        }
    }
}
