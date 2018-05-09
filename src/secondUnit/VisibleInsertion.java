package secondUnit;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class VisibleInsertion extends Example {

	public static int N =100;
	
	public static void sort(Double[] a) {
		int N=a.length;
		for(int i=1;i<N;i++) {
			
			for(int j=i;j>0&&less(a[j], a[j-1]);j--) {
				exch(a, j, j-1);
				draw(N, a);
				StdDraw.clear();
			}
		}
	}
	
	public static void draw(int N,Double[] a) {
		for(int i=0;i<N;i++) {
			double x=1.0*i/N;
			double y=a[i]/2.0;
			double rw=0.2/N;
			double rh=a[i]/2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
		StdDraw.show(10);
	}
	
	public static void main(String[] args) {
		Double[] a = new Double[N];
		for (int i = 0; i < a.length; i++) {
			a[i]=StdRandom.random();
		}
		sort(a);
	}
}
