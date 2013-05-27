
package pr1.a02;

import java.io.PrintWriter;


public class Schachbrett {
	
	public static void main(String args[]){

		printSchachbrett();
		printSchachbrettReverse();
	}
	
	public static void printSchachbrett() {
		PrintWriter out = new PrintWriter ( System.out,true);
		printSchachbrett(out);
		out.println();
	}

	public static void printSchachbrettReverse() {
		PrintWriter out = new PrintWriter ( System.out,true);
		printSchachbrettReverse(out);
		out.println();
	}
	
	
	public static void printSchachbrett(PrintWriter out) {
	
		for (char feld='H';feld>='A';feld--){
			for (int i=1;i<=8;i++){
				out.print(feld+""+i+" ");		
			}
			out.println();
		}
	
	}
	
	public static void printSchachbrettReverse(PrintWriter out) {
		
		for (char feld='A';feld<='H';feld++){
			for (int i=8;i>=1;i--){
				out.print(feld+""+i+" ");			
			}
			out.println();
		}
	
	}
}
