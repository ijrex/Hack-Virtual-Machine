package readwrite;

import loadfile.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import commandlib.CommandLib;

import readwrite.util.*;

public class ReadWrite {
  public static void main(LoadFiles files, CommandLib commandLib, boolean bootstrap) {

    ArrayList<File> sourceFiles = Util.getOrderedFiles(files.getFiles());

    int currentFile = 0;

    try {
      String outputFile = Util.getOutputFilePath(files.getDirectoryPath());

      FileWriter fileWriter = new FileWriter(outputFile, false);

      fileWriter.write(commandLib.init(bootstrap));

      for (File sourceFile : sourceFiles) {

        Scanner fileScanner = new Scanner(sourceFile);

        String functionName = Util.getFileName(sourceFile.getName());

        while (fileScanner.hasNextLine()) {
          String line = fileScanner.nextLine();

          line = Util.trimExcess(line);

          if (line.length() > 0) {
            fileWriter.write(commandLib.write(line, functionName));
          }
        }

        fileScanner.close();

        currentFile++;
      }
      fileWriter.close();

      System.out.println(outputFile);

    } catch (IOException e) {
      System.out.println("An error occured parsing " + sourceFiles.get(currentFile).getName());
      e.printStackTrace();
      System.exit(1);
    }
  }
}