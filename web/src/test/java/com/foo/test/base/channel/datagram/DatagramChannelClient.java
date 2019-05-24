package com.foo.test.base.channel.datagram;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @author fooisart
 * @date 15:20 24-05-2019
 */
public class DatagramChannelClient {
    public static void main(String[] args) throws IOException {
        DatagramChannel client = DatagramChannel.open();
        client.bind(null);

        String msg = "Hello world!";
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
        InetSocketAddress serverAddress = new InetSocketAddress("localhost", 8989);

        client.send(buffer,serverAddress);
        buffer.clear();
        client.receive(buffer);
        buffer.flip();
        client.close();
    }
}
