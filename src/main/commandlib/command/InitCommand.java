package commandlib.command;

import commandlib.command.util.*;

public class InitCommand extends Command {

  public InitCommand(String templateFile) {
    super(templateFile);
    output = Util.parseTemplateFile(templateFile);
  }
}