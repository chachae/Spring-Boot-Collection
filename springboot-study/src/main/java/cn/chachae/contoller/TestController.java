package cn.chachae.contoller;

import cn.chachae.test.SystemProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @date 2019/12/14 11:04
 */
@RestController
@RequestMapping("test")
public class TestController {

  private final SystemProperties properties;

  @Autowired
  public TestController(SystemProperties properties) {
    this.properties = properties;
  }

  @GetMapping("proper")
  public String properties() {
    return properties.getShiro().getAnonApi();
  }
}
