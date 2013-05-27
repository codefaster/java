//	3C 													SIMON LISCHKA, 797307
package pr1.a03;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Random;
import pr1.qad.DirtyFileWriter;

public class Aufgabe03 {

		public static void main (String args[]) {
			//Aufruf der Funktionen
			Locale.setDefault(Locale.US);
			writeIntNumberFile("IntegerNummern.txt",2000);
			writeMixedNumberFile("GemischteNummern.txt",2000,10);
		}
		
		public static void writeIntNumberFile(String filename, int numberCount) {
			//writeIntNumber erh???hlt DirtyFileWriter Objekt,
			//wenn die Eingabewerte stimmen, ruft sich selbst auf.
			PrintWriter out = new PrintWriter (System.out, true);
			if (numberCount%2==0) {
			
				PrintWriter fout = new PrintWriter (new DirtyFileWriter(filename));
				writeIntNumberFile(filename, numberCount, fout);
			}
			else {
				//sonst: Fehlermeldung.	
				out.println("FEHLER: Keine Gerade numberCount Zahl eingegeben.");
			}
				
		}
		
		public static void writeMixedNumberFile(String filename, int numberCount, int width) {
			//writeMixedNumberFile erh???hlt DirtyFileWriter Objekt,
			//wenn die Eingabewerte stimmen, ruft sich selbst auf.
			PrintWriter out = new PrintWriter (System.out, true);
			if (width>2&&width<11) {
			
				PrintWriter fout = new PrintWriter (new DirtyFileWriter(filename));
				writeMixedNumberFile(filename,numberCount,width,fout);
			}
			else {
				//sonst: Fehlermeldung.	
				out.println("Die Feldl???nge >width< ist ung???ltig. "
						+"Bitte Wert zw. >2 und <11 eingeben.");
			}
		}
		
		public static void writeIntNumberFile(String filename, int numberCount, PrintWriter fout) {
			// Parameter f???r Zahlenausgabe/Generierung
			int feldbreite=5;
			int randomBereich=1000;
			// Zufallsgenerator init.
			Random randomGenerator = new Random();
			// Gew. Anzahl der Nummern anhand Eingabeparameter numberCount generieren.
			for (int i=1; i<=numberCount;i++) {
				//Zeilenumbruch bei Division durch 10 o. Rest = jede 10. Zeile. 
				int breakModulus=i%10;
				//Ausgabe der Zahl an Datei.
				fout.printf("%"+feldbreite+ "d ",randomGenerator.nextInt(randomBereich));
				//Wenn Zeilenumbruch erreicht, wird er geschrieben.
				if ( breakModulus==0) { 
					fout.println("");
				} else {
				}

			}
			//Datei Flushen+Schlie???en.
			fout.flush();
			fout.close();
		}
		
		public static void writeMixedNumberFile(String filename, int numberCount, int width, PrintWriter fout) {
			// Randomgen init.
			Random randomGenerator = new Random();

			// Variablen initalisieren.

			// Zahlenbereich der Integerwerte
			int intPool=1;
			// Zufallswert Integerwerte
			int intRandom=0;
			// Zufallswert Doublewerte
			double doubleRandom=0.0;

			// Zahlenbereich d. Int aus Feldbreite generieren.
			for (int x=0;x<width;x++) {
				intPool=intPool*10;
			}

			// Gew???nschte Anzahl (numberCount) der Werte generieren+schreiben
			for (int i=1; i<=numberCount;i++) {
				// Zeilenumbruch
				int breakModulus=i%10;
				// Zufallswert f???r Alternation zw. Int/Double Werten
				int zufallsBoy = randomGenerator.nextInt(2);
				// Double generieren und schreiben.
				if (zufallsBoy==1) {	

					doubleRandom=randomGenerator.nextDouble()*10;
					fout.printf("%-"+width+ "."+(width-2)+"f ",doubleRandom);
				} else {
				// sonst: Integer generieren und schreiben	
					intRandom=randomGenerator.nextInt(intPool);
					fout.printf("%-"+width+ ".0f ",(double)intRandom);
				}
				// Zeilenumbruch schreiben.
				if ( breakModulus==0) { 
					
					fout.println("");
				} else {
				}
			}	
			// Datei Flushen und Schlie???en.
			fout.flush();
			fout.close();
		}

}
