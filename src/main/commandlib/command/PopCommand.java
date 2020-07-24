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
        parsedOutput = parsePop(pop, args, linePos);
        break;
      case "temp":
        parsedOutput = parsePop(popTemp, args, linePos);
        break;
      default:
        break;
    }
    return parsedOutput;
  }

  private ArrayList<String> parsePop(ArrayList<String> templateFile, String[] args, int linePos) {
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