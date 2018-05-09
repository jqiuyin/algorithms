package secondUnit;

import edu.princeton.cs.algs4.In;

public class   Merge  extends Example{

	
	protected static Comparable[] aux;
	protected static <T extends Comparable<T>> void merge(T[] a,int lo,int mid,int hi) {
		int i=lo;
		int j=mid+1;
		for(int k=lo;k<=hi;k++) {
			aux[k]=a[k];
		}
		for(int k=lo;k<=hi;k++) {
			if(i>mid)	a[k]= (T) aux[j++];
			else if(j>hi)	a[k]=(T) aux[i++];
			else if(less(aux[j], aux[i]))	a[k]=(T) aux[j++];
			else 	a[k]=(T)aux[i++];
}
	}
	public static <T extends Comparable<T>> void sort(T[] a) {
		aux=new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	private static <T extends Comparable<T>> void sort(T[] a,int lo,int hi) {
		if(hi<=lo) return;
		int mid=lo+(hi-lo)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a, lo, mid, hi);
	}
	public static void main(String[] args) {
		String[] a=In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
	
	
}
