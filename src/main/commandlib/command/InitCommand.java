package commandlib.command;

import java.util.ArrayList;

public class InitCommand extends Command {

  protected ArrayList<String> output = new ArrayList<String>();

  public InitCommand(String templateFile) {
    super(templateFile);
    output = parseTemplateFile(templateFile);
  }

  public ArrayList<String> write(String[] args, int linePos) {
    return output;
  }

}