package commandlib;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

import commandlib.command.*;

public class CommandLib {

  private Map<String, Command> commands = new HashMap<String, Command>();
  private int linePos;

  public CommandLib() {
    linePos = -1;
    this.assignCommandDescriptions();
  }

  private void assignCommandDescriptions() {
    commands.put("init_arithmetic", new Command("arithmetic_lib.asm", null));

    commands.put("push", new PushCommand(new String[] { "push-const.asm", "push-var.asm" }, null));

    commands.put("add", new ArithmeticCommand("arithmetic.asm", "add"));
    commands.put("and", new ArithmeticCommand("arithmetic.asm", "and"));
    commands.put("eq", new ArithmeticCommand("arithmetic.asm", "eq"));
    commands.put("gt", new ArithmeticCommand("arithmetic.asm", "gt"));
    commands.put("lt", new ArithmeticCommand("arithmetic.asm", "lt"));
    commands.put("neg", new ArithmeticCommand("arithmetic.asm", "neg"));
    commands.put("not", new ArithmeticCommand("arithmetic.asm", "mpt"));
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

    String[] vars = Arrays.copyOfRange(args, 1, args.length);

    return handleCommand(command, vars);
  }

  private String handleCommand(Command command, String[] vars) {
    linePos += command.getBlockHeight();
    return command.write(vars, linePos);
  }
}