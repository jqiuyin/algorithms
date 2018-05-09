package algorithms.firstUnit;

import java.util.ArrayList;

import javax.sound.midi.VoiceStatus;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStack<Item> {

	private Item[] stack;
	private int n;
	public FixedCapacityStack(int cap) {
		// TODO 自动生成的构造函数存根
		stack=(Item[])new Object[cap];
		
	}
	public boolean isEmpty() {
		return n==0;
	}
	public int size() {
		return n;
	}
	public void push(Item item) {
		stack[n++]=item;
	}
	public Item pop() {
		return stack[--n];
	}
	
	
	public static void main(String[] args) {
		FixedCapacityStack<String> stack=new FixedCapacityStack<String>(100);
		while(!StdIn.isEmpty()) {
			String item=StdIn.readString();
			if(!item.equals("-")) {
				stack.push(item);
			}
			else if (!item.isEmpty()) {
				StdOut.print(stack.pop()+" ");
			}
		}
		StdOut.println("("+stack.size()+" left on stack)");
		
	}
}
