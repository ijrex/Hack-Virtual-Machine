package commandlib.command;

public class ReturnCommand extends Command {

  public ReturnCommand(String name, Boolean _isFunctionDept) {
    super(name, _isFunctionDept);

    output = "return.asm";
  }

  public String[] write(String[] args, int linePos, String functionName) {

    final int FRAME = linePos;

    // String parsedOutput = output;
    String parsedOutput = output;

    String[] parsedOutputArr = parsedOutput.split("\n");

    return parsedOutputArr;
  }
}