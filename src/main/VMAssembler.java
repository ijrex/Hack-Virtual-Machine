import loadfile.*;

import commandlib.*;
import readwrite.*;

class VMAssembler {

	public static void main(String[] args) {

		LoadFiles files = new LoadFiles("args[0]", "vm");

		CommandLib commandLib = new CommandLib();

		ReadWrite.main(files, commandLib, true);

	}
}
