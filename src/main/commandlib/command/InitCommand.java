package commandlib.command;

public class InitCommand extends Command {

  public InitCommand(String templateFile) {
    super(templateFile);
    output = parseTemplateFile(templateFile);
  }
}