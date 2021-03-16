package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1956 {

	public static final int INF = 100000000;
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			String[] temp = line.split(" ");

			int v = Integer.valueOf(temp[0]);
			int e = Integer.valueOf(temp[1]);
			
			int[][] w = new int[v+1][v+1];
			int[][] pi = new int[v+1][v+1];
						
			for(int i=0;i<e;i++) {
				line = inbr.readLine();
				temp = line.split(" ");
				w[Integer.valueOf(temp[0])][Integer.valueOf(temp[1])] = Integer.valueOf(temp[2]);
			}
			
			for(int i=1;i<w.length;i++) 
			{
				for(int j=1;j<w[0].length;j++)
				{
					if(w[i][j]==0) {
						w[i][j] = INF;
					}
				}
			}
			
			floyd(w, pi);						
			
			int min = INF;
			
			for(int i=1;i<w.length;i++) 
			{
				for(int j=1;j<w[0].length;j++)
				{		
					if(i!=j) {
						if(w[i][j] != INF && w[j][i] != INF && min > w[i][j] + w[j][i]) {
							min = w[i][j] + w[j][i];
						}						
					}
				}
			}
			
			System.out.println(min==INF?-1:min);
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void floyd(int[][] w, int[][] pi) {
		
		for(int k=1;k<w.length;k++) 
		{
			for(int i=1;i<w.length;i++)
			{
				for(int j=1;j<w.length;j++)
				{
					if(w[i][j] > w[i][k] + w[k][j]) {
						w[i][j] = w[i][k] + w[k][j];
						pi[i][j] = k;
					}
				}
			}
		}		
	}
	
	
}
