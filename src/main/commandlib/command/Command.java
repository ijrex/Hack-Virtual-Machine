package commandlib.command;

import loadfile.LoadFile;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import commandlib.command.util.*;
import commandlib.commandtype.*;

public class Command {

  public int lineLength = 0;
  public CommandType type;
  public String name;

  private String output = "";
  private ArrayList<String> vars = new ArrayList<String>();

  public Command(CommandType type, String name) {
    this.type = type;
    this.parseTemplateFile(name);
  }

  public Command(CommandType type, String name, String[] inputVars) {
    this.type = type;
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

        String trimmedLine = Util.trimExcess(line);

        if (trimmedLine.length() > 0) {
          output += trimmedLine + "\n";

          if (!trimmedLine.contains("(")) {
            lineLength++;
          }
        }
      }
      scanner.close();
    } catch (IOException e) {
      System.out.println("ERROR: An error occured while parsing + " + template.getName());
      e.printStackTrace();
      System.exit(1);
    }
  }

  public String write(String[] args, int linePos) {

    switch (type) {
      case INIT:
        return this.output;
      case C_ARITHMETIC:
        return Write.arithmetic(name, output, linePos);
      case C_PUSH:
        return Write.push(args, vars, output);
      default:
        return "TODO: PARSE THIS COMMAND\n";
    }
  }
}