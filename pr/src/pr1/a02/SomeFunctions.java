package pr1.a02;

import java.io.PrintWriter;

public class SomeFunctions {

	public static void main (String args[]) {
		PrintWriter out = new PrintWriter ( System.out, true);
		out.println("Der Kreisumfang mit Radius 3 ergibt: "+kreisUmfang(3));
		out.println("Der Kreisumfang mit Radius 2 ergibt: "+kreisUmfang(2));
		out.println("Der Rechteckumfang mit Seiten a=2, b=2 ergibt: "+rechteckUmfang(2,2));
		out.println("Der Rechteckumfang mit Seiten a=3, b=5 ergibt: "+rechteckUmfang(3,5));
		out.println("Die Rechteckfl???che mit Seiten a=2, b=2 ergibt: "+rechteckFlaeche(2,2));
		out.println("Die Rechteckfl???che mit Seiten a=5, b=6 ergibt: "+rechteckFlaeche(5,6));
	}

	public static double kreisUmfang(double radius) {
		double ergebnis=2*Math.PI*radius;
		return ergebnis;	
	}

	public static double rechteckUmfang(double a, double b) {
		double ergebnis=2*(a+b);
		return ergebnis;
	}

	public static double rechteckFlaeche(double a, double b) {
		double ergebnis=a*b;
		return ergebnis;
	}
	
}
