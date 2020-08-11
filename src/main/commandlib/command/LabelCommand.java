package commandlib.command;

public class LabelCommand extends Command {

  public LabelCommand(String[] argVars, Boolean _isFunctionDept) {
    super(argVars, _isFunctionDept);
  }

  public String[] write(String[] args, int linePos, String functionName) {
    String parsedOutput = "(" + functionName + "$" + args[1] + ")";

    String[] parsedOutputArr = parsedOutput.split("\n");

    return parsedOutputArr;
  }
}