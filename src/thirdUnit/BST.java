package thirdUnit;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Queue;

public class BST <Key extends Comparable<Key>,Vaule> extends ST<Key,Vaule>{

	private Node root;
	
	private class Node{
		private Key key;
		private Vaule val;
		private Node left,right;
		private int N;
		public Node(Key key,Vaule val, int N) {
			// TODO 自动生成的构造函数存根
			this.key=key;
			this.val=val;
			this.N=N;
		}
	}
	
	
	@Override
	public void put(Key key, Vaule val) {
		// TODO 自动生成的方法存根
		root=put(root, key, val);
	}
	
	private Node put(Node x,Key key, Vaule val) {
		if(x==null) return new Node(key, val, 1);
		int cmp= key.compareTo(x.key);
		if(cmp<0) x.left=put(x.left, key, val);
		else if(cmp>0) x.right=put(x.right, key, val);
		else x.val=val;
		x.N=size(x.left)+size(x.right)+1;
		return x;
		
	}
	
	

	@Override
	public Vaule get(Key key) {
		// TODO 自动生成的方法存根
		return get(root, key);
	}
	private Vaule get(Node x, Key key) {
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return get(x.left,key);
		else if(cmp>0) return get(x.right, key);
		else return x.val;
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
		return keys(min(),max());
		 
	}
	
	public  Iterable<Key> keys(Key lo,Key hi){
		Queue<Key> queue=new Queue<Key>();
		keys(root,queue,lo,hi);
		return queue;
	}
	
	private void keys(Node x,Queue<Key> queue,Key lo,Key hi) {
		if(x==null) return ;
		int cmplo=lo.compareTo(x.key);
		int cmphi=hi.compareTo(x.key);
		if(cmplo<0)keys(x.left,queue,lo,hi);
		if(cmplo<=0&&cmphi>=0)queue.enqueue(x.key);
		if(cmphi>0)keys(x.right,queue,lo,hi);
	}

	public Key min() {
		return min(root).key;
	}
	private Node min(Node x) {
		if(x.left==null) return x;
		return min(x.left);
	}
	
	
	public Key floor(Key key) {
		Node xNode=floor(root, key);
		if(xNode==null) return null;
		return xNode.key;
	}
	private Node floor(Node x,Key key) {
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp==0)return x;
		if(cmp<0)return floor(x.left, key);
		Node t=floor(x.right, key);
		if(t!=null)return t;
		else return x;
	}
	public Key select(int k) {
		return select(root,k).key;
	}
	private Node select(Node x,int k) {
		if(x==null) return null;
		int t=size(x.left);
		if(t>k)return select(x.left,k);
		if(t<k)return select(x.right, k-t-1);
		else return x;		
	}
	public int rank(Key key) {
		return rank(key,root);
	}
	private int rank(Key key,Node x) {
		if(x==null)return 0;
		int cmp=key.compareTo(x.key);
		if(cmp<0)return rank(key, x.left);
		else if(cmp>0)return 1+size(x.left)+rank(key,x.right);
		else return size(x.left);
	}
	
	
	
	
	
	
	
	@Override
	public void delete(Key key) {
		// TODO 自动生成的方法存根
		root=delete(root, key);
	}
	
	public void deleteMin() {
		root=deleteMin(root);
	}
	private Node deleteMin(Node x) {
		if(x.left==null) return x.right;
		x.left=deleteMin(x.left);
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
	private Node delete(Node x,Key key) {
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp<0)x.left=delete(x.left, key);
		else if(cmp>0)x.right=delete(x.right, key);
		else {
			if(x.right==null)return x.left;
			if(x.left==null)return x.right;
			Node t=x;
			x=min(t.right);
			x.right=deleteMin(t.right);
			x.left=t.left;
		}
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
	public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    } 

    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    } 
	
}
