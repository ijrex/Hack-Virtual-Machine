package commandlib.command;

import java.util.ArrayList;
import commandlib.command.util.*;

public class PushCommand extends Command {

  protected ArrayList<String> pushConstant = new ArrayList<String>();
  protected ArrayList<String> pushLocation = new ArrayList<String>();

  public PushCommand(String[] inputVars) {
    super(inputVars);
    pushConstant = parseTemplateFile("push-const.asm");
    pushLocation = parseTemplateFile("push-loc.asm");
  }

  public ArrayList<String> write(String[] args, int linePos) {
    ArrayList<String> parsedOutput = new ArrayList<String>();

    String pushType = args[1];

    switch (pushType) {
      case "constant":
        parsedOutput = parseArithmetic(pushConstant, args, linePos);
        break;
      case "argument":
      case "local":
      case "temp":
      case "that":
      case "this":
        parsedOutput = parseArithmetic(pushLocation, args, linePos);
      default:
        break;
    }
    return parsedOutput;

  }

  private ArrayList<String> parseArithmetic(ArrayList<String> templateFile, String[] args, int linePos) {
    ArrayList<String> parsedOutput = new ArrayList<String>();

    templateFile.forEach((line) -> {
      String parsedLine = "";
      parsedLine = Util.parseArgs(args, vars, line);
      parsedLine = Util.mapMemoryVals(parsedLine);
      parsedOutput.add(parsedLine);
    });

    return parsedOutput;
  }

}