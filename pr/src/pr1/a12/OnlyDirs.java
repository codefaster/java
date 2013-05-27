package pr1.a12;

import java.io.FileFilter;
import java.io.File;

public class OnlyDirs implements FileFilter {
	public boolean accept(File dir) {
		return dir.isDirectory();
	}
}
