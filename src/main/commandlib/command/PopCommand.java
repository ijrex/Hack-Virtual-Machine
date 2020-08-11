package commandlib.command;

import commandlib.command.util.*;
import commandlib.command.memorylocation.*;

public class PopCommand extends Command {

  protected String popLocation;
  protected String popBase;
  protected String popStatic;

  public PopCommand(String[] argVars) {
    super(argVars);
    popLocation = Util.loadTemplateFile("pop-location.asm");
    popBase = Util.loadTemplateFile("pop-base.asm");
    popStatic = Util.loadTemplateFile("pop-static.asm");
  }

  public String[] write(String[] args, int linePos) {
    String[] parsedOutput = {};

    MemoryLocation popType = MemoryLocation.getType(args[1]);

    switch (popType) {
      case ARGUMENT:
      case LOCAL:
      case THIS:
      case THAT:
        parsedOutput = Parse.pushPop(popLocation, args, argVars, popType);
        break;
      case TEMP:
      case POINTER:
        parsedOutput = Parse.pushPop(popBase, args, argVars, popType);
        break;
      case STATIC:
        parsedOutput = Parse.pushPop(popStatic, args, argVars, popType);
        break;
      default:
        break;
    }
    return parsedOutput;
  }
}