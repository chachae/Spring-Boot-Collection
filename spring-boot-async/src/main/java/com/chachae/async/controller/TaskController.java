package com.chachae.async.controller;

import com.chachae.async.task.TaskFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * @author chachae
 * @since 2020/1/8 9:27
 */
@RestController
@RequestMapping("/task")
public class TaskController {

  private static final String TIP = "请在控制台查看执行情况";
  @Resource private TaskFactory taskFactory;

  @GetMapping("/async")
  public ResponseEntity<String> asyncTask() {
    Future<Boolean> res = taskFactory.asyncTask();
    return ResponseEntity.ok(TIP);
  }

  @GetMapping("/sync")
  public ResponseEntity<String> syncTask() {
    taskFactory.syncTask();
    return ResponseEntity.ok(TIP);
  }
}
