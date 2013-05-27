package roughdraft;

import java.util.Arrays;

public class FunkyDealer {
	
	public static void printArray(int [] a, String label) {

		printArray(a,-1,-1,-1,label);
	}
	
	public static void printArray(int [] a) {
		printArray(a,-1,-1,-1,"");
	}
	
	public static void printArray(int [] a, int cursor1, int cursor2) {
		printArray(a,-1,cursor1,cursor2,"");
	}
	
	public static void printArray(int [] a, int cursor1) {
		printArray(a,-1,-1,cursor1,"");
	}
	
	
	public static void printArray(int [] a, int cursor1, int cursor2, int cursor3, String label) {
		if (cursor1!=-1 && cursor2!=-1 && cursor3!=-1) {
			for (int i=0; i < a.length; i++) {
				
				StringBuilder sb = new StringBuilder();
				sb.append("<");
				if (i==cursor1 && cursor1!=-1) { 
					sb.append("A");
				}
				if (i==cursor2 && cursor2!=-1) {
					sb.append("B");
				}
				if (i==cursor3 && cursor3!=-1) {
					sb.append("C");
				}
				sb.append(">");
				System.out.printf("%5s%3s",sb,"|");
				System.out.println();
			}
		}
		System.out.printf("%20s", label);
		for (int i=0;i<a.length;i++) {
			System.out.printf("%5d%3s",a[i],"|");
		}
		System.out.println();
		System.out.println();
	}
	
	public static int[] insertionSort(int [] a) {
		for (int i=0; i<a.length;i++) {
			for (int inner=0; inner<i; inner++) {
				int temp=a[i];							//Backup current element
				if (a[inner]>=a[i]) {
					for (int g=i;g>inner;g--) {			//Push up
						a[g]=a[g-1];
					}
				a[inner]=temp;
				}
			}
		}
		return a;
	}
	
	public static int[] quickSort(int [] a) {
		return quickSort(a, 0, a.length-1);
	}
	
	public static int[] quickSort(int [] a, int li, int re) {
		int rep = re;
		int lip = li;
		int piv = a[lip];
		printArray(a,lip,li,re,"");
		while (li < re) {
			if (a[li+1] <= piv) {
				int temp = a[li];
				a[li] = a[li+1];
				a[li+1] = temp;
				li++;
			} else
			if (a[li+1] > piv) {
				int temp = a[li+1];
				a[li+1] = a[re];
				a[re] = temp;
				re--;
			}
			printArray(a,lip,li,re,"");
		}
		if (li > lip+1) {
			quickSort(a, lip, li-1);
		}
		if (li < rep-1) {
			quickSort(a, li+1, rep);
		}
		return a;
	}
	
	
	
	
	
	public static void main (String [] args) {
		// 4324
		// 4
		int [] a = {44,33,14,9,2,1,4324,42,2,2,4};
//		int [] a = {1, 6, 9, 10, 19};
//		int [] b = {0, 5, 22, 44, 50};
	//	printArray(mergeSort(a));
	}
	



}
