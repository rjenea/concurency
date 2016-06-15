package Lab5_Producer_Consumer;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class FileSystemProcessor {

	public static void main(String[] args) {
		List<File> files = new LinkedList<File>();
		for (String fileName : args) {
			File f = new File(fileName);
			if (f.exists()) {
				files.add(f);
			}
		}

		
		
	}


}
