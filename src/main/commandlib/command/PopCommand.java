package commandlib.command;

import java.util.ArrayList;
import commandlib.command.util.*;

public class PopCommand extends Command {

  protected ArrayList<String> pushConstant = new ArrayList<String>();

  public PopCommand(String[] inputVars) {
    super(inputVars);
    pushConstant = parseTemplateFile("pop.asm");
  }

  public ArrayList<String> write(String[] args, int linePos) {
    ArrayList<String> parsedOutput = new ArrayList<String>();

    pushConstant.forEach((line) -> {
      String parsedLine = "";
      parsedLine = Util.parseArgs(args, vars, line);
      parsedLine = Util.mapMemoryVals(parsedLine);
      parsedOutput.add(parsedLine);
    });

    return parsedOutput;
  }
}