package secondUnit;

import edu.princeton.cs.algs4.StdOut;

public abstract class Example {

	
	public static <T extends Comparable<T>> void sort(T[] a) {}
//	public static void main(String[] args) {
//		String[] a=In.readStrings();
//		sort(a);
//		assert isSorted(a);
//		show(a);
//	}
	
	
	protected static <T extends Comparable<T>> boolean  less(T v,T w) {
		return v.compareTo(w)<0;
	}
	
	protected static <T extends Comparable<T>> void exch(T[] a,int i,int j) {
		T t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	protected static <T extends Comparable<T>> void show(T[] a) {
		for(int i=0;i<a.length;i++) {
			StdOut.print(a[i]+" ");
		}
		StdOut.println();
	}
	public static <T extends Comparable<T>> boolean isSorted(T[] a) {
		for(int i=1;i<a.length;i++) {
			if(less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
	
}
   