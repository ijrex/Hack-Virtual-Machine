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

  public Command(CommandType type, String name, String templateFile) {
    this.init(type, name, templateFile);
  }

  public Command(CommandType type, String name, String templateFile, String[] inputVars) {
    this.init(type, name, templateFile);

    for (String var : inputVars) {
      vars.add(var);
    }
  }

  private void init(CommandType type, String name, String templateFile) {
    this.type = type;
    this.name = name;
    this.parseTemplateFile(templateFile);
  }

  private void parseTemplateFile(String templateFile) {
    String[] types = { "asm", "xasm" };
    LoadFile file = new LoadFile(templateFile, types, "../../lib/command-library");
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
      case LIB:
        return this.output;
      case C_ARITHMETIC:
        return Write.arithmetic(name, linePos, output);
      default:
        return Write.standard(args, vars, output);
    }
  }
}