package pr1.a04;
import java.io.PrintWriter;
import pr1.qad.DirtyFileReader;
import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

public class FirstInput {

	public static void main ( String args[]) {
		Locale.setDefault(Locale.US);
		//out f???r scannerAusprobieren+printPointsFrom erzeugen.
		PrintWriter out = new PrintWriter(System.out,true);
		
		//Scanner Ausprobieren generiert Zahlen, schreibt sie in Strings
		//und liest sie von dort wieder aus.
		//scannerAusprobieren(out);	
		//out.println("");
		
		//Summe der Zahlen aus GemischteNummern.txt ausgeben mit countSumOf
		out.println("############## countSumOf: ##############");
		stringToScreen("Summe aus Gem. Datei: "+countSumOf("GemischteNummern.txt"));
		out.println("");
		//GemischteNummern.txt wird mit printPointsFrom eingelesen und
		//formartiert ausgegeben.
		DirtyFileReader reader = new DirtyFileReader ("GemischteNummern.txt");
		Scanner in = new Scanner (reader);
		out.println("############## printPointsFrom: ##############");
		printPointsFrom(in,12,4,out);
		in.close();
		out.println("");
		//Ende Aufruf printPointsFrom
		
		//Ein Testdreieckstext mit L???nge 4 wird durch printNumberTriangle ausgegeben.
		out.println("############## Nummerndreieck: ##############");
		printNumberTriangle(4);
		out.println("");
		//String Umkehrung durch reverseString
		out.println("############## reverseString: ##############");
		stringToScreen(reverseString("HALLO Ich bin dein schlechtes Gewissen"));
	}

	public static void stringToScreen(String input) {
		PrintWriter out = new PrintWriter (System.out, true);
		stringToScreen(input,out);
	}
	
	public static void stringToScreen(String inputDoIt, PrintWriter outDoIt) {
		outDoIt.println(inputDoIt);
	}
	
	public static void scannerAusprobieren(PrintWriter out) {
		int KOMMA_STELLE=100;
		int MAX_VALUE_INT=1000;
		//Zufallsgenerator Initalisieren.
		Random randomGenerator = new Random();
		String intNumbers="";
		String doubleNumbers="";
		String mixedNumbers="";
		// 9 Ganze Zahlen generieren
		for (int i=0;i<9;i++) {
			intNumbers+=randomGenerator.nextInt(MAX_VALUE_INT)+" ";
		}
		// 9 Gleitkommazahlen generieren
		for (int i=0;i<9;i++) {
			doubleNumbers+=randomGenerator.nextDouble()*KOMMA_STELLE+" ";
		}
		// 6 Zahlen GZ/GK gemischt generieren.
		for (int i=0;i<6;i++) {
			int zufallsBoy=randomGenerator.nextInt(2);
			if (zufallsBoy==1) {
				//zufallsBoy f???r Alternation zw. double/int-Schleife.
				mixedNumbers+=randomGenerator.nextInt(MAX_VALUE_INT)+" ";
			} else {
				mixedNumbers+=randomGenerator.nextDouble()*KOMMA_STELLE+" ";
			}
		}
		// Scannt Zahlen aus vorher generierten Strings.
		Scanner intInput = new Scanner (intNumbers);
		stringToScreen("Integernummern: ");
		while (intInput.hasNext()) {
			if (intInput.hasNextInt()) {
				int intWert=intInput.nextInt();
				stringToScreen("Integer: "+intWert);
			}
		}
		intInput.close();
		stringToScreen("");
		stringToScreen("Double Nummern: ");
		Scanner doubleInput = new Scanner (doubleNumbers);
		while (doubleInput.hasNext()) {
			if (doubleInput.hasNextDouble()) {
				double doubleWert=doubleInput.nextDouble();
				stringToScreen("Double: "+doubleWert);
			}
		}
		doubleInput.close();
		stringToScreen("");
		stringToScreen("Gemischte Nummern: ");
		Scanner mixedInput = new Scanner (mixedNumbers);
		while (mixedInput.hasNext()) {
			if (mixedInput.hasNextInt()) {
				int intWert=mixedInput.nextInt();
				stringToScreen("Integer: "+intWert);
				continue;
			}
			if (mixedInput.hasNextDouble()) {
				double doubleWert=mixedInput.nextDouble();
				stringToScreen("Double: "+doubleWert);
			}
		}
		mixedInput.close();
		stringToScreen("Reading file...");
		stringToScreen("-----");
		// Testfile GemischteNummern lesen und ausgeben. 
		DirtyFileReader reader = new DirtyFileReader ("GemischteNummern.txt");
		Scanner in = new Scanner (reader);
		while (in.hasNext()) {
			if (in.hasNextInt()) {
				int intWert=in.nextInt();
				stringToScreen("Integer: "+intWert);
				continue;
			}
			if (in.hasNextDouble()) {
				double doubleWert=in.nextDouble();
				stringToScreen("Double: "+doubleWert);
				continue;
			}
			String token = in.next();
			stringToScreen("Keine Zahl, sondern: "+token+" erkannt. Evtl kompatibilit???t v. Locale Paramter ???berprfen.");
		}
		in.close();
		reader.close();
	}
	
	public static long countSumOf(String filename) {
		DirtyFileReader reader = new DirtyFileReader (filename);
		Scanner in = new Scanner (reader);
		long sum = countSumOf(in);
		in.close();
		reader.close();
		return sum;
	}
	
	public static long countSumOf(Scanner in) {
		long sum = 0;
		boolean fehlerElemente=false;
		boolean gerundet=false;
		while (in.hasNext()){
			if (in.hasNextInt()) { 
				sum+=in.nextInt();
				continue;
			}
			//Bei Double Wert Runden
			if (in.hasNextDouble()){
				sum+=Math.round(in.nextDouble());
				gerundet=true;
				continue;
			}
			if (in.hasNext()) {
				fehlerElemente=true;
			}
		}
		if (fehlerElemente==true) {
			stringToScreen("Es wurden nicht typengerechte Elemente ignoriert.");
		}
		if (gerundet==true) {
			stringToScreen("Es wurden Fixkommazahlen gerundet.");
		}
		return sum;
	}
	
	public static void printPointsFrom(Scanner in, int width, int precision, PrintWriter out) {
		int counter = 0;
		boolean hasFehlerElemente=false;
		while (in.hasNext()) {
			if (counter == 10 ) {
//				out.println("");
				out.println();
				counter = 0;
			}
			if (in.hasNextInt()) {
				counter++;
				out.printf("% "+width+"d",in.nextInt());
				continue;

			}
			if (in.hasNextDouble()) {
				counter++;
				out.printf("% "+width+"."+precision+"f", in.nextDouble());
				continue;
			}
			in.next();
			hasFehlerElemente=true;
		}
		out.println("");
//		if ( fehlerElemente == true ) {
		if (hasFehlerElemente) {
			out.println("");
			out.println("HINWEIS: Es wurden fehlerhafte Elemente ignoriert. ");
		}
	}

	public static void printNumberTriangle (int n) {
		PrintWriter out = new PrintWriter(System.out,true);
		if ( n>0 && n<10 ) {
			StringBuffer ausgabeString = new StringBuffer();
			for (int i=1;i<=n;i++) {
				ausgabeString.append(i);
				out.printf("%"+n+"s",ausgabeString);
				out.println("");
			}
		}
		else {
			out.println("Ung???ltiger Zahlenbereich.");
		}
	}
	
	public static String reverseString(String original) {
		PrintWriter out = new PrintWriter(System.out,true);
		StringBuffer ausgabeBuffer = new StringBuffer();
		for (int i=original.length()-1;i>=0;i--) {
			char einzelZeichen=original.charAt(i);
			ausgabeBuffer.append(einzelZeichen);
		}
		String ausgabeString=ausgabeBuffer.toString();
		return ausgabeString;

	}
}
