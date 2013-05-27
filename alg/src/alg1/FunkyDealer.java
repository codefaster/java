package alg1;

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
	
//	funktion mergesort(liste);
//	  falls (Größe von liste <= 1) dann antworte liste
//	  sonst
//	      halbiere die liste in linkeListe, rechteListe
//	      linkeListe = mergesort(linkeListe)
//	      rechteListe = mergesort(rechteListe)
//	      antworte merge(linkeListe, rechteListe)
//
//	funktion merge(linkeListe, rechteListe);
//	   neueListe
//	   solange (linkeListe und rechteListe nicht leer)
//	   |    falls (erstes Element der linkeListe <= erstes Element der rechteListe)
//	   |    dann füge erstes Element linkeListe in die neueListe hinten ein und entferne es aus linkeListe
//	   |    sonst füge erstes Element rechteListe in die neueListe hinten ein und entferne es aus rechteListe
//	   solange_ende
//	   solange (linkeListe nicht leer)
//	   |    füge erstes Element linkeListe in die neueListe hinten ein und entferne es aus linkeListe
//	   solange_ende
//	   solange (rechteListe nicht leer)
//	   |    füge erstes Element rechteListe in die neueListe hinten ein und entferne es aus rechteListe
//	   solange_ende
//	   antworte neueListe
	

	
	
	public class mergeBoy { 
		protected int [] a;
		protected int pa;
		protected int pb;
		protected int pc;
		protected int [] virtualC;
		
		public mergeBoy(int [] a) {
			pa = 0;
			pb = 0;
			pc = 0;
			/** 
			 * Copy Input Array to first half of new double lengthed Array
			 */
			this.a = new int [a.length*2];
			int pos = 0;
			for (int element : a) {
				this.a[pos] = a[pos];
			}
		}
		
		public int[] splitRange(int first, int last) {
			int origLength = last - first;
			if (origLength <= 1) { 
				return new int[] {
						first, last
						};
			}
			/**/
			int length1 = origLength / 2;
			int length2 = origLength - length1;
			/**/
			int first1 = first;
			int last1 = first1 + length1 - 1;
			/**/
			int first2 = last1 + 1;
			int last2 = first2 + length2 - 1;
			/**/
			return merge(splitRange(first1,last1),splitRange(first2,last2));
		}
		
		public int[] merge(int [] virtualArray1, int [] virtualArray2) {
			int first1 = virtualArray1[0];
			int last1 = virtualArray1[1];
			int first2 = virtualArray2[0];
			int last2 = virtualArray2[1];
			int length1 = last1-first1;
			int length2 = last2-first2;
			
			return null;
		}
		
	}
	
	public static int[] merge(int [] a, int [] b) {
		int m = a.length; 
		int n = b.length; 
		int [] c = new int [m+n];
		int pa = 0;
		int pb = 0;
		int pc = 0; //
		while (pa < m && pb < n) {	
			if (a[pa] <= b[pb]) {	
				c[pc] = a[pa];
				pa++;
				pc++;
				continue;
			}
				c[pc] = b[pb];
				pb++;
				pc++;
		}
		while (pb < n) {
			c[pc] = b[pb];
			pc++;
			pb++;
		}
		while (pa < m) {
			c[pc] = a[pa];
			pa++;
			pc++;
		}
		printArray(a,">> A <<");
		printArray(b,">> B <<");
		printArray(c,">> o <<");
		return c;
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
