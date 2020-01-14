package com.chachae.mq.rabbitmq.simple;

import com.chachae.mq.rabbitmq.util.ConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author chachae
 * @since 2020/1/14 10:29
 */
public class Send {

  private static final String QUEUE_NAME = "simple_queue";

  private static final String MESSAGE = "Hello RabbitMq";

  public static void main(String[] args) throws Exception {
    // 获取连接
    Connection connection = ConnectUtil.getConnection();
    // 建立通道
    Channel channel = connection.createChannel();
    // 声明【创建】队列
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    // 向指定队列发送消息
    channel.basicPublish("", QUEUE_NAME, null, MESSAGE.getBytes());
    System.out.println(" [x] Sent '" + MESSAGE + "'");
    // 关闭通道和连接
    channel.close();
    connection.close();
  }
}
