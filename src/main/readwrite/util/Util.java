package readwrite.util;

import java.io.File;

public class Util {
  public static String getOutputFilePath(File file) {
    String filePath = file.getAbsolutePath();
    filePath = filePath.substring(0, filePath.lastIndexOf("."));

    return filePath + ".asm";
  }

  public static String trimExcess(String str) {
    if (str.length() > 0) {
      int comment = str.indexOf("//");
      if (comment >= 0) {
        str = str.substring(0, comment);
      }
    }
    str = str.trim();
    return str;
  }
}