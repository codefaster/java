package pr1.tests;

import java.util.Collection;
import java.util.HashSet;


public class ColTest {
static int [] values = {1,2,3,4,5,6,7};
	
	public static boolean contains (int value) {
		if ((value == 2) | (value == 4) | (value == 5)) {
			return true;
		}
		return false;
	}
	
	public static void main(String [] args) {
		Collection <Integer> c1 = new HashSet<Integer>();
		for (int value : values) {
			if (contains(value)) {
				c1.add(value);
			}
		}
		Object [] a1 = new Integer[c1.size()];
		int i = 0;
		for (int value : c1) {
			a1[i] = value;
			i++;
		}
	}
}
