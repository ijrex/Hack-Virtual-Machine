package commandlib.command;

import loadfile.LoadFile;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Command {

  private String output = "";
  private ArrayList<String> vars = new ArrayList<String>();

  public Command(String name) {
    this.parseTemplateFile(name);
  }

  public Command(String name, String[] inputVars) {
    this.parseTemplateFile(name);

    for (String var : inputVars) {
      vars.add(var);
    }
  }

  private void parseTemplateFile(String name) {
    String[] types = { "asm", "xasm" };
    LoadFile file = new LoadFile(name, types, "../../lib/command-library");
    File template = file.getFile();

    try {
      Scanner scanner = new Scanner(template);

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        output += line;
        if (scanner.hasNextLine())
          output += "\n";
      }
      scanner.close();
    } catch (IOException e) {
      System.out.println("ERROR: An error occured while parsing + " + template.getName());
      e.printStackTrace();
      System.exit(1);
    }
  }

  public String write(String[] args) {
    String parsedOutput = output;

    for (int i = 0; i < vars.size(); i++) {
      String regex = "#{3}" + vars.get(i) + "#{3}";
      parsedOutput = parsedOutput.replaceAll(regex, args[i]);
    }

    return parsedOutput;
  }
}