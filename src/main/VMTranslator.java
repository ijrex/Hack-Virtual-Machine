import loadfile.*;
import java.io.File;

class VMAssembler {

	public static void main(String[] args) {

		LoadFile file = new LoadFile("SimpleAdd.vm", "vm");
		File sourceFile = file.getFile();

		// FilePass.main(sourceFile);
	}
}
