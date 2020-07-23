package commandlib.command;

import java.util.ArrayList;

import commandlib.command.util.*;

public class ArithmeticCommand extends Command {

  public ArithmeticCommand(String arg, String name) {
    super(arg, name);
  }

  public ArrayList<String> write(String[] args, int linePos) {
    ArrayList<String> parsedOutput = new ArrayList<String>();

    String regex = "\\$_ARITHMETIC_LIB_\\$";

    output.forEach((line) -> {
      String parsedLine = "";
      parsedLine = line.replaceAll(regex, "ARITHMETIC_" + name.toUpperCase());
      parsedLine = Util.parseCommands(linePos, output.size(), parsedLine);
      parsedOutput.add(parsedLine);
    });

    return parsedOutput;
  }

}