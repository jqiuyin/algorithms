package forthUnit;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DirectedDFS {

	private boolean[] marked;
	public DirectedDFS(Digraph g,int s) {
		// TODO 自动生成的构造函数存根
		marked=new boolean[g.V()];
		dfs(g, s);
	}
	public DirectedDFS(Digraph g,Iterable<Integer> sources) {
		// TODO 自动生成的构造函数存根
		marked =new boolean[g.V()];
		for(int w:sources) {
			if(!marked[w]) {
				dfs(g, w);
			}
		}
	}
	public boolean marked(int v) {
		return marked[v];
	}
	private void dfs(Digraph g,int v) {
		marked[v]=true;
		for(int w:g.adj(v)) {
			if(!marked[w]) {
				dfs(g, w);
			}
		}
	}
	
	public static void main(String[] args) {
		Digraph graph=new Digraph(new In(args[0]));
		Bag<Integer> sources=new Bag<Integer>();
		for(int i=1;i<args.length;i++) {
			sources.add(Integer.parseInt(args[i]));
		}
		DirectedDFS reachable=new DirectedDFS(graph, sources);
		for(int v=0;v<graph.V();v++) {
			if(reachable.marked(v)) {
				StdOut.println(v+" ");
			}
			StdOut.println();
		}
	}
	
}
