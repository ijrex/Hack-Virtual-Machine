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

public class CommandLib {

  private Map<String, Command> commands = new HashMap<String, Command>();

  public CommandLib() {

    this.assignCommandDescriptions();
  }

  private void assignCommandDescriptions() {
    commands.put("push", new Command("push", new String[] { "LOCATION", "VALUE" }));

    commands.put("add", new Command("add"));
  }

  public String write(String input) {
    String[] args = input.split(" ");

    String commandType = args[0];
    Command command = commands.get(commandType);

    String[] vars = Arrays.copyOfRange(args, 1, args.length);

    return command.write(vars);

  }
}