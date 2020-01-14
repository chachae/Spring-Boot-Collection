package com.chachae.mq.rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author chachae
 * @since 2020/1/14 10:12
 */
public class ConnectUtil {

  private ConnectUtil() {}

  public static Connection getConnection() {
    Connection connection = null;
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("vm.cn");
    factory.setPort(5672);
    factory.setUsername("guest");
    factory.setPassword("123");
    try {
      connection = factory.newConnection();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return connection;
  }
}
