package algorithms.firstUnit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static int rank(int key,int[] a) {
		int lo=0;
		int hi =a.length-1;
		while(lo<=hi) {
			int mid=(hi+(hi-lo))/2;
			if(mid>key) hi=mid-1;
			if(mid<key) lo=mid+1;
			else return mid;
		}
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		File file=new File("tinyW.txt");
		try {
			FileReader fileReader=new FileReader(file);
			Scanner in=new Scanner(fileReader);
			ArrayList<Integer> arrayList=new ArrayList<Integer>();
			while(in.hasNextLine()) {
				arrayList.add(Integer.parseInt(in.nextLine()));
			}
			int[] a=new int[arrayList.size()];
			for(int i=0;i<arrayList.size();i++) {
				a[i]=arrayList.get(i).intValue();
				//System.out.println(""+a[i]);
			}
			
			Arrays.sort(a);
			while(arrayList.size()!=0) {
				int key =new Scanner(System.in).nextInt();
				//System.out.println(""+key);
				if(rank(key, a)>0)
					System.out.println(key);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}
