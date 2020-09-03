package commandlib.command;

import commandlib.command.util.*;

public class CallCommand extends Command {

  public CallCommand(String[] argVars) {
    super(argVars);

    output = Util.loadTemplateFile("call.asm");

  }

  public String[] write(String[] args, int linePos) {
    String parsedOutput = output;

    String regexArgs = "\\$V\\$_ARGS_\\$V\\$";
    parsedOutput = parsedOutput.replaceAll(regexArgs, args[2]);

    String regexFunc = "\\$V\\$_FUNCTION_NAME_\\$V\\$";
    parsedOutput = parsedOutput.replaceAll(regexFunc, args[1]);

    String[] parsedOutputArr = parsedOutput.split("\n");

    int newLinePos = linePos + parsedOutputArr.length;
    String returnAddress = "RET_ADDRESS_" + Integer.toString(newLinePos);
    String regexRet = "\\$V\\$_RETURN_ADDRESS_\\$V\\$";

    for (int i = 0; i < parsedOutputArr.length; i++) {
      parsedOutputArr[i] = parsedOutputArr[i].replaceAll(regexRet, returnAddress);
    }

    return parsedOutputArr;
  }
}