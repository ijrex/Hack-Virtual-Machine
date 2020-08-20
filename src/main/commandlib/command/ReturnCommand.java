package commandlib.command;

import commandlib.command.util.*;

public class ReturnCommand extends Command {

  public ReturnCommand(String name) {
    super(name);

    output = Util.loadTemplateFile("return.asm");

  }

  public String[] write(String[] args, int linePos, String functionName) {
    String parsedOutput = output;

    String[] parsedOutputArr = parsedOutput.split("\n");

    return parsedOutputArr;
  }
}