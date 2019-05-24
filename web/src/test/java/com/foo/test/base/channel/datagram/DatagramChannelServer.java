package com.foo.test.base.channel.datagram;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @author fooisart
 * @date 15:10 24-05-2019
 */
public class DatagramChannelServer {
    public static void main(String[] args) throws IOException {
        DatagramChannel server = DatagramChannel.open();
        InetSocketAddress iAdd = new InetSocketAddress("localhost", 8989);
        server.bind(iAdd);
        System.out.println("Server started:"+ iAdd);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketAddress remoteAdd = server.receive(buffer);
        buffer.flip();
        int limit = buffer.limit();
        byte[] bytes = new byte[limit];
        buffer.get(bytes,0,limit);
        String msg = new String(bytes);
        System.out.println("client at" + remoteAdd + ",send:" + msg);
        server.send(buffer,remoteAdd);
        server.close();
    }
}
