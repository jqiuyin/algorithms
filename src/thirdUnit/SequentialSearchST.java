package thirdUnit;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SequentialSearchST<Key extends Comparable<Key>,Vaule> extends ST<Key,Vaule>{

	private int n;
	private Node first;
	private class Node{
		Key key;
		Vaule val;
		Node next;
		public Node(Key key,Vaule val,Node next) {
			this.key=key;
			this.val=val;
			this.next=next;
		}
	}
	
	
	
	
	
	@Override
	public void put(Key key, Vaule val) {
		// TODO 自动生成的方法存根
		if (key == null) throw new IllegalArgumentException("argument to delete() is null");
		for(Node x=first;x!=null;x=x.next) {
			if(key.equals(x.key)) {
				x.val=val;
				return;
			}
		}
		first=new Node(key, val, first);
		n++;
	}

	@Override
	public Vaule get(Key key) {
		// TODO 自动生成的方法存根
		if (key == null) throw new IllegalArgumentException("argument to delete() is null");
		for(Node x=first;x!=null;x=x.next) {
			if(key.equals(x.key)) {
				return x.val;
			}
		}
		return null;
	}

	@Override
	public int size() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Iterable<Key> keys() {
		
		// TODO 自动生成的方法存根
		return new Iterable<Key>() {

			@Override
			public Iterator<Key> iterator() {
				// TODO 自动生成的方法存根
				return new Iterator<Key>() {

					private Node temp=first;
					
					
					@Override
					public boolean hasNext() {
						// TODO 自动生成的方法存根
						return temp.next!=null;
					}

					@Override
					public Key next() {
						// TODO 自动生成的方法存根
						if(!hasNext()) throw new NoSuchElementException();
							Key key=temp.key;
							temp=temp.next;
							return key;
						
					}
				};
			}
		};
	}

	@Override
	public void delete(Key key) {
		// TODO 自动生成的方法存根
		if (key == null) throw new IllegalArgumentException("argument to delete() is null");
		first=delete(first, key);
	}
//屎一般的递归
	private Node delete(Node x,Key key) {
		if(key==null)return null;
		if(key.equals(x.key)) {
			n--;
			return x.next;
		}
		x.next=delete(x.next, key);
		return x;
	}
	
	
	
	public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
	
}
