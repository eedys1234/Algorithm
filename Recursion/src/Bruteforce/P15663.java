package Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15663 {

	public static StringBuilder sb = new StringBuilder();
	public static boolean[] visited;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			
			int[] sequence = new int[n];
			int[] result = new int[n];
			visited = new boolean[n];
			
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
	
	public static void search(int[] sequence, int[] result, int m, int k) {
	
		if(k == m) {
			for(int i=0;i<m;i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return ;
		}
		
		int previous = 0;
		
		for(int i=0;i<sequence.length;i++) {	
			if(previous != sequence[i] && !visited[i]) {
				visited[i] = true;
				result[k] = sequence[i];
				search(sequence, result, m, k+1);				
				visited[i] = false;
				previous = result[k];
			}
		}
	}
}
