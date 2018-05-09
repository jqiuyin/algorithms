package thirdUnit;

import java.io.ObjectOutputStream.PutField;

public class RedBlackBST<Key extends Comparable<Key>,Vaule> extends ST<Key,Vaule> {

	private Node root;
	private static final boolean RED=true;
	private static final boolean BLACK=false;
	private class Node{
		Key key;
		Vaule val;
		Node left , right;
		int N;
		boolean color;
		public Node(Key key,Vaule val,int N,boolean color) {
			// TODO 自动生成的构造函数存根
			this.key=key;
			this.val=val;
			this.N=N;
			this.color=color;
		}
	}
	
	private Node rotateLeft(Node h) {
		Node x=h.right;
		h.right=x.left;
		x.left=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=1+size(h.left)+size(h.right);
		return x;
	}
	private Node rotateRight(Node h) {
		Node x=h.left;
		h.left=x.right;
		x.right=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=1+size(h.left)+size(h.right);
		return x;
	}
	
	
	private boolean isRed(Node x) {
		if(x==null) return false;
		return x.color==RED;
	}
	
	
	private void flipColors(Node h) {
		h.color=RED;
		h.left.color=BLACK;
		h.right.color=BLACK;
	}
	@Override
	public void put(Key key, Vaule val) {
		// TODO 自动生成的方法存根
		root=put(root, key, val);
		root.color=BLACK;
	}

	private Node put(Node h,Key key,Vaule val) {
		if(h==null) {
			return new Node(key, val, 1, RED);
		}
		int cmp=key.compareTo(h.key);
		if(cmp<0)h.left=put(h.left, key, val);
		else if(cmp>0) h.right=put(h.right, key, val);
		else h.val=val;
		
		if(isRed(h.right)&&!isRed(h.left)) h=rotateLeft(h);
		if(isRed(h.left)&&isRed(h.left.left)) h=rotateRight(h);
		if(isRed(h.left)&&isRed(h.right)) flipColors(h);
		h.N=size(h.left)+size(h.right)+1;
		return h;
	}
	@Override
	public Vaule get(Key key) {
		// TODO 自动生成的方法存根
		return null;
	}

	private int size(Node x) {
		if(x==null) return 0;
		else return x.N;
	}
	
	@Override
	public int size() {
		// TODO 自动生成的方法存根
		return size(root);
	}

	@Override
	public Iterable<Key> keys() {
		// TODO 自动生成的方法存根
		return null;
	}

	 
}
