package forthUnit;

public class Topological {

	private Iterable<Integer> order;
	public Topological(Digraph G) {
		// TODO 自动生成的构造函数存根
		DirectedCycle cyclefinder=new DirectedCycle(G);
		if(!cyclefinder.hasCycle()) {
			DepthFirstOrder dfs=new DepthFirstOrder(G);
			order=dfs.reversePost();
		}
	}
	public Iterable<Integer> order(){
		return order;
	}
	public boolean isDAG() {
		return order !=null;
	}
	
}
