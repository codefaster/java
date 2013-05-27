package bs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BerghoffSplitter {
	public static final String regEx = "\\d\\d_.*";
	public static final String inputFile = "bergh.txt";

	public static LinkedList<StringBuilder> buildParts(File f) {
		LinkedList<StringBuilder> parts = new LinkedList<StringBuilder>();
		Scanner sIn = null;
		try {
			sIn = new Scanner(new FileReader(new File(inputFile)));
			StringBuilder sb = new StringBuilder();
			while (sIn.hasNextLine()) {
				String currentLine = sIn.nextLine();
				sb.append(currentLine + "\n");
				if (Pattern.matches(regEx, currentLine)) {
					parts.add(sb);
					sb = new StringBuilder();
				}
			}
		} catch (IOException e) {
		} finally {
			sIn.close();
		}
		return parts;
	}

	public static void writeFile(LinkedList<StringBuilder> list, File f) {
		BufferedWriter sOut = null;
		try {
			int suffix = 0;
			for (StringBuilder s : list) {
				suffix++;
				sOut = new BufferedWriter(new FileWriter(f.getName() + suffix));
				sOut.write(s.toString());
				sOut.close();
			}
		} catch (IOException e) {

		} finally {
			try {
				sOut.close();
			} catch (IOException e) {

			}
		}
	}

	public static void main(String[] args) {
		LinkedList<StringBuilder> tetas = buildParts(new File(inputFile));
		writeFile(buildParts(new File(inputFile)), new File("test.txt"));
	}
}
