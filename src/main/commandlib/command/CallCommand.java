package commandlib.command;

import commandlib.command.util.*;

public class CallCommand extends Command {

  public CallCommand(String[] argVars) {
    super(argVars);

    output = Util.loadTemplateFile("call.asm");

  }

  public String[] write(String[] args, int linePos, String functionName) {
    String parsedOutput = output;

    String[] parsedOutputArr = parsedOutput.split("\n");

    return parsedOutputArr;
  }
}