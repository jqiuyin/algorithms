package secondUnit;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class VisiableShell extends Example {

	public static int N =500 ;
	
	public static void sort(Comparable[] a) {
		int N=a.length;
		int h=1;
		while(h<N/3)h=3*h+1;
		while(h>=1) {
			for(int i=h;i<N;i++) {
				for(int j=i;j>=h&&less(a[j], a[j-h]);j-=h) {
					exch(a, j, j-h);
					draw(N, (Double[]) a);
					StdDraw.clear();
				}
					
				
			}
			h=h/3;
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
