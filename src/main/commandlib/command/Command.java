package commandlib.command;

import loadfile.LoadFile;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import commandlib.command.util.*;

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

  protected String parseTemplateFile(String templateFile) {
    String[] types = { "asm", "xasm" };
    LoadFile file = new LoadFile(templateFile, types, "../../lib/command-library");
    File template = file.getFile();

    String parsedOutput = "";

    try {
      Scanner scanner = new Scanner(template);

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();

        String trimmedLine = Util.trimExcess(line);

        if (trimmedLine.length() > 0) {
          parsedOutput += trimmedLine + "\n";
        }
      }
      scanner.close();
    } catch (IOException e) {
      System.out.println("ERROR: An error occured while parsing + " + template.getName());
      e.printStackTrace();
      System.exit(1);
    }

    return parsedOutput;
  }
}