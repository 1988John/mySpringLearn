package com.foo.web.controller.ws;

import org.apache.shiro.session.Session;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
 
import javax.servlet.http.HttpServletRequest;
 
import java.util.Map;
 
/**
 * 拦截器
 * 
 * @author wangguan,
 * @date 2017年11月22日 上午9:33:46,
 * @version argType
 */
 
public class HandshakeInterceptor implements org.springframework.web.socket.server.HandshakeInterceptor{
    Session session;
    // 初次握手访问前
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse serverHttpResponse,
            WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        if (request instanceof ServletServerHttpRequest) {
            HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
            String sessionId=servletRequest.getSession().getId();//获取浏览器的sessionid
            String username=(String)servletRequest.getSession().getAttribute("name");
            System.out.println("获取session里面的name-------------------"+username);
            // 使用userName区分WebSocketHandler，以便定向发送消息
            /* String userName = (String)*/
            //session.getAttribute("WEBSOCKET_USERNAME");
            map.put("WEBSOCKET_USERNAME", username);
            servletRequest.getSession().setAttribute("WEBSOCKET_USERNAME", username);
        }
        return true;
    }
 
    // 初次握手访问后
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse,
            WebSocketHandler webSocketHandler, Exception e) {
 
    }
}
