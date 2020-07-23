package commandlib;

import java.util.Map;
import java.util.HashMap;

import commandlib.command.*;

import java.util.ArrayList;

public class CommandLib {

  private Map<String, Command> commands = new HashMap<String, Command>();
  private int linePos;

  public CommandLib() {
    linePos = -1;
    this.assignCommandDescriptions();
  }

  private void assignCommandDescriptions() {
    commands.put("init_arithmetic", new Command("arithmetic_lib.asm", null));

    commands.put("push", new PushCommand(new String[] { "push", "LOCATION", "VALUE" }));
    commands.put("pop", new PopCommand(new String[] { "pop", "LOCATION", "VALUE" }));

    commands.put("add", new ArithmeticCommand("arithmetic.asm", "add"));
    commands.put("and", new ArithmeticCommand("arithmetic.asm", "and"));
    commands.put("eq", new ArithmeticCommand("arithmetic.asm", "eq"));
    commands.put("gt", new ArithmeticCommand("arithmetic.asm", "gt"));
    commands.put("lt", new ArithmeticCommand("arithmetic.asm", "lt"));
    commands.put("neg", new ArithmeticCommand("arithmetic.asm", "neg"));
    commands.put("not", new ArithmeticCommand("arithmetic.asm", "not"));
    commands.put("or", new ArithmeticCommand("arithmetic.asm", "or"));
    commands.put("sub", new ArithmeticCommand("arithmetic.asm", "sub"));
  }

  public String init() {
    return handleCommand(commands.get("init_arithmetic"), null);
  }

  public String write(String input) {
    String[] args = input.split(" ");

    String commandType = args[0];
    Command command = commands.get(commandType);

    return handleCommand(command, args);
  }

  private String handleCommand(Command command, String[] args) {

    ArrayList<String> out = command.write(args, linePos);
    String parsedOutput = "";

    for (String line : out) {
      parsedOutput += line + "\n";
      if (!line.contains("(")) {
        linePos += 1;
      }
    }

    return parsedOutput;
  }
}