package com.foo.service.transaction.propagation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

/**
 * Description:
 * Created by jiangwang3 on 2018/4/18.
 */
//@Service
public class TransactionAnnoService {
    @Transactional
    public int defaultExecute(){
        return 110;
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
        Byte b = 1;

    }



}
