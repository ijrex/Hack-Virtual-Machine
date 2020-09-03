import loadfile.*;

import commandlib.*;
import readwrite.*;

class VMAssembler {

	public static void main(String[] args) {

		LoadFiles files = new LoadFiles("test-files/FunctionCalls/FibonacciElement", "vm");

		CommandLib commandLib = new CommandLib();

		ReadWrite.main(files, commandLib, true);

	}
}
