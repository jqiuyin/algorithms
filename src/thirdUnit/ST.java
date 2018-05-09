package thirdUnit;

public abstract class ST<Key extends Comparable<Key>,Vaule> {

	
	public abstract void put(Key key,Vaule val);
	public abstract Vaule get(Key key);
	public  void delete(Key key) {
		put(key, null);
	}
	public boolean contains(Key key) {
		return get(key)!=null;
	}
	public abstract int size();
	public boolean isEmpty() {
		return size()==0;
	}
	public abstract Iterable<Key> keys();
}
