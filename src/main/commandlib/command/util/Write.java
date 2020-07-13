package commandlib.command.util;

import java.util.ArrayList;

public class Write {
  public static String push(String args[], ArrayList<String> vars, String output) {
    String parsedOutput = output;

    for (int i = 0; i < vars.size(); i++) {
      String regex = "#{3}" + vars.get(i) + "#{3}";
      parsedOutput = parsedOutput.replaceAll(regex, args[i]);
    }

    return parsedOutput;
  }

  public static String arithmetic(String args, String output, int linePos) {
    String parsedOutput = output;

    String regex = "#{3}END_OF_BLOCK#{3}";
    int endOfBlock = linePos + 1;
    parsedOutput = parsedOutput.replaceAll(regex, "@" + endOfBlock);

    return parsedOutput;
  }
}