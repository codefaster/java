package pr2.a01;

import java.io.PrintWriter;

import pr2.a02.exceptions.IllegalDateException;

public class DateTest {

	public static void main(String[] args) {
		PrintWriter err = new PrintWriter(System.err, true);
		PrintWriter out = new PrintWriter(System.out, true);
		int[][] testdata = {
				{ 1, 5, 2013 },
				{ 29, 2, 2004 }, 	//Schaltjahr
				{ 82, 38, 2013 },	//Completely wrong
				{ 31, 4, 2999 },    //too many days for April
				{ 1, 13, 1999 },    //illegal month
		};
		
		for (int i = 0; i < testdata.length; i++) {
			try {
				Date date = new Date(testdata[i][0],
						testdata[i][1], testdata[i][2]);
				out.printf("%-25s %-10s %n", "Good date:", date.toString());
			} catch (IllegalDateException e) {
				err.printf("%-25s %-10s %n", "Wrong date - your Input:", testdata[i][0] + "."
						+ testdata[i][1] + "." + testdata[i][2]);
				e.printStackTrace();
			}
		}
	}
}
