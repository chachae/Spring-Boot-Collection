package cn.chachae.util;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author chachae
 * @date 2019/8/18
 */
public class ReadUtil {

  public static String readJsonFile(String fileName) {
    String jsonStr = "";
    try {
      File jsonFile = new File(fileName);
      FileReader fileReader = new FileReader(jsonFile);

      Reader reader = new InputStreamReader(new FileInputStream(jsonFile), StandardCharsets.UTF_8);
      int ch = 0;
      StringBuffer sb = new StringBuffer();
      while ((ch = reader.read()) != -1) {
        sb.append((char) ch);
      }
      fileReader.close();
      reader.close();
      jsonStr = sb.toString();
      return jsonStr;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static Reader getJsonFile(String fileName)
      throws FileNotFoundException, UnsupportedEncodingException {
    String jsonStr = "";
    File jsonFile = new File(fileName);
    FileReader fileReader = new FileReader(jsonFile);
    return new InputStreamReader(new FileInputStream(jsonFile), StandardCharsets.UTF_8);
  }
}
