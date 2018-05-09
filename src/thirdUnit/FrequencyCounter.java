package thirdUnit;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 符号表用例
 * 统计标准输入中各个单词出现的频率，然后将频率最高的单词打印出来
 * 命令行参数指定了表中键的最短长度
 */
public class FrequencyCounter {

	public static void main(String[] args) {
		int minlen=Integer.parseInt(args[0]);
		SequentialSearchST<String, Integer> st=new SequentialSearchST<String, Integer>();
		while(!StdIn.isEmpty())
		{
			String word=StdIn.readString();
			if(word.length()<minlen)continue;
			if(!st.contains(word)) {
				st.put(word, 1);
			}
			else {
				st.put(word, st.get(word)+1);
			}
		}
		String max=" ";
		st.put(max, 0);
		for(String word:st.keys()) {
			if(st.get(word)>st.get(max)) {
				max=word;
			}
		}
		StdOut.println(max+" "+st.get(max));
	}
}
