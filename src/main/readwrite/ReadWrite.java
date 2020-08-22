package readwrite;

import loadfile.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import commandlib.CommandLib;

import readwrite.util.*;

public class ReadWrite {
  public static void main(LoadFiles files, CommandLib commandLib) {

    File[] sourceFiles = files.getFiles();
    int fileNum = 0;

    try {
      String outputFile = Util.getOutputFilePath(files.getDirectoryPath());
      System.out.println(outputFile);
      FileWriter fileWriter = new FileWriter(outputFile, false);

      fileWriter.write(commandLib.init());

      for (File sourceFile : sourceFiles) {

        Scanner fileScanner = new Scanner(sourceFile);

        while (fileScanner.hasNextLine()) {
          String line = fileScanner.nextLine();

          line = Util.trimExcess(line);

          if (line.length() > 0) {
            fileWriter.write(commandLib.write(line));
          }
        }

        fileScanner.close();

        fileNum++;
      }
      fileWriter.close();

      System.out.println(outputFile);

    } catch (IOException e) {
      System.out.println("An error occured parsing " + sourceFiles[fileNum].getName());
      e.printStackTrace();
      System.exit(1);
    }
  }
}