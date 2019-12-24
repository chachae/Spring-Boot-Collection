package cn.chachae.seri;

import cn.hutool.core.lang.Console;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author chachae
 * @date 2019/12/9 14:13
 */
public class SeriTest {

  @Test
  public void out() throws Exception {
    Student student = new Student(2L, "Mike", 10);
    // 序列化
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dir() + "/student.txt"));
    out.writeObject(student);
    out.flush();
    out.close();
    input();
  }

  public void input() throws Exception {
    // 反序列化
    ObjectInputStream input = new ObjectInputStream(new FileInputStream(dir() + "/student.txt"));
    Object obj = input.readObject();
    if (obj instanceof Student) {
      Console.log(obj.toString());
    }
  }

  public String dir() {
    return System.getProperty("user.dir");
  }

  @Test
  public void testIns() {
    String path = System.getProperty("user.dir");
    Console.log(path);
  }
}
