package forthUnit;

public class CC {

	private boolean[] marked;
	private int count;
	private int[] id;
	public CC(Graph G) {
		// TODO 自动生成的构造函数存根
		id=new int[G.V()];
		for(int s=0;s<G.V();s++) {
			if(!marked[s]) {
				dfs(G, s);
				count ++;
			}
		}
	}
	public void dfs(Graph G,int v) {
		marked[v]=true;
		id[v]=count;
		for(int w:G.adj(v)) {
			if(!marked[v]) {
				dfs(G, w);
			}
		}
	}
	public boolean connected(int v,int w) {
		return id[v]==id[w];
	}
	public int id(int v) {
		return id[v];
	}
	public int count() {
		return count;
	}
}
