package loadfile;

/*

  Search for and load file into program
_____________________________________________________________________
|                 |                                                 |
| PARAMETERS:     |                                                 |
|-----------------|-------------------------------------------------|
|                 |                                                 |
| `arg`           | File to be loaded, with or without extention    |
|                 |   e.g. `xxx.asm` or `xxx`                       |
|                 |                                                 |
| `extensions(s)` | File type(s) to look for as String(s),          |
|                 |   e.g. LoadFile("xxx", {"asm", "asmx"});        |
|                 |   looks for files `xxx.asm` and `xxx.asmx`      |
|                 |   e.g. LoadFile("xxx.asm", "asm");              |
|                 |   First confirms query `xxx.asm` is of type     |
|                 |   `.asm` and then looks for file                |
|                 |                                                 |
| `dir`           | (Optional) Specify directory to look for file   |
|                 |   e.g. LoadFile("xxx", "yyy", "zzz");           |
|                 |   looks recursively for files in `/zzz`         |
|                 |   e.g. LoadFile("xxx", "yyy");                  |
|                 |   A non-recursive search is performed in `./`   |                
|_________________|_________________________________________________|

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import loadfile.util.*;

public class LoadFile {

  File sourceFile;

  public LoadFile(String arg, String extention) {
    String[] extentions = new String[] { extention };
    this.load(arg, null, extentions);
  }

  public LoadFile(String arg, String[] extentions) {
    this.load(arg, null, extentions);
  }

  public LoadFile(String arg, String extention, String dir) {
    String[] extentions = new String[] { extention };
    this.load(arg, dir, extentions);
  }

  public LoadFile(String arg, String[] extentions, String dir) {
    this.load(arg, dir, extentions);
  }

  public File getFile() {
    return this.sourceFile;
  }

  private void load(String arg, String dir, String[] extentions) {
    try {

      ArrayList<String> searchFiles = new ArrayList<String>();

      if (!Util.argHasFileExtention(arg)) {
        for (String extention : extentions) {
          searchFiles.add(arg + "." + extention);
        }
      } else {
        Util.checkCorrectExtension(arg, extentions);
        searchFiles.add(arg);
      }

      Boolean recursive = false;
      String path = "";
      if (dir != null) {
        recursive = true;
        path = dir;
      }

      File searchDir = new File(path);

      this.searchForSourceFile(searchFiles, searchDir, recursive);

      if (sourceFile == null) {
        throw new FileNotFoundException();
      }

    } catch (FileNotFoundException e) {
      String path = "";
      if (dir != null) {
        path = "/" + dir + "/**/*";
      }

      String error = "ERROR: File \"" + arg + "\" could not be found\n";
      error += "ERROR (continued): File types: " + Arrays.toString(extentions) + "\n";
      error += "ERROR (continued): Search directory: \"" + System.getProperty("user.dir") + path + "\"";

      System.out.println(error);
      e.printStackTrace();
      System.exit(1);
    }
  }

  private void searchForSourceFile(ArrayList<String> fileNames, File dir, Boolean recursive) {
    File[] list = dir.listFiles();
    if (list != null) {
      for (File file : list) {
        if (!recursive) {
          if (fileNames.contains(file.getName())) {
            sourceFile = file;
          }
        } else {
          if (file.isDirectory()) {
            searchForSourceFile(fileNames, file, recursive);
          } else if (fileNames.contains(file.getName())) {
            sourceFile = file;
          }
        }
      }
    }
  }
}