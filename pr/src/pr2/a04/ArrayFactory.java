package pr2.a04;

import java.util.Arrays;
import java.util.Random;

public class ArrayFactory {
	public static void main(String[] args) {
		int[] testus = createTestArray(10, 10, true);
		System.out.println(searchBinaryFor(testus, 3));
	}

	public static int[] createTestArray(int nrElements, int maxValue,
			boolean isSorted) {
		int[] testArray = new int[nrElements];
		Random randomGenerator = new Random();
		for (int i = 0; i < nrElements; i++) {
			testArray[i] = randomGenerator.nextInt(maxValue + 1);
		}
		if (isSorted) {
			Arrays.sort(testArray);
		}
		return testArray;
	}

	public static int searchBinaryFor(int[] arrayOfValues, int valueOfInterest) {
		return searchBinaryFor(arrayOfValues, 0, arrayOfValues.length - 1,
				valueOfInterest);
	}

	public static int searchBinaryFor(int[] arrayOfValues, int minIndex,
			int maxIndex, int valueOfInterest) {
		if (minIndex > maxIndex) {
			return -1;
		}
		int m = (minIndex + maxIndex) / 2;
		if (valueOfInterest == arrayOfValues[m]) {
			return m;
		}
		if (valueOfInterest < arrayOfValues[m]) {
			return searchBinaryFor(arrayOfValues, minIndex, m - 1,
					valueOfInterest);
		}
		return searchBinaryFor(arrayOfValues, m + 1, maxIndex, valueOfInterest);
	}

}
