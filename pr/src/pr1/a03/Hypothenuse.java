//	3B Hypothenuse										SIMON LISCHKA, 797307
// -----------------------------------------------------------------------------
package pr1.a03;
import java.io.PrintWriter;

import pr1.qad.DirtyFileWriter;

public class Hypothenuse {
	
	public static void main (String args[]) {
		
		PrintWriter out = new PrintWriter (System.out, true);
		PrintWriter fout = new PrintWriter (new DirtyFileWriter("Hypothenuse.txt"));
		//Ausgabe auf Bildschirm
		testHypothenuse(10,2,out);								
		//Ausgabe in Datei Hypothenuse.txt
		testHypothenuse(10,2,fout);								
		//Flushen und Schlie???en.
		fout.flush();											
		fout.close();
	}
	
	public static double hypothenuse(double k1, double k2) {
		
		double ergebnis=Math.sqrt(Math.pow(k1,2)+Math.pow(k2, 2));
		return ergebnis;
	}

	
	public static void printHypothenuse(double k1, double k2, int width, int precision, PrintWriter out) {
		
		out.printf("% "+width+"."+precision+"f",hypothenuse(k1,k2));	
	}


	
	public static void testHypothenuse(int width, int precision, PrintWriter out){
		
		int min=1;
		int max=10;												
		//Tabelle zeichnen
		out.println("|Kathete II| --------------------------------->Kathete I ------------>");
												
		//Spaltenbezeichnung zeichnen		
		for (int colcount=min;colcount<=max;colcount++)			
		{
			if (colcount==min) {
				out.printf("% "+width+".0f",0.0);	
			}
			else {}
			out.printf("% "+width+".0f",Double.valueOf(colcount));
		}
		out.println();
		
		for (int k2count=min;k2count<=max;k2count++) {
			//Zeilen: Werte Kathete 2 ausgeben
			out.printf("% "+width+".0f",Double.valueOf(k2count));
			
			for (int k1count=min;k1count<=max;k1count++) {
			//Spalten: Werte Kathete 1 ausgeben
				printHypothenuse(k1count,k2count,width,precision,out);
			}
			out.println();
		}
	}
}
