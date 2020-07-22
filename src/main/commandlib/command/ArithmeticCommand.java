package commandlib.command;

import commandlib.command.util.*;

public class ArithmeticCommand extends Command {

  public ArithmeticCommand(String arg, String name) {
    super(arg, name);
  }

  public String write(String[] args, int linePos) {
    String parsedOutput = output;

    parsedOutput = Util.parseCommands(linePos, output);

    String regex = "\\$_ARITHMETIC_LIB_\\$";
    parsedOutput = parsedOutput.replaceAll(regex, "ARITHMETIC_" + name.toUpperCase());

    return parsedOutput;
  }

}