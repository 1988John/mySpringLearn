package com.foo.test.base.selector;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorDemo {
   public static void main(String[] args) throws IOException {
      String demo_text = "This is a demo String";	
      Selector selector = Selector.open();
      ServerSocketChannel serverSocket = ServerSocketChannel.open();
      serverSocket.bind(new InetSocketAddress("localhost", 5454));
      serverSocket.configureBlocking(false);
      serverSocket.register(selector, SelectionKey.OP_ACCEPT);

      ByteBuffer buffer = ByteBuffer.allocate(256);
      while (true) {
         selector.select();
         Set<SelectionKey> selectedKeys = selector.selectedKeys();
         Iterator<SelectionKey> iter = selectedKeys.iterator();
         while (iter.hasNext()) {
            SelectionKey key = iter.next();
            int interestOps = key.interestOps();
            System.out.println(interestOps);
            if (key.isAcceptable()) {
               SocketChannel client = serverSocket.accept();
               client.configureBlocking(false);
               client.register(selector, SelectionKey.OP_READ);
            }
            if (key.isReadable()) {
               SocketChannel client = (SocketChannel) key.channel();
               client.read(buffer);
               if (new String(buffer.array()).trim().equals(demo_text)) {
                  client.close();
                  System.out.println("Not accepting client messages anymore");
               }
               buffer.flip();
               client.write(buffer);
               buffer.clear();
            }
            iter.remove();
         }
      }
   }
}