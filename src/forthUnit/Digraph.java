package forthUnit;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Digraph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	public Digraph(int V) {
		// TODO 自动生成的构造函数存根
		this.V=V;
		this.E=0;
		adj=(Bag<Integer>[]) new Bag[V];
		for(int v=0;v<V;v++) {
			adj[v]=new Bag<Integer>();
		}
		
	}
	public Digraph(In in) {
		// TODO 自动生成的构造函数存根
		this(in.readInt());//读取V并将图初始化
		int E =in.readInt();
		for(int i=0;i<E;i++) {
			//添加一条边
			int v=in.readInt();//读取一个顶点
			int w=in.readInt();//读取一条边
			addEdge(v, w);//添加一条他们的连接
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
