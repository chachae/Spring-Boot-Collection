package com.chachae.rest.template.server;

import com.chachae.rest.template.server.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author chachae
 * @since 2020/1/11 23:11
 */
@Slf4j
@RestController
@RequestMapping("/rest")
public class TestController {

  private static final String URL = "http://localhost:8080/api/user";

  @Resource private RestTemplate restTemplate;

  /** 普通调用 */
  @GetMapping("/all")
  public String listAll() {
    ResponseEntity<String> res = restTemplate.getForEntity(URL + "/list", String.class);
    log.info("【RestTemplate 调用成功，内容为】：{}", res.getBody());
    return res.getBody();
  }

  /** 占位符 */
  @GetMapping("/id")
  public String getById() {
    ResponseEntity<String> res = restTemplate.getForEntity(URL + "/{id}", String.class, 1);
    log.info("【RestTemplate 调用成功，内容为】：{}", res.getBody());
    return res.getBody();
  }

  /** RequestParam */
  @GetMapping("/delete")
  public String deleteById() {
    // 封装参数，不要替换为map或者HashMap
    MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
    // 支持中文
    params.add("ids", 4);
    params.add("ids", 5);
    params.add("ids", 6);
    ResponseEntity<String> res = restTemplate.postForEntity(URL + "/delete", params, String.class);
    return res.getBody();
  }

  /** RequestBody */
  @GetMapping("/insert")
  public String insert() {
    User user = User.builder().id(8L).name("Nasa").age("22").build();
    ResponseEntity<String> res = restTemplate.postForEntity(URL + "/insert", user, String.class);
    return res.getBody();
  }
}
