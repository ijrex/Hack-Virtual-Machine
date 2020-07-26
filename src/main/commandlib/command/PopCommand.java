package commandlib.command;

import commandlib.command.util.Parse;
import commandlib.command.memorylocation.*;

public class PopCommand extends Command {

  protected String popLocation;
  protected String popTemp;

  public PopCommand(String[] argVars) {
    super(argVars);
    popLocation = parseTemplateFile("pop-location.asm");
    popTemp = parseTemplateFile("pop-temp.asm");
  }

  public String[] write(String[] args, int linePos) {
    String[] parsedOutput = {};

    MemoryLocation popType = MemoryLocation.getType(args[1]);

    switch (popType) {
      case ARGUMENT:
      case LOCAL:
      case THIS:
      case THAT:
        parsedOutput = Parse.pushPop(popLocation, args, argVars);
        break;
      case TEMP:
        parsedOutput = Parse.pushPop(popTemp, args, argVars);
        break;
      default:
        break;
    }
    return parsedOutput;
  }
}