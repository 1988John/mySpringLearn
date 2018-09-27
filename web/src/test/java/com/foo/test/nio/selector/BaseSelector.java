//package com.foo.test.nio.selector;
//
//import org.junit.Test;
//
//import java.io.IOException;
//import java.nio.channels.SelectionKey;
//import java.nio.channels.Selector;
//import java.util.Iterator;
//import java.util.Set;
//
///**
// * @author jiangwang3
// * @date 2018/8/28.
// */
//public class BaseSelector {
//    @Test
//    public void test() throws IOException {
//        Selector selector = Selector.open();
//
//        channel.configureBlocking(false);
//
//        SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
//
//
//        while(true) {
//
//            int readyChannels = selector.select();
//
//            if(readyChannels == 0) continue;
//
//
//            Set<SelectionKey> selectedKeys = selector.selectedKeys();
//
//            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
//
//            while(keyIterator.hasNext()) {
//
//                SelectionKey key = keyIterator.next();
//
//                if(key.isAcceptable()) {
//                    // a connection was accepted by a ServerSocketChannel.
//
//                } else if (key.isConnectable()) {
//                    // a connection was established with a remote server.
//
//                } else if (key.isReadable()) {
//                    // a channel is ready for reading
//
//                } else if (key.isWritable()) {
//                    // a channel is ready for writing
//                }
//
//                keyIterator.remove();
//            }
//        }
//    }
//}
