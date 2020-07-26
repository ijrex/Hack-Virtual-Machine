package commandlib.command;

import commandlib.command.util.*;
import commandlib.command.memorylocation.*;

public class PopCommand extends Command {

  protected String popLocation;
  protected String popTemp;

  public PopCommand(String[] argVars) {
    super(argVars);
    popLocation = Util.parseTemplateFile("pop-location.asm");
    popTemp = Util.parseTemplateFile("pop-temp.asm");
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