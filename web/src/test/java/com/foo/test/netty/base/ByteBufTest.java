package com.foo.test.netty.base;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @author jiangwang
 * Created on 18-12-2018
 */
public class ByteBufTest {
    public static void main(String[] args) {
        final ByteBuf buf = Unpooled.unreleasableBuffer(
                Unpooled.copiedBuffer("Hi!\r\n", Charset.forName("UTF-8")));
        ByteBuf buf1 = buf.readerIndex(2);
        System.out.println(buf1);
        System.out.println(buf.readerIndex());
        ByteBuf buf2 = buf.writerIndex(3);
        System.out.println(buf.writerIndex());
    }
}
