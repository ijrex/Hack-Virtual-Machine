package commandlib.command;

import java.util.ArrayList;
import commandlib.command.util.*;

public class PopCommand extends Command {

  protected ArrayList<String> pop = new ArrayList<String>();
  protected ArrayList<String> popTemp = new ArrayList<String>();

  public PopCommand(String[] inputVars) {
    super(inputVars);
    pop = parseTemplateFile("pop-loc.asm");
    popTemp = parseTemplateFile("pop-tmp.asm");
  }

  public ArrayList<String> write(String[] args, int linePos) {
    ArrayList<String> parsedOutput = new ArrayList<String>();

    String popType = args[1];

    switch (popType) {
      case "argument":
      case "local":
      case "that":
      case "this":
        parsedOutput = Util.parsePushPop(pop, args, vars, linePos);
        break;
      case "temp":
        parsedOutput = Util.parsePushPop(popTemp, args, vars, linePos);
        break;
      default:
        break;
    }
    return parsedOutput;
  }
}