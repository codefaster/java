// - Enth??lt File Konversionskonstruktoren bzw Factorymethoden?
// Konversionskonstruktoren:
// File ( String pathname ) 
// File ( String parent, String child ) 
// File ( URI uri )
//
// Statische Factorymethoden:
// createTempFile
// listRoots()

// - Eigenschaften einer Methodenverbundklasse
// Die Methode createTempFile ist z.B. eine statische Methode. 
// Sie erzeugt eine Tempor??re Datei im Dateisystem und gibt den 
// Pfadnamen zur??ck. Durch die Erzeugung des Fileobjektes, 
// qualifiziert sie sich als Factorymethode - dadurch
// erkl??ren sich die ??berlappenden Eigenschaften mit einer
// Methodenverbundklasse.

package pr1.a12;

import java.io.File;
import java.io.*;
import java.io.PrintWriter;

public class DirContent {
	final static String PATH1 = "/";
	final static String PATH2 = "/Users/jacurrospatonio";
	final static String PATH3 = "/Users/jacurrospatonio/Documents";
	final static int COL_NUMBER = 5;
	final static int COL_SPACING = 30;

	public static void main(String[] args) {
		toOut("**************************");
		toOut("---> PATH 1 ROUTINES");
		toOut("**************************");
		toOut();
		printAll(new File(PATH1));
		toOut();
		printFilesOnly(new File(PATH1));
		toOut();
		printDirsOnly(new File(PATH1));
		toOut();

		toOut("**************************");
		toOut("---> PATH 2 ROUTINES");
		toOut("**************************");
		toOut();
		printAll(new File(PATH2));
		toOut();
		printFilesOnly(new File(PATH2));
		toOut();
		printDirsOnly(new File(PATH2));
		toOut();

		toOut("**************************");
		toOut("---> PATH 3 ROUTINES");
		toOut("**************************");
		toOut();
		printAll(new File(PATH3));
		toOut();
		printFilesOnly(new File(PATH3));
		toOut();
		printDirsOnly(new File(PATH3));
	}

	public static void printAll(File path) {
		toOut(">>> PRINTING ALL FROM PATH >" + path.getPath());
		toOut();
		colOut(path.list());
	}

	public static void printAll(String path) {
		toOut(">>> PRINTING ALL FROM PATH >" + path);
		toOut();
		colOut(new File(path).list());
	}

	public static void printFilesOnly(File path) {
		toOut(">>> PRINTING FILES FROM PATH >" + path.getPath());
		toOut();
		FileFilter fileFilter = new OnlyFiles();
		colOut(path, fileFilter);
	}

	public static void printDirsOnly(File path) {
		toOut(">>> PRINTING DIRS FROM PATH >" + path.getPath());
		toOut();
		FileFilter dirFilter = new OnlyDirs();
		colOut(path, dirFilter);
	}

	public static void colOut(String[] input) {
		colOut(input, COL_NUMBER, COL_SPACING);
	}

	public static void colOut(File input, FileFilter filter) {
		colOut(input, filter, COL_NUMBER, COL_SPACING);
	}

	public static void colOut(File input, FileFilter filter, int cols,
			int spacing) {
		int size = input.listFiles(filter).length;
		String[] forPrint = new String[size];
		int i = 0;
		for (File tempFile : input.listFiles(filter)) {
			forPrint[i] = tempFile.getName(); 
			i++;
		}
		colOut(forPrint, cols, spacing);
	}

	public static void colOut(String[] input, int cols, int spacing) {
		int elements = 1;
		while (elements < input.length) {
			StringBuilder formatInstr = new StringBuilder();
			for (int i = 0; i < cols; i++) {
				if (elements < input.length) {
					elements++;
					formatInstr.append("%" + elements + "$-" + spacing + "s ");
				}
			}
			toOut(String.format(formatInstr.toString(), input));
		}
	}

	public static void toOut(String[] input) {
		for (String activeBoy : input) {
			toOut(activeBoy);
		}
	}

	public static void toOut() {
		PrintWriter out = new PrintWriter(System.out, true);
		toOut("", out);
	}

	public static void toOut(String input) {
		PrintWriter out = new PrintWriter(System.out, true);
		toOut(input, out);
	}

	public static void toOut(String inputDoIt, PrintWriter outDoIt) {
		outDoIt.println(inputDoIt);
	}
}