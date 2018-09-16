package com.foo.test.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMapMessage;

import javax.jms.*;

public class JMSConsumerByListener {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;//默认的连接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认的连接密码
    private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;//默认的连接地址

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = null;//连接工厂
        Connection connection = null;//连接
        Session session = null;//会话，接受或者发送消息的线程
        Destination destination = null;//消息的目的地
        MessageConsumer messageConsumer = null;//消息的消费者
        //实例化连接工厂(指定连接用户名｜密码｜连接地址)
        connectionFactory = new ActiveMQConnectionFactory(JMSConsumerByListener.USERNAME, JMSConsumerByListener.PASSWORD, JMSConsumerByListener.BROKERURL);
        try {
            connection = connectionFactory.createConnection();//通过连接工厂获取连接
            connection.start();//启动连接
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//创建session
            destination = session.createQueue("TestQueue2");//创建连接的消息队列(TestQueue:生产者队列名)
            messageConsumer = session.createConsumer(destination);//创建消息消费者
            messageConsumer.setMessageListener(new JMSListener());//注册消息监听
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}