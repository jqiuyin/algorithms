package algorithms.firstUnit;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {

	private String[] strings;
	private int counts;
	public FixedCapacityStackOfStrings(int cap) {
		// TODO 自动生成的构造函数存根
		strings= new String[cap];
		
	}
	public boolean isEmpty() {
		return counts==0;
	}
	public int size() {
		return counts;
	}
	public void push(String item) {
		strings[counts++]=item;
	}
	public String pop() {
		return strings[--counts];
	}
	
	
	public static void main(String[] args) {
		FixedCapacityStackOfStrings stackOfStrings=new FixedCapacityStackOfStrings(100);
		while (!StdIn.isEmpty()) {
			String item =StdIn.readString();
			if(!item.equals("-"))
				stackOfStrings.push(item);
			else if (!stackOfStrings.isEmpty()) {
				StdOut.print(stackOfStrings.pop()+" ");
			}
		}
		StdOut.println("("+stackOfStrings.size()+"left on stack)");
	}
}





