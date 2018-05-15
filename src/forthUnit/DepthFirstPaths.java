package forthUnit;

import edu.princeton.cs.algs4.Stack;

/**
 * 深度优先
 * */
public class DepthFirstPaths {

	private boolean[] marked;//这个顶点上是否调用过dfs()
	private int[] edgeTo;//从起点到一个顶点的已知路径上的最后一个顶点
	private final int s;
	public DepthFirstPaths(Graph G,int s) {
		// TODO 自动生成的构造函数存根
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		this.s=s;
		dfs(G, s);
	}
	private void dfs(Graph G,int v) {

		marked [v]=true;
		for(int w:G.adj(v)) {
			if(!marked[w]) {
				edgeTo[w]=v;
				dfs(G, w);
			}
		}
	}
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v))return null;
		Stack<Integer> path=new Stack<Integer>();
		for(int x=v;x!=s;x=edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
}
