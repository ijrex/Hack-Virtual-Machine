package commandlib.command;

import commandlib.command.util.*;

public class ArithmeticCommand extends Command {

  public ArithmeticCommand(String name) {
    super(name);
    output = Util.loadTemplateFile("./lib/command-library/arithmetic/arithmetic.asm");
  }

  public String[] write(String[] args, int linePos) {
    String parsedOutput = output;

    String regex = "\\$_ARITHMETIC_LIB_\\$";
    parsedOutput = output.replaceAll(regex, "ARITHMETIC_" + name.toUpperCase());

    String[] parsedOutputArr = parsedOutput.split("\n");

    parsedOutputArr = Parse.commands(linePos, parsedOutputArr.length, parsedOutputArr);

    return parsedOutputArr;
  }

}