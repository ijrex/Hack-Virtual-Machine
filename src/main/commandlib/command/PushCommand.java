package commandlib.command;

import commandlib.command.util.*;

public class PushCommand extends Command {

  public PushCommand(String[] args, String[] inputVars) {
    super(args, inputVars);
  }

  public String write(String[] args, int linePos) {
    return Util.parseArgs(args, vars, output);
  }
}