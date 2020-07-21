package commandlib.command;

import loadfile.LoadFile;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import java.util.ArrayList;

import commandlib.command.util.*;

public class Command {
  protected int blockHeight = 0;
  protected String output = "";
  protected ArrayList<String> vars = new ArrayList<String>();

  public Command(String templateFile, String name) {
    parseTemplateFile(templateFile);
  }

  public Command(String[] templateFiles, String name) {
    for (String templateFile : templateFiles) {
      parseTemplateFile(templateFile);
    }
  }

  public String write(String[] args, int linePos) {
    return output;
  }

  public int getBlockHeight() {
    return this.blockHeight;
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
            blockHeight++;
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
}