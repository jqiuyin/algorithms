package thirdUnit;

import edu.princeton.cs.algs4.Whitelist;

public class BinarySearchST<Key extends Comparable<Key>,Vaule> extends ST<Key,Vaule> {

	private Key[] keys;
	private int N;
	private Vaule[] vals;
	public BinarySearchST(int capacity) {
		// TODO �Զ����ɵĹ��캯�����
		keys= (Key[]) new Comparable[capacity];
		vals=(Vaule[]) new Comparable[capacity];
	}
	
	
	
	@Override
	public void put(Key key, Vaule val) {
		// TODO �Զ����ɵķ������
		int i=rank(key);
		if(i<N&&keys[i].compareTo(key)==0) {
			vals[i]=val;
			return;
		}
		for(int j=N;j>i;j--) {
			keys[j]=keys[j-1];
			vals[j]=vals[j-1];
		}
		keys[i]=key;
		vals[i]=val;
		N++;
	}

	@Override
	public Vaule get(Key key) {
		// TODO �Զ����ɵķ������
		if(isEmpty()) return null;
		int i=rank(key);
		if(i<N&&keys[i].compareTo(key)==0) {
			return null;
		}
		else {
			return null;
		}
	}

	@Override
	public int size() {
		// TODO �Զ����ɵķ������
		return N;
	}

	@Override
	public Iterable<Key> keys() {
		// TODO �Զ����ɵķ������
		return null;
	}
	
	
	
	public int rank(Key key) {
		int lo=0;
		int hi=N-1;
		while(lo<=hi) {
			int mid=lo+(hi-lo)/2;
			int cmp=key.compareTo(keys[mid]);
			if(cmp<0) hi=mid-1;
			else if (cmp>0) {
				lo=mid+1;
			}
			else {
				return mid;
			}
		}
		return lo;
	}
	@Override
	public void delete(Key key) {
		// TODO �Զ����ɵķ������
		if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
        if (isEmpty()) return;

        // compute rank
        int i = rank(key);

        // key not in table
        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }

        for(int j=i;j<N-1;j++) {
        	keys[j]=keys[j+1];
        	vals[j]=vals[j+1];
        	
        }
        N--;
        keys[N]=null;
        vals[N]=null;
        
	}

}
