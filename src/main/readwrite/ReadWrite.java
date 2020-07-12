package readwrite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import commandlib.CommandLib;

import readwrite.util.*;

public class ReadWrite {
  public static void main(File sourceFile, CommandLib commandLib) {
    try {
      Scanner fileScanner = new Scanner(sourceFile);

      String outputFile = Util.getOutputFilePath(sourceFile);
      FileWriter fileWriter = new FileWriter(outputFile, false);

      fileWriter.write(commandLib.write("init", 0)); // INIT ARITHMETIC

      int linePos = 16;

      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();

        line = Util.trimExcess(line);

        if (line.length() > 0) {
          linePos += commandLib.getLineLength(line);
          fileWriter.write(commandLib.write(line, linePos));
        }
      }

      fileScanner.close();
      fileWriter.close();

      System.out.println(outputFile);

    } catch (IOException e) {
      System.out.println("An error occured parsing " + sourceFile.getName());
      e.printStackTrace();
      System.exit(1);
    }
  }
}