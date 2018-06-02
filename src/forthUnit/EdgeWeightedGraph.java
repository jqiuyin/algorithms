package forthUnit;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;

public class EdgeWeightedGraph {

	private final int V;
	private int E;
	private Bag<Edge>[] adj;
	
	public EdgeWeightedGraph(int V) {
		// TODO 自动生成的构造函数存根
		this.V=V;
		this.E=0;
		adj=(Bag<Edge>[])new Bag[V];
		for(int v=0;v<V;v++) {
			adj[v]=new Bag<Edge>();
		}
	}
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	public void addEdge(Edge e) {
		int v=e.either();
		int w=e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	public Iterable<Edge> edges(){
		Bag<Edge> bag=new Bag<>();
		for(int v=0;v<V;v++) {
			for(Edge e:adj[v]) {
				if(e.other(v)>v) bag.add(e);
			}
		}
		return bag;
	}
}
