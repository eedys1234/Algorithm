package Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15666 {

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			
			int[] sequence = new int[n];
			int[] result = new int[n];
			
			temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++) {
				sequence[i] = Integer.valueOf(temp[i]);
			}
			
			Arrays.sort(sequence);
			
			search(sequence, result, m, 0, 0);
			
			System.out.println(sb.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void search(int[] sequence, int[] result, int m, int k, int start) {
		
		if(k == m) {
			for(int i=0;i<m;i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return ;
		}
		 
		int prev = 0;
		
		for(int i=start;i<sequence.length;i++) {
			if(prev != sequence[i]) {
				result[k] = sequence[i];
				search(sequence, result, m, k+1, i);			
				prev = result[k];
			}
		}
	}
}
