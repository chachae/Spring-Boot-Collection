package cn.chachae.test;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author chachae
 * @date 2019/12/14 10:57
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:test.properties"})
@ConfigurationProperties(prefix = "sys")
public class SystemProperties {
  private ShiroProperties shiro = new ShiroProperties();
}
