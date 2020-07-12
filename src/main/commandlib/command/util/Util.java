package commandlib.command.util;

public class Util {
  public static String trimExcess(String str) {
    if (str.length() > 0) {
      int comment = str.indexOf("//");
      if (comment >= 0) {
        str = str.substring(0, comment);
      }
    }
    str = str.replaceAll("\\s+", "");
    return str;
  }
}