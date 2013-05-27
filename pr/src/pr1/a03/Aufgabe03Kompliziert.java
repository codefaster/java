package pr1.a03;
import java.io.PrintWriter;
import java.util.Random;

import pr1.qad.DirtyFileWriter;

public class Aufgabe03Kompliziert {

		public static void main (String args[]) {
			
			
			
			//writeIntNumberFile("Test.txt",829);
			writeMixedNumberFile("test.txt",821,12);
		}
		
		public static void writeIntNumberFile(String filename, int numberCount) {
			PrintWriter out = new PrintWriter (System.out, true);
			if (numberCount%2==0) {
				PrintWriter fout = new PrintWriter (new DirtyFileWriter(filename));
				writeIntNumberFile(filename, numberCount, fout, out);
			}
			else {
				out.println("FEHLER: Keine Gerade numberCount Zahl ???bergeben.");
			}
				
		}
		
		public static void writeMixedNumberFile(String filename, int numberCount, int width) {
			PrintWriter out = new PrintWriter (System.out, true);
			if (width>2&&width<13) {
			PrintWriter fout = new PrintWriter (new DirtyFileWriter(filename));
			writeMixedNumberFile(filename,numberCount,width,fout,out);
			}
			else {
				out.println("Die Feldl???nge >width< ist ung???ltig. "
				+"Bitte Wert zw. >2 und <13 eingeben.");
			}
		}
		
		public static void writeIntNumberFile(String filename, int numberCount, PrintWriter fout, PrintWriter out) {
			
			
			int feldbreite=5;
				
				Random randomGenerator = new Random();
				for (int i=1; i<=numberCount;i++) {
					
					
					
					int breakModulus=i%10;
					boolean doBreak=false;
				
					if ( breakModulus==0) { 
						doBreak=true;
					} else {
						doBreak=false;
					}
					
				
					fout.printf("%"+feldbreite+ "d ",randomGenerator.nextInt(1000));
					out.printf("%"+feldbreite+ "d ",randomGenerator.nextInt(1000));
					out.println(doBreak);
					
					if (doBreak==true) {
						fout.println("");
					}
				
				}
			fout.flush();
			fout.close();
			
			
			
		}
		
		public static void writeMixedNumberFile(String filename, int numberCount, int width, PrintWriter fout, PrintWriter out) {
			Random randomGenerator = new Random();
			int intPool=1;
			int intRandom=0;
			double doubleRandom=0.0;
			
			for (int x=1;x<width;x++) { // Integer pool
				intPool=intPool*10;
			}
			
			for (int i=1; i<=numberCount;i++) {
				
				
				
					int breakModulus=i%10;
					
					
					int zufallsBoy = randomGenerator.nextInt(2);
					//int zufallsBoy=0;
					if (zufallsBoy==1) {	//zufallsBoy f. zuf???llige Alternation zw. double/int-Schleife.
					
					
					
						doubleRandom=randomGenerator.nextDouble()*10;
						fout.printf("%-"+width+ "."+(width-2)+"f ",doubleRandom);
						
						
					} else {
						
						intRandom=randomGenerator.nextInt(intPool);
						fout.printf("%-"+width+ ".0f ",(double)intRandom);
						//out.printf("%-"+width+ "d",intRandom);
					}
				
					if ( breakModulus==0) { 
					fout.println("");
					} else {
						//
					}
					
					
					
			}	
			fout.flush();
			fout.close();
			
		}
		
		/*
		public static void writeMixedNumberFile(String filename, int numberCount, int width, PrintWriter fout, PrintWriter out) {
			
			Random randomGenerator = new Random();
			
			for (int i=1; i<=numberCount;i++) {
				
				
				
				int breakModulus=i%10;
				boolean doBreak=false;
			
				if ( breakModulus==0) { 
					doBreak=true;
				} else {
					doBreak=false;
				}
				
				
				

					int laengeVorKomma=1+randomGenerator.nextInt(width-1); 
					long dbFaktorKommaStelle=1;
					int kommaStelle=width-laengeVorKomma-2; 
					int zufallsBoy=randomGenerator.nextInt(2);				
					double dbZufallsZahl=randomGenerator.nextDouble();

					if (kommaStelle<=0) {
						kommaStelle++;
						laengeVorKomma--;
					}

					for (int x=1;x<=laengeVorKomma;x++) {
						dbFaktorKommaStelle=dbFaktorKommaStelle*10;
					}

					dbZufallsZahl*=Double.valueOf(dbFaktorKommaStelle);

					if (zufallsBoy==1) {	//zufallsBoy f. zuf???llige Alternation zw. double/int-Schleife.
						out.printf("%"+width+ "."+kommaStelle+"f ",dbZufallsZahl);
					} else {

						
						int intZahlenLaenge=1;

						for (int x=1;x<width;x++) { // Integer pool
							intZahlenLaenge=intZahlenLaenge*10;
						}
						
						int intZufallsZahl=randomGenerator.nextInt(intZahlenLaenge);
						out.printf("%-"+width+ ".0f ",(double)intZufallsZahl);
					}
					if (doBreak==true){
						out.println("");
					}
					
				}
			}
			
		*/
}
