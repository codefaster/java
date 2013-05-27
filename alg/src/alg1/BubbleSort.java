package alg1;
import java.io.PrintWriter;

import de.beuth.algorithmen.storage.*;
public class BubbleSort implements SortingAlgorithm {

	public void sort(Storage s) {
		int m = s.length()-1;
		while (m > 0) {
				for (int i = 0; i < m ; i++) {
					int current = s.get(i);
					if (s.inRelation(current,s.get(i+1))) {
						s.set(i, s.get(i+1));
						s.set(i + 1, current);
					}
				}
			m--;
		}
	}
}
