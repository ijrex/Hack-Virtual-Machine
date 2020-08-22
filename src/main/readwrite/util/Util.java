package readwrite.util;

import java.util.ArrayList;
import java.io.File;

public class Util {
  public static String getOutputFilePath(String pathName) {
    String fileName = pathName.substring(pathName.lastIndexOf("/"));
    return pathName + fileName + ".asm";
  }

  public static String getFileName(String fileName) {
    return fileName.substring(0, fileName.lastIndexOf("."));
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

  public static ArrayList<File> getOrderedFiles(File[] files) {

    ArrayList<File> orderedFiles = new ArrayList<File>();

    for (File file : files) {
      if (file.getName().matches("Sys.vm")) {
        orderedFiles.add(file);
        break;
      }
    }

    for (File file : files) {
      if (!orderedFiles.contains(file)) {
        orderedFiles.add(file);
      }
    }

    return orderedFiles;
  }
}