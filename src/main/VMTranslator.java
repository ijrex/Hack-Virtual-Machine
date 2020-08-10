import loadfile.*;
import java.io.File;

import commandlib.*;
import readwrite.*;

class VMAssembler {

	public static void main(String[] args) {

		LoadFile file = new LoadFile("BasicLoop.vm", "vm", "test-files");
		File sourceFile = file.getFile();

		CommandLib commandLib = new CommandLib();

		ReadWrite.main(sourceFile, commandLib);

	}
}
