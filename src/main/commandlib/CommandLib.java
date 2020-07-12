package commandlib;

/*

  Library of VM commands
_______________________________________________________________________________________________
|                                                                                              |
|   The `commands` table stores templates to translate VM commands into ASM machine language.  |
|______________________________________________________________________________________________|
|                                                                                              |
|   The following example describes how a VM command gets installed into the library:          |
|                                                                                              |
|   e.g. VM Command: `push ARG1 ARG2`                                                          |
|                                                                                              |
|   1. Command described in table:                                                             | 
|      `commands.put("push", new Command("push", new String[] { "ARG1", "ARG2" }));`           |
|                                                                                              |
|   2. ASM template `push.{asm,xasm}` loaded from `../../lib/command-lib/push.{asm,xasm}`      |
|                                                                                              |
|   3. `{ "ARG1", "ARG2" }` implicitly describe the relationship between variables             |
|       in `.xasm templates`                                                                   |
|                                                                                              |
|       e.g. The variable ###ARG1### in the `.asmx` file is a placeholder for `ARG1`           |
|       in the constructor.                                                                    |
|______________________________________________________________________________________________|

*/

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

import commandlib.command.*;
import commandlib.commandtype.*;

public class CommandLib {

  private Map<String, Command> commands = new HashMap<String, Command>();

  public CommandLib() {

    this.assignCommandDescriptions();
  }

  private void assignCommandDescriptions() {
    // INIT
    commands.put("init", new Command(CommandType.TODO, "init"));

    // PUSH POP
    commands.put("push", new Command(CommandType.C_PUSH, "push", new String[] { "LOCATION", "VALUE" }));

    // ARITHMETIC
    commands.put("add", new Command(CommandType.C_ARITHMETIC, "add"));
    // commands.put("sub", new Command("sub"));
    // commands.put("neg", new Command("neg"));
    // commands.put("eq", new Command("eq"));
    // commands.put("gt", new Command("gt"));
    // commands.put("lt", new Command("lt"));
    // commands.put("and", new Command("and"));
    // commands.put("or", new Command("or"));
    // commands.put("not", new Command("not"));
  }

  public String write(String input, int linePos) {
    String[] args = input.split(" ");

    String commandType = args[0];
    Command command = commands.get(commandType);

    String[] vars = Arrays.copyOfRange(args, 1, args.length);

    return command.write(vars, linePos);
  }

  public int getLineLength(String input) {
    String[] args = input.split(" ");

    String commandType = args[0];
    Command command = commands.get(commandType);
    return command.lineLength;
  }
}