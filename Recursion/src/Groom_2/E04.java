package Groom_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//kmp???©ое╫??
public class E04 {

	public static void main(String[] args) throws Exception {
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(inbr.readLine());
		String[] indexes = new String[n];
		//1000
		//100
		//kmp?
		for(int i=0;i<n;i++) 
		{
			indexes[i] = inbr.readLine();
		}
		
		int q = Integer.valueOf(inbr.readLine());
		String[] keyword = new String[q];

		for(int i=0;i<q;i++) 
		{
			keyword[i] = inbr.readLine();
		}

		int cnt = 0;

		for(int i=0;i<keyword.length;i++) 
		{			
			cnt = 0;
			for(int j=0;j<indexes.length;j++) 
			{
				if(indexes[j].indexOf(keyword[i]) >= 0) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
