package forthUnit;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * ����ͼ-�ڽӱ�
 * */


public class Graph {

	private final int V;//������Ŀ
	private int E;//�ߵ���Ŀ		
	private Bag<Integer>[] adj;//�ڽӱ�
	
	public Graph(int V) {
		// TODO �Զ����ɵĹ��캯�����
		this.V=V;
		this.E=0;
		adj=(Bag<Integer>[])new Bag[V];//�����ڽӱ�
		for (int v=0;v<V;v++) {
			adj[v]=new Bag<Integer>();//�����������ʼ��Ϊ��
		}
	}
	public Graph(In in) {
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
	public void addEdge(int v,int w) {
		adj[v].add(w);//��w��ӵ�v������
		adj[w].add(v);//��v��ӵ�w��������
		E++;
	}
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
}
