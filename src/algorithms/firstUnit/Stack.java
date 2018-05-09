package algorithms.firstUnit;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> {

	private Node first;
	private int n;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public int size() {
		return n;
	}
	public void push (Item item) {
		Node oldfirst =first;
		first = new Node();
		first.item=item;
		first.next=oldfirst;
		n++;
	}
	public Item pop() {
		Item item=first.item;
		first=first.next;
		n--;
		return item;
	}
	
	public static void main(String[] args) {
		Stack<String> s=new Stack<String>();
		while(!StdIn.isEmpty()) {
			String item=StdIn.readString();
			if(!item.equals("-")) {
				s.push(item);
			}
			else if(!s.isEmpty()) {
				StdOut.print(s.pop()+" ");
			}
			
		}
		StdOut.print("("+s.size()+" left on stack)");
	}
	
}
