package cn.chachae.util;

import cn.hutool.core.lang.Console;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author chachae
 * @date 2019/12/9 14:46
 */
public class JsonUtil {
  private static ObjectMapper objectMapper = new ObjectMapper();

  // 加载Jackson配置
  static {
    // config
    // 在反序列化时忽略在 json 中存在但 Java 对象不存在的属性
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    // 在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    // 在序列化时忽略值为 null 的属性
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    // 忽略值为默认值的属性
    objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
  }

  /**
   * obj转String
   *
   * @param src 传入参数
   * @param <T> 类型
   * @return 返回String
   */
  public static <T> String obj2String(T src) {
    if (src == null) {
      return null;
    }
    try {
      return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
    } catch (Exception e) {
      Console.error("parse object to String exception, error: {}", e.toString());
      return null;
    }
  }

  /**
   * String转obj,反序列化
   *
   * @param src 传入参数
   * @param typeReference 对进行泛型的反序列化，使用TypeReference可以明确的指定反序列化的类型，
   * @param <T> 类型
   * @return obj
   */
  @SuppressWarnings("unchecked")
  public static <T> T string2Obj(String src, TypeReference<T> typeReference) {
    if (src == null || typeReference == null) {
      return null;
    }
    try {
      return (T)
          (typeReference.getType().equals(String.class)
              ? src
              : objectMapper.readValue(src, typeReference));
    } catch (Exception e) {
      Console.error(
          "parse String to Object exception, String:{}, TypeReference<T>:{}, error:{}",
          src,
          typeReference.getType(),
          e);
      return null;
    }
  }
}
