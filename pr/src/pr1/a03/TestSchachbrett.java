//	3B TestSchachbrett									SIMON LISCHKA, 797307
// -----------------------------------------------------------------------------
package pr1.a03;

import java.io.PrintWriter;
import pr1.qad.DirtyFileWriter;

public class TestSchachbrett {

	public static void main (String args[]) {
		//Normale Ausgabe
		printSchachbrett("SchachTestNormal.txt", false); 
		//Reverse Aufruf
		printSchachbrett("SchachBrettReverse.txt",true); 
	}
	
	public static void printSchachbrett(String filename, boolean isReverse) {	
		
		PrintWriter fout = new PrintWriter (new DirtyFileWriter(filename));
		if (isReverse==true) {								
			//Reverse
			pr1.a02.Schachbrett.printSchachbrettReverse(fout);
		} else {
			//Normal
			pr1.a02.Schachbrett.printSchachbrett(fout);
		}
		//Buffer Flushen + Datei Schlie???en.
		fout.flush();									
		fout.close();
	}
}
