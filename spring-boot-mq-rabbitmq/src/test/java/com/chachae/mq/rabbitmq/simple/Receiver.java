package com.chachae.mq.rabbitmq.simple;

import com.chachae.mq.rabbitmq.util.ConnectUtil;
import com.rabbitmq.client.*;

/**
 * @author chachae
 * @since 2020/1/14 10:29
 */
public class Receiver {

  private static final String QUEUE_NAME = "simple_queue";

  public static void main(String[] args) throws Exception {

    Connection connection = ConnectUtil.getConnection();
    // 创建通道
    Channel channel = connection.createChannel();
    // 声明队列
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    // 定义消费行为
    DefaultConsumer consumer =
        new DefaultConsumer(channel) {
          @Override
          public void handleDelivery(
              String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
            // 模拟发生异常【此时消息队列中的消息会被消费】
            int i = 1 / 0;
            // body 即消息体
            String msg = new String(body);
            System.out.println(" [x] received : " + msg + "!");
          }
        };
    // 监听队列，第二个参数：是否自动进行消息确认。
    channel.basicConsume(QUEUE_NAME, true, consumer);
  }
}
