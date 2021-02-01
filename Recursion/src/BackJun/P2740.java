package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2740 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);			
			int m = Integer.valueOf(temp[1]);
			
			int[][] a = new int[n+1][m+1];
			
			for(int i=1;i<=n;i++) 
			{
				temp = inbr.readLine().split(" ");
				
				for(int j=0;j<temp.length;j++) 
				{
					a[i][j+1] = Integer.valueOf(temp[j]);
				}
			}
			
			temp = inbr.readLine().split(" ");
			
			int k = Integer.valueOf(temp[1]);
			int[][] b = new int[m+1][k+1];

			for(int i=1;i<=m;i++) {
				
				temp = inbr.readLine().split(" ");
				
				for(int j=0;j<temp.length;j++) {
					b[i][j+1] = Integer.valueOf(temp[j]);
				}
			}
			
			int[][] c = multipleMatrix(a, b);
			
			for(int i=1;i<c.length;i++)
			{
				for(int j=1;j<c[0].length;j++)
				{
					System.out.print(c[i][j]+" ");
				}				
				System.out.println();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int[][] multipleMatrix(int[][] a, int[][] b) {
		
		int[][] c = new int[a.length][b[0].length];

		for(int i=1;i<a.length;i++) 
		{			
			for(int j=1;j<b[0].length;j++) 
			{				
				for(int k=1;k<b.length;k++) 
				{
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		
		return c;
	}
}
