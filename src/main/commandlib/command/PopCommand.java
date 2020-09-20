package commandlib.command;

import commandlib.command.util.*;
import commandlib.command.memorylocation.*;

public class PopCommand extends Command {

  protected String popLocation;
  protected String popBase;
  protected String popStatic;

  public PopCommand(String[] argVars, Boolean _isClassDept) {
    super(argVars, _isClassDept);
    popLocation = Util.loadTemplateFile("../lib/command-library/pop/pop-location.asm");
    popBase = Util.loadTemplateFile("../lib/command-library/pop/pop-base.asm");
    popStatic = Util.loadTemplateFile("../lib/command-library/pop/pop-static.asm");
  }

  public String[] write(String[] args, int linePos, String className) {
    String[] parsedOutput = {};

    MemoryLocation popType = MemoryLocation.getType(args[1]);

    switch (popType) {
      case ARGUMENT:
      case LOCAL:
      case THIS:
      case THAT:
        parsedOutput = Parse.pushPop(popLocation, args, argVars, popType, className);
        break;
      case TEMP:
      case POINTER:
        parsedOutput = Parse.pushPop(popBase, args, argVars, popType, className);
        break;
      case STATIC:
        parsedOutput = Parse.pushPop(popStatic, args, argVars, popType, className);
        break;
      default:
        break;
    }
    return parsedOutput;
  }
}