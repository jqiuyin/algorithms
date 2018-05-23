package thirdUnit;

import edu.princeton.cs.algs4.SequentialSearchST;

public class SeparateChainingHashST<Key,Value> {

	private int N;//��ֵ����
	private int M;//ɢ�б��С��
	private SequentialSearchST<Key, Value>[] st;
	
	public SeparateChainingHashST() {
		this(997);//why is 997????ȡ��1000������
	}
	
	public SeparateChainingHashST(int M) {
		// TODO �Զ����ɵĹ��캯�����
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
