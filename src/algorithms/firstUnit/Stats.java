package algorithms.firstUnit;

import java.util.Scanner;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stats {

	public static void main(String[] args) {
		Bag<Double> numbers=new Bag<Double>();
		
		while(true) {
			double temp=StdIn.readDouble();
			if(temp!=-1)
			numbers.add(temp);
			else {
				break;
			}
			
		}
		
//		Scanner in =new Scanner(System.in);
//		while(!in.hasNextDouble()) {
//			numbers.add(in.nextDouble());
//		}
		int N =numbers.size();
		double sum=0;
		for(double x:numbers) {
			sum+=x;
		}
		double mean=sum/N;
		sum=0;
		for(double x:numbers) {
			sum+=(x-mean)*(x-mean);
		}
		double std=Math.sqrt(sum/(N-1));
		StdOut.printf("Mean: %.2f\n", mean);
		StdOut.printf("Std dev: %.2f\n", std);
	}
}
