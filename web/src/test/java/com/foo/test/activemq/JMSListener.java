package com.foo.test.activemq;

import org.apache.activemq.command.ActiveMQMapMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
/**
 * 消息监听
 * */
public class JMSListener implements MessageListener{
    public void onMessage(Message message) {
        try {
            System.out.println("receive Message:"+((ActiveMQMapMessage)message).getContentMap());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}