package forthUnit;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * �����������
 * */
public class BreadthFirstPaths {

	private boolean[] marked;//����ö����·����֪��
	private int[] edgeTo;//����ö������֪·���ϵ����һ������
	private final int s;//���
	public BreadthFirstPaths(Graph G,int s) {
		// TODO �Զ����ɵĹ��캯�����
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		this.s=s;
		bfs(G, s);
	}
	
	
	private void bfs(Graph G,int s) {
		Queue<Integer> queue =new Queue<Integer>();
		marked[s]=true;//�༭���
		queue.enqueue(s);//�����������
		while(!queue.isEmpty()) {
			int v=queue.dequeue();
			for(int w:G.adj(v)) {
				if(!marked[w]) {//��ÿ��δ��ǵĶ���
					edgeTo[w]=v;//�������·�������һ����
					marked[w]=true;//���
					queue.enqueue(w);//�������
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
