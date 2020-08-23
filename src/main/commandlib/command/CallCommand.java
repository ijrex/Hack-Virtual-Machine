package commandlib.command;

import commandlib.command.util.*;

public class CallCommand extends Command {

  public CallCommand(String[] argVars) {
    super(argVars);

    output = Util.loadTemplateFile("call.asm");

  }

  public String[] write(String[] args, int linePos) {
    String parsedOutput = output;

    String returnAddress = "RET_ADDRESS_" + Integer.toString(linePos);
    String regex1 = "\\$V\\$_RETURN_ADDRESS_\\$V\\$";
    parsedOutput = parsedOutput.replaceAll(regex1, returnAddress);

    String regex2 = "\\$V\\$_ARGS_\\$V\\$";
    parsedOutput = parsedOutput.replaceAll(regex2, args[2]);

    String regex3 = "\\$V\\$_FUNCTION_NAME_\\$V\\$";
    parsedOutput = parsedOutput.replaceAll(regex3, args[1]);

    String[] parsedOutputArr = parsedOutput.split("\n");

    return parsedOutputArr;
  }
}