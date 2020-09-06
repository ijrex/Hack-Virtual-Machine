package commandlib.command;

import commandlib.command.util.*;
import commandlib.command.memorylocation.*;

public class PushCommand extends Command {

  protected String pushConstant;
  protected String pushLocation;
  protected String pushBase;
  protected String pushStatic;

  public PushCommand(String[] argVars, Boolean _isFunctionDept) {
    super(argVars, _isFunctionDept);
    pushConstant = Util.loadTemplateFile("push-constant.asm");
    pushLocation = Util.loadTemplateFile("push-location.asm");
    pushBase = Util.loadTemplateFile("push-base.asm");
    pushStatic = Util.loadTemplateFile("push-static.asm");
  }

  public String[] write(String[] args, int linePos, String functionName) {
    String[] parsedOutput = {};

    MemoryLocation pushType = MemoryLocation.getType(args[1]);

    switch (pushType) {
      case CONSTANT:
        parsedOutput = Parse.pushPop(pushConstant, args, argVars, pushType, functionName);
        break;
      case ARGUMENT:
      case LOCAL:
      case THIS:
      case THAT:
        parsedOutput = Parse.pushPop(pushLocation, args, argVars, pushType, functionName);
        break;
      case TEMP:
      case POINTER:
        parsedOutput = Parse.pushPop(pushBase, args, argVars, pushType, functionName);
        break;
      case STATIC:
        parsedOutput = Parse.pushPop(pushStatic, args, argVars, pushType, functionName);
        break;
      default:
        break;
    }
    return parsedOutput;

  }
}