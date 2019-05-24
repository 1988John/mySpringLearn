package com.foo.test.base.channel.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author fooisart
 * @date 15:44 24-05-2019
 */
public class SocketChannelServer {
    public static void main(String[] args) throws IOException {
        SocketChannel server = SocketChannel.open();
        server.connect(new InetSocketAddress("localhost",9000));

        Path path = Paths.get("/Users/fooisart/Desktop/test");
        FileChannel fileChannel = FileChannel.open(path);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (fileChannel.read(buffer) > 0) {
            buffer.flip();
            server.write(buffer);
            buffer.clear();
        }
        fileChannel.close();
        System.out.println("File Sent!");
        server.close();
    }
}
