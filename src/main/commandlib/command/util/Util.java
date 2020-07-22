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

  public static String parseArgs(String args[], ArrayList<String> vars, String output) {
    String parsedOutput = output;

    for (int i = 0; i < vars.size(); i++) {
      String regex = "\\$V\\$_" + vars.get(i) + "_\\$V\\$";
      parsedOutput = parsedOutput.replaceAll(regex, args[i + 1]);
    }

    return parsedOutput;
  }

  public static String parseCommands(int linePos, String output) {
    String parsedOutput = output;

    String regex = "\\$C\\$_END_OF_BLOCK_\\$C\\$";
    int endOfBlock = linePos + 1;

    parsedOutput = parsedOutput.replaceAll(regex, Integer.toString(endOfBlock));

    return parsedOutput;
  }

}