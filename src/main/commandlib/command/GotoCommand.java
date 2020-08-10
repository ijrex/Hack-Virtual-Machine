package commandlib.command;

public class GotoCommand extends Command {

  public GotoCommand(String[] argVars, Boolean _isFunctionDept) {
    super(argVars, _isFunctionDept);
  }

  public String[] write(String[] args, int linePos, String functionName) {
    String parsedOutput = functionName + "$" + args[0];

    String[] parsedOutputArr = parsedOutput.split("\n");

    return parsedOutputArr;
  }

}