package commandlib;

import java.util.Map;
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
    commands.put("init_arithmetic", new InitCommand("arithmetic_lib.asm"));

    commands.put("push", new PushCommand(new String[] { "push", "LOCATION", "VALUE" }));
    commands.put("pop", new PopCommand(new String[] { "pop", "LOCATION", "VALUE" }));

    commands.put("add", new ArithmeticCommand("add"));
    commands.put("and", new ArithmeticCommand("and"));
    commands.put("eq", new ArithmeticCommand("eq"));
    commands.put("gt", new ArithmeticCommand("gt"));
    commands.put("lt", new ArithmeticCommand("lt"));
    commands.put("neg", new ArithmeticCommand("neg"));
    commands.put("not", new ArithmeticCommand("not"));
    commands.put("or", new ArithmeticCommand("or"));
    commands.put("sub", new ArithmeticCommand("sub"));

    commands.put("label", new LabelCommand(new String[] { "label", "LABEL_NAME" }, true));
    commands.put("if-goto", new GotoCommand(new String[] { "if-goto", "LABEL_NAME" }, true));
    commands.put("goto", new GotoCommand(new String[] { "goto", "LABEL_NAME" }, true));

    commands.put("function", new FunctionCommand(new String[] { "function", "LABEL_NAME", "ARGS" }));
    commands.put("return", new ReturnCommand("return", true));

  }

  public String init() {
    return handleCommand(commands.get("init_arithmetic"), null, null);
  }

  public String write(String input) {
    String[] args = input.split(" ");

    String commandType = args[0];
    Command command = commands.get(commandType);

    // TODO: TAKE FUNCTION NAME FROM READ-WRITE
    String functionName = "function";

    return handleCommand(command, args, functionName);
  }

  private String handleCommand(Command command, String[] args, String functionName) {

    String[] output;

    if (!command.isFunctionDept) {
      output = command.write(args, linePos);
    } else {
      output = command.write(args, linePos, functionName);
    }

    for (String line : output) {
      if (!line.matches("^\\(.+\\)")) {
        linePos += 1;
      }
    }

    return String.join("\n", output) + "\n";
  }
}