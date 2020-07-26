package commandlib.command;

import commandlib.command.util.*;
import commandlib.command.memorylocation.*;

public class PushCommand extends Command {

  protected String pushConstant;
  protected String pushLocation;
  protected String pushTemp;

  public PushCommand(String[] argVars) {
    super(argVars);
    pushConstant = Util.parseTemplateFile("push-constant.asm");
    pushLocation = Util.parseTemplateFile("push-location.asm");
    pushTemp = Util.parseTemplateFile("push-temp.asm");
  }

  public String[] write(String[] args, int linePos) {
    String[] parsedOutput = {};

    MemoryLocation pushType = MemoryLocation.getType(args[1]);

    switch (pushType) {
      case CONSTANT:
        parsedOutput = Parse.pushPop(pushConstant, args, argVars);
        break;
      case ARGUMENT:
      case LOCAL:
      case THIS:
      case THAT:
        parsedOutput = Parse.pushPop(pushLocation, args, argVars);
        break;
      case TEMP:
        parsedOutput = Parse.pushPop(pushTemp, args, argVars);
        break;
      default:
        break;
    }
    return parsedOutput;

  }
}