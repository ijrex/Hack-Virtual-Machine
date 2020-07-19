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
  private int linePos;

  public CommandLib() {
    linePos = -1;
    this.assignCommandDescriptions();
  }

  private void assignCommandDescriptions() {
    commands.put("init_arithmetic", new Command(CommandType.LIB, null, "arithmetic_lib.asm"));

    commands.put("push", new Command(CommandType.C_PUSH, null, "push.asm", new String[] { "LOCATION", "VALUE" }));

    commands.put("add", new Command(CommandType.C_ARITHMETIC, "add", "arithmetic.asm"));
    commands.put("and", new Command(CommandType.C_ARITHMETIC, "and", "arithmetic.asm"));
    commands.put("eq", new Command(CommandType.C_ARITHMETIC, "eq", "arithmetic.asm"));
    commands.put("gt", new Command(CommandType.C_ARITHMETIC, "gt", "arithmetic.asm"));
    commands.put("lt", new Command(CommandType.C_ARITHMETIC, "lt", "arithmetic.asm"));
    commands.put("neg", new Command(CommandType.C_ARITHMETIC, "neg", "arithmetic.asm"));
    commands.put("not", new Command(CommandType.C_ARITHMETIC, "not", "arithmetic.asm"));
    commands.put("or", new Command(CommandType.C_ARITHMETIC, "or", "arithmetic.asm"));
    commands.put("sub", new Command(CommandType.C_ARITHMETIC, "sub", "arithmetic.asm"));
  }

  public String init() {
    linePos += commands.get("init_arithmetic").lineLength;
    return commands.get("init_arithmetic").write(null, linePos);
  }

  public String write(String input) {
    String[] args = input.split(" ");

    String commandType = args[0];
    Command command = commands.get(commandType);

    String[] vars = Arrays.copyOfRange(args, 1, args.length);

    linePos += command.lineLength;
    return command.write(vars, linePos);
  }
}