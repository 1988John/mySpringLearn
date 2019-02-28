package com.foo.test.concurrency;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Fooisart
 * @date 20:37 27-02-2019
 */
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
//                    handleRequest(connection);
                }
            };
            new Thread(task).start();
        }
    }
}
