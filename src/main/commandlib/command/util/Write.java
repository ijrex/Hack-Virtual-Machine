package commandlib.command.util;

import java.util.ArrayList;

public class Write {
  public static String standard(String args[], ArrayList<String> vars, String output) {
    return parseVars(args, vars, output);
  }

  public static String arithmetic(String name, int linePos, String output) {
    String parsedOutput = output;

    parsedOutput = parseCommands(linePos, output);

    String regex = "\\$_ARITHMETIC_LIB_\\$";
    parsedOutput = parsedOutput.replaceAll(regex, "ARITHMETIC_" + name.toUpperCase());

    return parsedOutput;
  }

  private static String parseVars(String args[], ArrayList<String> vars, String output) {
    String parsedOutput = output;

    for (int i = 0; i < vars.size(); i++) {
      String regex = "\\$V\\$_" + vars.get(i) + "_\\$V\\$";
      parsedOutput = parsedOutput.replaceAll(regex, args[i]);
    }

    return parsedOutput;
  }

  private static String parseCommands(int linePos, String output) {
    String parsedOutput = output;

    String regex = "\\$C\\$_END_OF_BLOCK_\\$C\\$";
    int endOfBlock = linePos + 1;

    parsedOutput = parsedOutput.replaceAll(regex, Integer.toString(endOfBlock));

    return parsedOutput;
  }
}