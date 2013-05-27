package pr1.a10;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import pr1.qad.DirtyFileReader;

public class StringUtil {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		String[] testStrings = createTestStrings01();
		int testIndex = 0;
		out.println("Teststrings: Upper cases: "
				+ getUpperCaseCount(testStrings[testIndex]));
		out.println("Teststrings: Whitespace Ratio: "
				+ getRatioWhitespace(testStrings[testIndex]));
		File inputFile = new File("ethics.txt");
		out.println("<" + inputFile.getName() + "> Upper cases: "
				+ getUpperCaseCount(inputFile));
		out.println("<" + inputFile.getName() + "> Whitespace Ratio: "
				+ getRatioWhitespace(inputFile));
	}

	public static int getUpperCaseCount(String s) {
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				counter++;
			}
		}
		return counter;
	}

	public static double getRatioWhitespace(String s) {
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isWhitespace(s.charAt(i))) {
				counter++;
			}
		}
		double ratio = (double) s.length() / (double) counter;
		if (counter == 0) {
			ratio = 0;
		}
		return ratio;
	}

	public static String[] createTestStrings01() {
		String[] test = { "Au Bau Sau", "AuBauSau", "au bau sau", "aubausau",
				"AUBAUSAU", "au b b s d a" };
		return test;
	}

	public static int getUpperCaseCount(File textfile) {
		DirtyFileReader textReader = new DirtyFileReader(textfile);
		Scanner in = new Scanner(textReader);
		int globalCounter = 0;
		while (in.hasNext()) {
			globalCounter += getUpperCaseCount(in.next());
		}
		in.close();
		textReader.close();
		return globalCounter;
	}

	public static double getRatioWhitespace(File textfile) {
		DirtyFileReader textReader = new DirtyFileReader(textfile);
		Scanner in = new Scanner(textReader);
		double whiteRatio = 0;
		int lineCount = 0;
		while (in.hasNextLine()) {
			String currentLine = in.nextLine();
			if (!(currentLine.isEmpty())) {
				lineCount++;
				whiteRatio += getRatioWhitespace(currentLine);
			}
		}
		whiteRatio /= lineCount;
		in.close();
		textReader.close();
		return whiteRatio;
	}
}
