package commandlib.command;

import commandlib.command.util.*;

public class GotoCommand extends Command {

  protected String goTo;
  protected String ifGoTo;

  public GotoCommand(String[] argVars, Boolean _isClassDept) {
    super(argVars, _isClassDept);

    goTo = Util.loadTemplateFile("goto.asm");
    ifGoTo = Util.loadTemplateFile("if-goto.asm");
  }

  public String[] write(String[] args, int linePos, String className) {
    String parsedOutput;

    if (this.name == "goto") {
      parsedOutput = goTo;
    } else {
      parsedOutput = ifGoTo;
    }

    String location = className + "\\$" + args[1];

    String regex = "\\$V\\$_LABEL_\\$V\\$";
    parsedOutput = parsedOutput.replaceAll(regex, location);

    String[] parsedOutputArr = parsedOutput.split("\n");

    return parsedOutputArr;
  }

}