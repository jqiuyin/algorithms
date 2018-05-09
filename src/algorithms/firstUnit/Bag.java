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
		// TODO �Զ����ɵķ������
		return new ListIterator();
	}
	
	
	
	private class ListIterator implements Iterator<Item>{

		
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			// TODO �Զ����ɵķ������
			return current != null;
		}

		@Override
		public Item next() {
			// TODO �Զ����ɵķ������
				Item item= current.item;
				current=current.next;
				return item;
			
		}
		
	}
	
}
