package Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15656 {

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
			
			search(sequence, result, m, 0);
			
			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void search(int[] seqience, int[] result, int m, int k) {
		
		if(k==m) {		
			for(int i=0;i<m;i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return ;
		}
		
		for(int i=0;i<seqience.length;i++) {
			result[k] = seqience[i];
			search(seqience, result, m, k+1);
		}
	}
}
