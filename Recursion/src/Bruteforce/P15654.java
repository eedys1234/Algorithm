package Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15654 {

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
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void search(int[] sequence, int[] result, int m, int k) {
		
		if(k == m) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<m;i++) {
				sb.append(result[i]+" ");
			}
			System.out.println(sb.toString());
			return ;
		}
		
		for(int i=0;i<sequence.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[k] = sequence[i];
				search(sequence, result, m, k+1);
				visited[i] = false;
			}
		}
		
	}
}
