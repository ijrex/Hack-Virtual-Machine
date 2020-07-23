package commandlib.command;

import loadfile.LoadFile;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import java.util.ArrayList;

import commandlib.command.util.*;

public class Command {
  protected String name;
  protected ArrayList<String> output = new ArrayList<String>();
  protected ArrayList<String> vars = new ArrayList<String>();

  public Command(String[] inputArgs) {
    this.name = inputArgs[0];

    for (int i = 1; i < inputArgs.length; i++) {
      vars.add(inputArgs[i]);
    }
  }

  public Command(String templateFile, String name) {
    this.name = name;
    output = parseTemplateFile(templateFile);
  }

  public ArrayList<String> write(String[] args, int linePos) {
    return output;
  }

  protected ArrayList<String> parseTemplateFile(String templateFile) {
    String[] types = { "asm", "xasm" };
    LoadFile file = new LoadFile(templateFile, types, "../../lib/command-library");
    File template = file.getFile();

    ArrayList<String> commands = new ArrayList<String>();

    try {
      Scanner scanner = new Scanner(template);

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();

        String trimmedLine = Util.trimExcess(line);

        if (trimmedLine.length() > 0) {
          commands.add(trimmedLine);
        }
      }
      scanner.close();
    } catch (IOException e) {
      System.out.println("ERROR: An error occured while parsing + " + template.getName());
      e.printStackTrace();
      System.exit(1);
    }

    return commands;
  }
}