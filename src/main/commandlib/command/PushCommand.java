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
        parsedOutput = Util.parsePushPop(pushConstant, args, vars, linePos);
        break;
      case "argument":
      case "local":
      case "that":
      case "this":
        parsedOutput = Util.parsePushPop(pushLocation, args, vars, linePos);
        break;
      case "temp":
        parsedOutput = Util.parsePushPop(pushTemp, args, vars, linePos);
        break;
      default:
        break;
    }
    return parsedOutput;

  }
}