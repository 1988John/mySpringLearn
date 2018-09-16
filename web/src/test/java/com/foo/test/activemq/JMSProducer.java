package com.foo.test.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMapMessage;

import javax.jms.*;

/**
 * 消息生产者
 */
public class JMSProducer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;//默认的连接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认的连接密码
    private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;//默认的连接地址
    private static final int SENDNUM = 2;//发送的消息数量

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = null;//连接工厂
        Connection connection = null;//连接
        Session session = null;//会话，接受或者发送消息的线程
        Destination destination = null;//消息的目的地
        MessageProducer messageProducer = null;//消息的生产者
        //实例化连接工厂(指定连接用户名｜密码｜连接地址)
        connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BROKERURL);
        try {
            connection = connectionFactory.createConnection();//通过连接工厂获取连接
            connection.start();//启动连接

            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);//创建session
            destination = session.createQueue("TestQueue2");//创建消息队列
            messageProducer = session.createProducer(destination);//创建消息生产者
            sendMessage(session, messageProducer);//发送消息
            session.commit();

            User user = new User();
            user.setAge(0);
            user.setName("");




        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //发送消息
    private static void sendMessage(Session session, MessageProducer messageProducer) {
        try {
            //创建消息Map<key,value>
            MapMessage message = session.createMapMessage();
            message.setString("userName", "syf");
            message.setInt("age", 30);
            message.setDouble("salary", 1000);
            message.setBoolean("isGirl", true);
            System.out.println("Sending:" + ((ActiveMQMapMessage)message).getContentMap());
            //发送消息
            messageProducer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}