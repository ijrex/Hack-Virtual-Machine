package commandlib.command;

import java.util.ArrayList;
import commandlib.command.util.*;

public class PushCommand extends Command {

  protected ArrayList<String> pushConstant = new ArrayList<String>();
  protected ArrayList<String> pushLocation = new ArrayList<String>();
  protected ArrayList<String> pushTemp = new ArrayList<String>();

  public PushCommand(String[] inputVars) {
    super(inputVars);
    pushConstant = parseTemplateFile("push-const.asm");
    pushLocation = parseTemplateFile("push-loc.asm");
    pushTemp = parseTemplateFile("push-tmp.asm");
  }

  public ArrayList<String> write(String[] args, int linePos) {
    ArrayList<String> parsedOutput = new ArrayList<String>();

    String pushType = args[1];

    switch (pushType) {
      case "constant":
        parsedOutput = parsePush(pushConstant, args, linePos);
        break;
      case "argument":
      case "local":
      case "that":
      case "this":
        parsedOutput = parsePush(pushLocation, args, linePos);
        break;
      case "temp":
        parsedOutput = parsePush(pushTemp, args, linePos);
        break;
      default:
        break;
    }
    return parsedOutput;

  }

  private ArrayList<String> parsePush(ArrayList<String> templateFile, String[] args, int linePos) {
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