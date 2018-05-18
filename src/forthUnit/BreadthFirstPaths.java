package forthUnit;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * 广度优先搜索
 * */
public class BreadthFirstPaths {

	private boolean[] marked;//到达该顶点的路径已知吗？
	private int[] edgeTo;//到达该顶点的已知路径上的最后一个顶点
	private final int s;//起点
	public BreadthFirstPaths(Graph G,int s) {
		// TODO 自动生成的构造函数存根
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		this.s=s;
		bfs(G, s);
	}
	
	
	private void bfs(Graph G,int s) {
		Queue<Integer> queue =new Queue<Integer>();
		marked[s]=true;//编辑起点
		queue.enqueue(s);//将他加入队列
		while(!queue.isEmpty()) {
			int v=queue.dequeue();
			for(int w:G.adj(v)) {
				if(!marked[w]) {//对每个未标记的顶点
					edgeTo[w]=v;//保存最短路径的最后一条边
					marked[w]=true;//标记
					queue.enqueue(w);//加入队列
				}
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
