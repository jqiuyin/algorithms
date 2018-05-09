package algorithms.firstUnit;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

	private Node first;
	private class Node{
		Item item;
		Node next;
	}
	public void add(Item item) {
		Node oldFirst =first;
		first =new Node();
		first.item=item;
		first.next=oldFirst;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO 自动生成的方法存根
		return new ListIterator();
	}
	
	
	
	private class ListIterator implements Iterator<Item>{

		
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			// TODO 自动生成的方法存根
			return current != null;
		}

		@Override
		public Item next() {
			// TODO 自动生成的方法存根
				Item item= current.item;
				current=current.next;
				return item;
			
		}
		
	}
	
}
