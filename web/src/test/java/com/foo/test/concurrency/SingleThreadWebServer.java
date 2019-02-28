package com.foo.test.concurrency;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Fooisart
 * @date 20:37 27-02-2019
 */
public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
//            handleRequest(connection);
        }
    }
}
