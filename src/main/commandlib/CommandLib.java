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
    commands.put("bootstrap", new TemplateCommand("../lib/command-library/sys/bootstrap.asm"));

    commands.put("lib_arithmetic", new TemplateCommand("../lib/command-library/arithmetic/lib_arithmetic.asm"));

    commands.put("push", new PushCommand(new String[] { "push", "LOCATION", "VALUE" }, true));
    commands.put("pop", new PopCommand(new String[] { "pop", "LOCATION", "VALUE" }, true));

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
    commands.put("call", new CallCommand(new String[] { "call", "LABEL_NAME", "ARGS" }));
    commands.put("return", new ReturnCommand("return"));

  }

  public String init(boolean boostrap) {
    if (boostrap) {
      return handleCommand(commands.get("bootstrap"), null, null);
    } else {
      return "";
    }
  }

  public String lib() {
    return handleCommand(commands.get("lib_arithmetic"), null, null);
  }

  public String write(String input, String className) {
    String[] args = input.split(" ");

    String commandType = args[0];
    Command command = commands.get(commandType);

    return handleCommand(command, args, className);
  }

  private String handleCommand(Command command, String[] args, String className) {

    String[] output;

    if (!command.isClassDept) {
      output = command.write(args, linePos);
    } else {
      output = command.write(args, linePos, className);
    }

    for (String line : output) {
      if (!line.matches("^\\(.+\\)")) {
        linePos += 1;
      }
    }

    return String.join("\n", output) + "\n";
  }
}