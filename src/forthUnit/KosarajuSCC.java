package forthUnit;

public class KosarajuSCC {

	private boolean[] marked;
	private int[] id;
	private int count;
	
	public KosarajuSCC(Digraph G) {
		// TODO 自动生成的构造函数存根
		marked=new boolean[G.V()];
		id=new int[G.V()];
		DepthFirstOrder order=new DepthFirstOrder(G);
		for(int s:order.reversePost()) {
			if(!marked[s]) {
				dfs(G, s);
				count++;
			}
		}
	}
	private void dfs(Digraph G,int v) {
		marked[v]=true;
		id[v]=count;
		for(int w:G.adj(v)) {
			if(!marked[w]){
				dfs(G, w);
			}
		}
	}
	public boolean stronglyConnected(int v,int w) {
		return id[v]==id[w];
	}
	public int id(int v) {
		return id[v];
	}
	public int count() {
		return count;
	}
}
