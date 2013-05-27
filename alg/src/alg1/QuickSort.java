package alg1;import de.beuth.algorithmen.storage.SortingAlgorithm;import de.beuth.algorithmen.storage.Storage;public class QuickSort implements SortingAlgorithm {	public void sort(Storage a, int li, int re) {		int rep = re;		int lip = li;		int piv = a.get(li);		while (li < re) {			if (a.inRelation(a.get(li+1), piv)) { //<= !!				int temp = a.get(li);				a.set(li, a.get(li+1));				a.set(li+1,temp);				li++;			} else			if (!a.inRelation(a.get(li+1), piv)) { //>				int temp = a.get(li+1);				a.set(li+1,a.get(re));				a.set(re, temp);				re--;			}		}		if (li > lip+1) {			sort(a, lip, li-1);		}		if (li < rep-1) {			sort(a, li+1, rep);		}	}	public void sort(Storage a) {		sort(a,0,a.length()-1);	}}