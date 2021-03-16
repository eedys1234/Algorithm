package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1504_2 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			String[] temp = line.split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int e = Integer.valueOf(temp[1]);
			
			int[][] edges = new int[n][n];
			
			for(int i=0;i<edges.length;i++) 
			{
				for(int j=0;j<edges[0].length;j++) 
				{
					if(i==j) {
						edges[i][j] = 0;
					}
					else {
						edges[i][j] = Integer.MAX_VALUE;						
					}
				}
			}
			
			for(int i=0;i<e;i++) {
				line = inbr.readLine();
				temp = line.split(" ");
				
				int x = Integer.valueOf(temp[0]);
				int y = Integer.valueOf(temp[1]);
				int w = Integer.valueOf(temp[2]);
				
				edges[x-1][y-1] = w;
				edges[y-1][x-1] = w;							
			}
			
			line = inbr.readLine();
			temp = line.split(" ");
			
			int[] path = new int[4];
			path[0] = 1;
			path[1] = Integer.valueOf(temp[0]);
			path[2] = Integer.valueOf(temp[1]);
			path[3] = n;
			
			floyd(edges);
			
			for(int i=0;i<edges.length;i++) 
			{
				for(int j=0;j<edges[0].length;j++) 
				{
					System.out.println((i+1) + ", " + (j+1) + " : " + edges[i][j]);
				}
			}
			
			printPath(edges, path[0]-1, path[3]-1, path[1]-1, path[2]-1);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printPath(int[][] edges, int start, int end, int path1, int path2) {
		int result = Math.min(edges[start][path1] + edges[path1][path2] + edges[path2][end], edges[start][path2] + edges[path2][path1] + edges[path1][end]);
	
		if(result < 0) {
//		if(edges[start][path1] == Integer.MAX_VALUE || edges[start][path2] == Integer.MAX_VALUE || edges[path1][path2] == Integer.MAX_VALUE 
//				|| edges[path2][path1] == Integer.MAX_VALUE || edges[path2][end] == Integer.MAX_VALUE || edges[path1][end] == Integer.MAX_VALUE || result == Integer.MAX_VALUE) {
			System.out.print("-1");
		}
		else {
			System.out.print(result);			
		}
	}
	
	public static void floyd(int[][] edges) {

		for(int k=1;k<edges.length-1;k++) 
		{
			for(int i=0;i<edges.length;i++) 
			{
				for(int j=0;j<edges[0].length;j++) 
				{
					if(edges[i][j] != Integer.MAX_VALUE || edges[i][k] != Integer.MAX_VALUE || edges[k][j] != Integer.MAX_VALUE) {
						edges[i][j] = Math.min(edges[i][j], edges[i][k] + edges[k][j]);		
					}
				}
			}
		}
	}
	
}
