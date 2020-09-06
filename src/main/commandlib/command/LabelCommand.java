package commandlib.command;

public class LabelCommand extends Command {

  public LabelCommand(String[] argVars, Boolean _isClassDept) {
    super(argVars, _isClassDept);
  }

  public String[] write(String[] args, int linePos, String className) {
    String parsedOutput = "(" + className + "$" + args[1] + ")";

    String[] parsedOutputArr = parsedOutput.split("\n");

    return parsedOutputArr;
  }
}