package com.foo.test.nio.channel;

import com.foo.common.constant.Constant;
import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangwang3
 * @date 2018/8/28.
 */
public class BaseChannel {
    @Test
    public void test() throws Exception {
        RandomAccessFile aFile = new RandomAccessFile(Constant.NIO_PATH, "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);
        list.forEach(i -> {
            if (i == 1) {
                return;
            }
            System.out.println(i);
        });

    }
}
