package Groom_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//시간초과되서 안된듯함..
//속도 문제
//위상정렬?
//50만개
public class E03 {

	public static boolean[][] assoication;

	public static void main(String[] args) throws Exception {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] temp = inbr.readLine().split(" ");
		int n = Integer.valueOf(temp[0]);
		int q = Integer.valueOf(temp[1]);
		int[][] question = new int[q][2];
		assoication = new boolean[n+1][n+1];
		int[] adj = new int[n+1];
		
		
		for(int i=0;i<n-1;i++) 
		{
			temp = inbr.readLine().split(" ");
			int parent = Integer.valueOf(temp[0]);
			int child = Integer.valueOf(temp[1]);			
			adj[child-1] = parent;
			assoication[parent][child] = true;
		}
		
		for(int i=1;i<adj.length;i++) {				
			int x = i;
			while(x > 0) {
				x = adj[x];
				if(assoication[x][i]) {
					continue;
				}
				assoication[x][i] = true;
			}
		}
		//question 담음
		for(int i=0;i<q;i++) 
		{
			temp = inbr.readLine().split(" ");			
			int start = question[i][0] = Integer.valueOf(temp[0]);
			int end = question[i][1] = Integer.valueOf(temp[1]);

			if(assoication[start][end]) {
				sb.append("yes").append("\n");
			}
			else {
				sb.append("no").append("\n");				
			}
		}
		
		System.out.println(sb.toString());

	}	
}
