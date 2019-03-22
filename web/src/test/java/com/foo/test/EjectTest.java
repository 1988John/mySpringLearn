package com.foo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Fooisart
 * @date 16:45 19-03-2019
 */
public class EjectTest {
    private static final Logger logger = LoggerFactory.getLogger(EjectTest.class);
    private static long lastSerialNo = -1;
    private static boolean is_close = false;
    private static List<Long> serialNoList = new ArrayList<>();
    private static int audio_data_threshold = 5;
    public static void main(String[] args) {
        List<Long> sourceList = Arrays.asList(729L,728L,724L,725L,732L,722L,736L,738L,727L,737L,733L,731L);
        sourceList.forEach(aLong -> {
            pushData(1,aLong);
            getData();
        });
    }

    private static boolean pushData(int type,Long serial_No){
        if (type == 2) {
            is_close = true;
            return true;
        }
        if (serial_No <= lastSerialNo) {
            System.out.println("丢弃"+ serial_No);
            logger.info("丢弃"+ serial_No);
            return false;
        }
        serialNoList.add(serial_No);
        if (serialNoList.size() > 1) {
            //排序
            serialNoList.sort(Long::compareTo);
        }
        return true;
    }

    private static boolean getData(){
        if (serialNoList.size() == 0) {
            return false;
        }
        if (is_close) {  // pop all data
            for ( Long req : serialNoList) {
                serialNoList.add(req);
                lastSerialNo = req;
            }
            serialNoList.clear();
            return true;
        }
        int idx = 0;
        while ( idx < serialNoList.size() &&
                ( serialNoList.get(idx) == lastSerialNo + 1 ||
                        serialNoList.size() - idx >= audio_data_threshold) ) {
            lastSerialNo = serialNoList.get(idx);
            System.out.println(lastSerialNo);
            idx += 1;
        }

        if (idx > 0) {
            for (int i=0;i<idx;i++){
                serialNoList.remove(0);
            }
        }
        return true;
    }
}
