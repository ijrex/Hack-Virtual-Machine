package commandlib.command;

public abstract class Command {
  protected String name;
  protected String output;
  protected String[] argVars = new String[3];

  public Command(String[] _argVars) {
    this.name = _argVars[0];

    for (int i = 1; i < argVars.length; i++) {
      argVars[i - 1] = _argVars[i];
    }
  }

  public Command(String name) {
    this.name = name;
  }

  public String[] write(String[] args, int linePos) {
    return output.split("\n");
  }
}