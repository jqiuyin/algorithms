package thirdUnit;

import edu.princeton.cs.algs4.SequentialSearchST;

public class SeparateChainingHashST<Key,Value> {

	private int N;//键值总数
	private int M;//散列表大小；
	private SequentialSearchST<Key, Value>[] st;
	
	public SeparateChainingHashST() {
		this(997);//why is 997????取个1000不好吗？
	}
	
	public SeparateChainingHashST(int M) {
		// TODO 自动生成的构造函数存根
		this.M=M;
		st=(SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for(int i=0;i<M;i++) {
			st[i]=new SequentialSearchST();
		}
		 
	}
	private int hash(Key key) {
		 return (key.hashCode() & 0x7fffffff)%M;
	 }
	public Value get(Key key) {
		return (Value)st[hash(key)].get(key);
	}
	public void put(Key key,Value value) {
		st[hash(key)].put(key, value);
	}
	
}
