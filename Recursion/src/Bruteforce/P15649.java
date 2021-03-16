package Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P15649 {

	public static int[] value;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String line = inbr.readLine();
			String[] temp = line.split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			value = new int[n];
			visited = new boolean[n];
			int[] space = new int[n];
			
			for(int i=0;i<value.length;i++) {
				value[i] = i+1;
			}
			
			DFS(space, m, 0);

			System.out.println(sb.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void DFS(int[] space, int m, int depth) {
		
		if(depth == m) {
			for(int i=0;i<m;i++) {
				sb.append(space[i]);
				sb.append(" ");				
			}			
			sb.append("\n");
		}
		else {
			for(int i=0;i<value.length;i++) {
				if(!visited[i]) {
					space[depth] = value[i];				
					visited[i] = true;
					DFS(space, m, depth+1);
					visited[i] = false;
				}
			}			
		}		
		
	}
	
}
