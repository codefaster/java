package alg2;import java.util.Arrays;public class UnsortedArrayStorage implements Datenspeicher {	protected Keyable [] a;	int size;		public UnsortedArrayStorage() { 		a = new Keyable [10];		clear();	}		public void expandArray() {		Keyable [] oldArray = a;		Keyable [] newArray = new Keyable[a.length*2];		for (int i=0; i<oldArray.length; i++) {			newArray[i] = oldArray[i];		}		a=newArray;	}		public void insert(Keyable o) {		int i=0;		while (a[i] != null) {			i++;			if (i >= a.length) {				expandArray();			}		}		a[i] = o;		size++;			}	public Keyable get(int key) {		for (Keyable cur : a) {			if (cur.getKey() == key) {				return cur;			}		}		return null;	}	public Keyable getMaximum() {		Keyable min = a[1];		for (int i = 0; i<size(); i++) {			if (a[i].getKey() >= min.getKey()) {				min = a[i];			}		}		return min;	}	public Keyable getMinimum() {		Keyable min = a[1];		for (int i = 0; i<size(); i++) {			if (a[i].getKey() <= min.getKey()) {				min = a[i];			}		}		return min;	}	public Keyable remove(int key) {		for (int i=0; i < size(); i++) {			Keyable cur = a[i];			if (cur.getKey() == key) {				Keyable deletedElement = cur;				cur = null;				size--;				return deletedElement;			}		}		size--;		return null;	}	public void remove(Keyable o) {		remove(o);	}	public boolean contains(Keyable o) {		for (Keyable cur : a) {			if (cur == o) {				return true;			}		}		return true;	}	public boolean contains(int key) {		for (Keyable cur : a) {			if (cur.getKey() == key) {				return true;			}		}		return false;	}	public Keyable getSuccessor(Keyable o) {		/* 		 * No sucessor because last element.		 */		if (a[a.length].equals(o)) {			return null;		}		/*		 * Search for suc.		 */		for (int i = 0; i < a.length-1; i++) {			if (a[i].equals(o)) {				return a[i+1];			}		}		/*		 * Element not found		 */		return null;	}	public Keyable getPredecessor(Keyable o) {		/* 		 * No predecessor because first element.		 */		if (a[0].equals(o)) {			return null;		}		/*		 * Search for pred.		 */		for (int i = 1; i < a.length; i++) {			if (a[i].equals(o)) {				return a[i-1];			}		}		/*		 * Element not found		 */		return null;	}	public int size() {		return size;	}	public void clear() {		for (Keyable cur : a) {			cur = null;		}		size = 0;	}}