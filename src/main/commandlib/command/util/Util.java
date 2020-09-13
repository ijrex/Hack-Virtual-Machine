package commandlib.command.util;

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

  public static String loadTemplateFile(String templateFile) {
    File template = new File(templateFile);

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
