package com.foo.web.controller;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 该注解用来指定一个URI，客户端可以通过这个URI来连接到WebSocket。 相当于SpringMVC的@RequestMapping("/*")注解
 * 
 * @author higher2016
 * @2016-12-28
 */
@ServerEndpoint("/echo")
public class EchoController {

    private static final Logger logger = LoggerFactory.getLogger(EchoController.class);

    private static final String GUEST_PREFIX = "Guest";
    private static final AtomicInteger connectionIds = new AtomicInteger(0);
    private static final Set<EchoController> connections = new CopyOnWriteArraySet<EchoController>();

    private final String nickname;
    private Session session;

    public EchoController() {
        nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
    }

    @OnOpen
    public void start(Session session) {
        this.session = session;
        connections.add(this);
        String message = String.format("* %s %s", nickname, "has joined.");
        broadcast(message);
    }

    @OnClose
    public void end() {
        connections.remove(this);
        String message = String.format("* %s %s", nickname, "has disconnected.");
        broadcast(message);
    }
        
    /**
     * 收到客户端消息后调用的方法
     * 
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void incoming(String message) {
        String filteredMessage = String.format("%s: %s", nickname, message);
        broadcast(filteredMessage);
    }

    @OnError
    public void onError(Throwable t) throws Throwable {
        logger.error("Chat Error: " + t.toString(), t);
    }

    private static void broadcast(String msg) {
        for (EchoController client : connections) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
                logger.debug("Chat Error: Failed to send message to client", e);
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                }
                String message = String.format("* %s %s", client.nickname, "has been disconnected.");
                broadcast(message);
            }
        }
    }
}