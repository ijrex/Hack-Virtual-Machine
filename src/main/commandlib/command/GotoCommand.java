package commandlib.command;

import commandlib.command.util.*;

public class GotoCommand extends Command {

  protected String goTo;
  protected String ifGoTo;

  public GotoCommand(String[] argVars, Boolean _isFunctionDept) {
    super(argVars, _isFunctionDept);

    goTo = Util.loadTemplateFile("goto.asm");
    ifGoTo = Util.loadTemplateFile("if-goto.asm");
  }

  public String[] write(String[] args, int linePos, String functionName) {
    String parsedOutput;

    if (this.name == "goto") {
      parsedOutput = goTo;
    } else {
      parsedOutput = ifGoTo;
    }

    String location = functionName + "\\$" + args[1];

    String regex = "\\$V\\$_FUNCTION_NAME_\\$V\\$";
    parsedOutput = parsedOutput.replaceAll(regex, location);

    String[] parsedOutputArr = parsedOutput.split("\n");

    return parsedOutputArr;
  }

}