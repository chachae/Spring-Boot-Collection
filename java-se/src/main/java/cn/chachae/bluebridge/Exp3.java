package cn.chachae.bluebridge;

import org.junit.Test;

import java.io.*;

/**
 * @author chachae
 * @date 2019/9/26 22:04
 */
public class Exp3 {

  private final String path = new File("").getAbsolutePath() + "/io/test.txt";;

  @Test
  public void test2() {}

  @Test
  public void test() {
    try {
      FileWriter fw = new FileWriter(path);
      fw.write("test\n");
      fw.write("test2");
      fw.append(" 123");
      fw.flush();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test3() throws Exception {

    FileReader read = new FileReader(path);
    BufferedReader bf = new BufferedReader(read);
    String str;
    while ((str = bf.readLine()) != null) {
      System.out.println(str);
    }
    read.close();
    bf.close();
  }

  public static void main(String[] args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      System.out.println(br.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
