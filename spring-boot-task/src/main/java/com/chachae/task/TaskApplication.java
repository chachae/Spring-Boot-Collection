package com.chachae.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author chachae
 * @since 2020/1/11 17:26
 */
@SpringBootApplication
@EnableScheduling
public class TaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(TaskApplication.class);
  }
}
