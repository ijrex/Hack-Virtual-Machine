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

  public static String parseArgs(String[] args, String[] vars, String str) {
    String parsedStr = str;

    for (int i = 0; i < vars.length; i++) {
      if (vars[i] != null) {
        String regex = "\\$V\\$_" + vars[i] + "_\\$V\\$";
        parsedStr = parsedStr.replaceAll(regex, args[i + 1]);
      }

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

  public static ArrayList<String> parsePushPop(ArrayList<String> templateFile, String[] args, String[] vars,
      int linePos) {
    ArrayList<String> parsedOutput = new ArrayList<String>();

    templateFile.forEach((line) -> {
      String parsedLine = "";
      parsedLine = parseArgs(args, vars, line);
      parsedLine = mapMemoryVals(parsedLine);
      parsedOutput.add(parsedLine);
    });

    return parsedOutput;
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
      case ("@temp"):
        return "@R5";
      default:
        return line;
    }
  }

}