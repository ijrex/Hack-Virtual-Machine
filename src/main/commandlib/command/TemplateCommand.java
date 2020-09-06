package commandlib.command;

import commandlib.command.util.*;

public class TemplateCommand extends Command {

  public TemplateCommand(String templateFile) {
    super(templateFile);
    output = Util.loadTemplateFile(templateFile);
  }
}