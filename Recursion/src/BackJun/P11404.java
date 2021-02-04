package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11404 {

	public static final int INF = 10000000;
	public static void main(String[] args) {
	
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int m = Integer.valueOf(inbr.readLine());
			
			int[][] w = new int[n+1][n+1];
			
			for(int i=1;i<w.length;i++)
			{
				for(int j=1;j<w.length;j++)
				{
					if(i==j) {
						w[i][j] = 0;
					}
					else if(w[i][j] == 0) {
						w[i][j] = INF;
					}
				}
			}
			
			for(int i=1;i<=m;i++) 
			{
				String[] temp = inbr.readLine().split(" ");				
				int x = Integer.valueOf(temp[0]);
				int y = Integer.valueOf(temp[1]);
				w[x][y] = Math.min(w[x][y], Integer.valueOf(temp[2]));
			}
						
			floyd(w);
			
			for(int i=1;i<w.length;i++)
			{
				for(int j=1;j<w.length;j++)
				{
					if(w[i][j]==INF)
					{
						w[i][j] = 0;
					}
					System.out.print(w[i][j] + " ");
				}
				System.out.println();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void floyd(int[][] w) {
		
		for(int k=1;k<w.length;k++)
		{
			for(int i=1;i<w.length;i++)
			{
				for(int j=1;j<w.length;j++)					
				{
					w[i][j] = Math.min(w[i][j], w[i][k] + w[k][j]);
				}
			}
		}
	}
}
