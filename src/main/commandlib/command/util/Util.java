package commandlib.command.util;

import java.util.ArrayList;

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

  public static String parseArgs(String args[], ArrayList<String> vars, String str) {
    String parsedStr = str;

    for (int i = 0; i < vars.size(); i++) {
      String regex = "\\$V\\$_" + vars.get(i) + "_\\$V\\$";
      parsedStr = parsedStr.replaceAll(regex, args[i + 1]);
    }

    return parsedStr;
  }

  public static String parseCommands(int linePos, int blockHeight, String str) {
    String parsedStr = str;

    String regex = "\\$C\\$_END_OF_BLOCK_\\$C\\$";
    int endOfBlock = linePos + blockHeight + 1;

    parsedStr = parsedStr.replaceAll(regex, Integer.toString(endOfBlock));

    return parsedStr;
  }

  public static String mapMemoryVals(String line) {
    switch (line) {
      case ("@local"):
        return "@R1";
      case ("@argument"):
        return "@R2";
      case ("@this"):
        return "@R3";
      case ("@that"):
        return "@R4";
      default:
        return line;
    }
  }

}