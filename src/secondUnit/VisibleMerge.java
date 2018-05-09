package secondUnit;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class VisibleMerge extends Merge{

	public static int N =5000;
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
		draw(N, (Double[]) a);
		StdDraw.clear();
	}
	
	private static <T extends Comparable<T>> void sort(T[] a,int lo,int hi) {
		
		if(hi<=lo) return;
		int mid=lo+(hi-lo)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a, lo, mid, hi);
		
	}
	public static <T extends Comparable<T>> void sort(T[] a) {
		aux=new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
		
		public static void draw(int N,Double[] a) {
			for(int i=0;i<N;i++) {
				double x=1.0*i/N;
				double y=a[i]/2.0;
				double rw=0.2/N;
				double rh=a[i]/2.0;
				StdDraw.filledRectangle(x, y, rw, rh);
			}
			StdDraw.show(1);
		}
		
		public static void main(String[] args) {


			
			Double[] a = new Double[N];
			for (int i = 0; i < a.length; i++) {
				a[i]=StdRandom.random();
			}
			sort(a);
		}
}
