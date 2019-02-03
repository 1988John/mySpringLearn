package com.foo.test.base.buffer;

import java.nio.ByteBuffer;

/**
 * @author Fooisart
 * @date 10:31 03-02-2019
 */
public class ByteBufferTest {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(Long.BYTES);
        System.out.println(byteBuffer);

        byteBuffer.putLong(0,2);
//        byte[] array = byteBuffer.array();
//        System.out.println(Arrays.toString(array));
        System.out.println(byteBuffer.getLong());

//        byteBuffer.putLong(3);

        System.out.println(byteBuffer);

//        System.out.println(Arrays.toString(array));
//
//        System.out.println(byteBuffer.get(7));
    }
}
