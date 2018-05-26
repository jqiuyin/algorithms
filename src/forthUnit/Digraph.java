package forthUnit;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Digraph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	public Digraph(int V) {
		// TODO �Զ����ɵĹ��캯�����
		this.V=V;
		this.E=0;
		adj=(Bag<Integer>[]) new Bag[V];
		for(int v=0;v<V;v++) {
			adj[v]=new Bag<Integer>();
		}
		
	}
	public Digraph(In in) {
		// TODO �Զ����ɵĹ��캯�����
		this(in.readInt());//��ȡV����ͼ��ʼ��
		int E =in.readInt();
		for(int i=0;i<E;i++) {
			//���һ����
			int v=in.readInt();//��ȡһ������
			int w=in.readInt();//��ȡһ����
			addEdge(v, w);//���һ�����ǵ�����
		}
	}
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	public void addEdge(int v,int w) {
		adj[w].add(w);
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public Digraph reverse() {
		Digraph R=new Digraph(V);
		for(int v=0;v<V;v++) {
			for(int w:adj(v)) {
				R.addEdge(w, V);
			}
		}
		return R;
	}
}
