package commandlib.command.util;

import loadfile.LoadFile;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Util {
  public static String trimExcess(String str) {
    if (str.length() > 0) {
      int comment = str.indexOf("//");
      if (comment >= 0) {
        str = str.substring(0, comment);
      }
    }
    str = str.replaceAll("\\s+", "");
    return str;
  }

  public static String parseTemplateFile(String templateFile) {
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