package commandlib.command.util;

import commandlib.command.memorylocation.*;

public class Parse {

  public static String[] commands(int linePos, int blockHeight, String[] strArr) {
    String[] parsedOutputArr = strArr;

    String regex = "\\$C\\$_END_OF_BLOCK_\\$C\\$";
    int endOfBlock = linePos + blockHeight + 1;

    for (int i = 0; i < parsedOutputArr.length; i++) {
      parsedOutputArr[i] = parsedOutputArr[i].replaceAll(regex, Integer.toString(endOfBlock));
    }

    return parsedOutputArr;
  }

  public static String args(String[] args, String[] argVars, String str) {
    String parsedStr = str;

    for (int i = 0; i < argVars.length; i++) {
      if (argVars[i] != null) {
        String regex = "\\$V\\$_" + argVars[i] + "_\\$V\\$";
        parsedStr = parsedStr.replaceAll(regex, args[i + 1]);
      }
    }

    return parsedStr;
  }

  public static String staticArgs(String[] args, String str) {
    return str.replaceAll("\\$S\\$_STATIC_\\$S\\$", "vmfilename." + args[2]);
  }

  public static String[] pushPop(String templateFile, String[] args, String[] argVars, MemoryLocation pushPopType) {
    String parsedOutput = "";

    parsedOutput = args(args, argVars, templateFile);

    if (pushPopType == MemoryLocation.STATIC) {
      parsedOutput = staticArgs(args, parsedOutput);
    }

    String[] parsedOutputArr = parsedOutput.split("\n");

    for (int i = 0; i < parsedOutputArr.length; i++) {
      parsedOutputArr[i] = MemoryLocation.getValueFromType(parsedOutputArr[i]);
    }

    return parsedOutputArr;
  }
}