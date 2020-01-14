package com.chachae.mq.rabbitmq.work;

import com.chachae.mq.rabbitmq.util.ConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

// 生产者
public class Send {
  private static final String QUEUE_NAME = "test_work_queue";

  public static void main(String[] argv) throws Exception {
    // 获取到连接
    Connection connection = ConnectUtil.getConnection();
    // 获取通道
    Channel channel = connection.createChannel();
    // 声明队列
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    // 循环发布任务
    for (int i = 1; i <= 50; i++) {
      // 消息内容
      String message = "task .. " + i;
      channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
      System.out.println(" [x] Sent '" + message + "'");

      Thread.sleep(i * 2);
    }
    // 关闭通道和连接
    channel.close();
    connection.close();
  }
}
