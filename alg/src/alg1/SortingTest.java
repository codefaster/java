package alg1;
import de.beuth.algorithmen.storage.*;

public class SortingTest {
	public static void main (String[] args) {
//		SortingAlgorithm alg = new BubbleSort();
//      SortingAlgorithm alg = new InsertionSort();
//		SortingAlgorithm alg = new QuickSort();
		SortingAlgorithm alg = new MergeSort();
		Sortrunner.runSorting(alg, 100, 0);
	}
}
