package thirdUnit;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import edu.princeton.cs.algs4.ST;


public class LookupCSV {
	public static void main(String[] args) throws FileNotFoundException {
		//System.out.println(args[0]);
		//In in=new In();
		Scanner in=new Scanner(new File(args[0]));
		int keyField=Integer.parseInt(args[1]);
		int valField=Integer.parseInt(args[2]);
		ST<String, String> st=new ST<String,String>();
		while(in.hasNextLine()) {
			String line=in.nextLine();
			String[] tokens=line.split(args[3]);
			String key=tokens[keyField];
			String val=tokens[valField];
			st.put(key, val);
		}
		in.close();
		Scanner input =new Scanner(System.in);
		while(input.hasNextLine()) {
			String query=input.nextLine();
			if(st.contains(query)) {
				String out=st.get(query);
				System.out.println(out);
			}
			else {
					System.out.println("不存在此索引");
			}
		}
	}
}
