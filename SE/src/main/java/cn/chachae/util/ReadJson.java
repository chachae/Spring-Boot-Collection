package cn.chachae.util;

import cn.chachae.eneity.Course;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 半自动课表格式化程序，支持JSON
 *
 * @author chachae
 * @date 2019/8/19
 */
public class ReadJson {
  private static String str() {
    String str = "";
    File file =
        new File(
            "D:\\JavaSE_Project\\JavaSE_Base\\10_JSON\\src\\main\\resources\\2017_iot_1_201901_course_1.json");
    try {
      FileInputStream in = new FileInputStream(file);
      // size 为字串的长度 ，这里一次性读完
      int size = in.available();
      byte[] buffer = new byte[size];
      in.read(buffer);
      in.close();
      str = new String(buffer, StandardCharsets.UTF_8);
    } catch (IOException e) {
      return null;
    }
    return str;
  }

  @Test
  public void getCourserAfterConvert() throws JsonProcessingException {
    // 创建objectMapper对象
    ObjectMapper mapper = new ObjectMapper();
    // 调用json文件流读取接方法
    String json = Objects.requireNonNull(ReadJson.str());
    // 将Json封装到Bean
    JavaType collectionType = getCollectionType(mapper, Course.class);
    // 序列化json对象
    List<Course> list = mapper.readValue(json, collectionType);
    // 利用lambda表达式排序方法，按照星期、周次从小到大来排序
    list.sort(
        (o1, o2) -> {
          int a = Integer.parseInt(o1.getXq());
          int b = Integer.parseInt(o2.getXq());
          return Integer.compare(a, b);
        });
    list.sort(
        (o1, o2) -> {
          int a = Integer.parseInt(o1.getZc());
          int b = Integer.parseInt(o2.getZc());
          return Integer.compare(a, b);
        });
    // foreach循环读取Bean列表
    for (Course course : list) {
      // 创建新的Map对象，将需要的键值封装到Map中
      Map<String, String> map = Maps.newHashMap();
      map.put("课程名称", course.getKcmc());
      map.put("任课教师", course.getTeaxms());
      map.put("教学班级", course.getJxbmc());
      map.put("节次", course.getJcdm());
      map.put("星期", course.getXq());
      map.put("周次", course.getZc());
      map.put("教学地点", course.getJxcdmc());
      map.put("课程性质", course.getJxhjmc());
      // 循环输出索引对象的键值对
      for (String key : map.keySet()) {
        String value = map.get(key);
        System.out.println(key + "：" + value);
      }
      System.out.println("################################");
    }
  }

  private static JavaType getCollectionType(ObjectMapper mapper, Class<?>... elementClasses) {
    return mapper.getTypeFactory().constructParametricType(List.class, elementClasses);
  }
}
