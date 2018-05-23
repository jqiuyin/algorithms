package forthUnit;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolGraph {

	private ST<String, Integer> st;//������->����
	private String[] keys;//����->������
	private Graph G;//ͼ
	public SymbolGraph(String stream,String sp) {
		// TODO �Զ����ɵĹ��캯�����
		st=new ST<String,Integer>();
		In in=new In(stream);//��һ��
		while(in.hasNextLine()) {//��������
			String[] a=in.readLine().split(sp);//��ȡ�ַ���
			for(int i=0;i<a.length;i++) {//Ϊÿ����ͬ���ַ�������һ������
				if(!st.contains(a[i])) {
					st.put(a[i], st.size());
				}
			}
		}
		keys=new String[st.size()];//������ö������ķ���������һ������
		for (String name:st.keys()) {
			keys[st.get(name)]=name;
		}
		G=new Graph(st.size());
		in=new In(stream);//�ڶ���
		while(in.hasNextLine()) {//����ͼ
			String[] a=in.readLine().split(sp);//��ÿһ�еĵ�һ������͸��е�������������
			int v=st.get(a[0]);
			for(int i=1;i<a.length;i++) {
				G.addEdge(v, st.get(a[i]));
			}
		}
	}
	public boolean contains(String s) {
		return st.contains(s);
	}
	public int index(String s) {
		return st.get(s);
	}
	public String name(int v) {
		return keys[v];
	}
	public Graph G() {
		return G;
	}
}
