package com.chachae.mq.rabbitmq.fanout;

import com.chachae.mq.rabbitmq.util.ConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

  private static final String EXCHANGE_NAME = "fanout_exchange_test";

  public static void main(String[] argv) throws Exception {
    // 获取到连接
    Connection connection = ConnectUtil.getConnection();
    // 获取通道
    Channel channel = connection.createChannel();

    // 声明exchange，指定类型为fanout
    channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

    // 消息内容
    String message = "I am fine";
    // 发布消息到Exchange
    channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
    System.out.println(" [生产者] Sent '" + message + "'");

    channel.close();
    connection.close();
  }
}
