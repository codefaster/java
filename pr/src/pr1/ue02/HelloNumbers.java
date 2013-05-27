package pr1.ue02;

import java.io.PrintWriter;

public class HelloNumbers {
	
	public static void main(String args[]) {
		PrintWriter out = new PrintWriter(System.out, true);
		out.println(" ?bung 2A -------:");
		someCalculations(out);
		out.println("");
		out.println(" ?bung 2B -------:");
		someMissingRemainders(out); 
		out.println("");
		out.println(" ?bung 2E -------:");
		someExpressions();
		
		
	}
	
	public static void someCalculations(PrintWriter myOut) {
//		float a=4.3f*1.0f/4.3f;
		double a=4.3*1.0/4.3;
		double b=7.0*1.0/7.0;
		int	c=7*1/7;
		int d=300+129;
		double e=300.73+129.82;
		double f=300.73+129.98765432109876543210;

		myOut.println("DB 4.3*1.0/4.3: "+a);
		myOut.println("INT 7.0*1.0/7.0:" +b);
		myOut.println("INT 7*1/7:" +c);
		myOut.println("DB 300+129:" +d);
		myOut.println("DB 300.73+129.82: "+e);
		
		
	}
	

	public static void someMissingRemainders(PrintWriter myOut) {
		int x=7;
		while (x>0) {
			myOut.print(", x: "+x);
			x /=2;
		}
		myOut.println(" ***");
		
		x=19;
		while (x>5 & x!=8) {
			myOut.print("x: "+x);
			x--;
			x = x+3;
			x /=2;
			x = x+3;		
		}
		myOut.println("b b b");
	}
	
	public static void someExpressions() {
			double x=2.2;
			double x1=Math.pow(7, 5); 
			double x2=Math.pow(7,5+3); 
			double x3=Math.pow(7, 5+Math.pow(9, 4));
			double x4=Math.pow(2.0+Math.cos(Math.PI/2.0),2)+3.0/Math.sin(0.32);
			double x5=Math.exp(x)+Math.sin(x)+Math.sqrt(x);
			double x6=Math.sin(x);
			

			double a=1.0; 
			double b=1.0; 
			double c=1.4; 
			double d=1.2;

			PrintWriter out = new PrintWriter (System.out, true);
			out.println("1-- 7^5: "+x1);
			out.println("2-- 7^(5+3): "+x2);
			out.println("3-- 7^(5+9^4): "+x3);
			out.println("4-- (2+cos PI/2)^2+ 3/sin(0,32): "+x4);
			out.println("5-- e^x+sin(x)+sqrt(x): "+x5);
			out.println("6-- sin(x): "+x6);
			out.println("7-- e^sin(sqrt(x)): "+Math.exp(Math.sin(Math.sqrt(x))));
			out.println("8-- Max cd + Max ab: "+Math.max(c, d)+Math.max(a,b));
			out.println("9-- Max abc: "+Math.max(a,Math.max(b,c)));

		
	}
}
