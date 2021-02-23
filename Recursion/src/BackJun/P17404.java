package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P17404 {
	
	public static int INF = 1000000000;
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int res = INF;
			int n = Integer.valueOf(inbr.readLine());
			int[][] rgb = new int[3][n+1];
			int[][] colors = new int[3][n+1];
			
			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");
				rgb[0][i+1] = Integer.valueOf(temp[0]);
				rgb[1][i+1] = Integer.valueOf(temp[1]);
				rgb[2][i+1] = Integer.valueOf(temp[2]);
			}

			for(int k=0;k<=2;k++) 
			{
				for(int i=0;i<=2;i++) {
					if(k == i) colors[i][1] = rgb[i][1];					
					else colors[i][1] = INF;
				}
				
				for(int i=2;i<=n;i++) 
				{
					colors[0][i] = Math.min(colors[1][i-1], colors[2][i-1]) + rgb[0][i];
					colors[1][i] = Math.min(colors[0][i-1], colors[2][i-1]) + rgb[1][i];
					colors[2][i] = Math.min(colors[0][i-1], colors[1][i-1]) + rgb[2][i];				
				}				
				
				for(int i=0;i<=2;i++) {
					if(k == i) continue;
					else res = Math.min(res, colors[i][n]) ;
				}
			}
						
			System.out.println(res);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
