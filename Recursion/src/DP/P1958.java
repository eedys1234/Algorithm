package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1958 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String x = inbr.readLine();
			String y = inbr.readLine();
			String z = inbr.readLine();
			
			int m = x.length();
			int n = y.length();
			int l = z.length();
			
			int[][][] result = new int[m+1][n+1][l+1];
			
			for(int i=0;i<m;i++) 
			{
				for(int j=0;j<n;j++)
				{
					for(int k=0;k<l;k++) 
					{
						if(x.charAt(i) == y.charAt(j) && x.charAt(i) == z.charAt(k)) {
							result[i+1][j+1][k+1] = result[i][j][k] + 1;
						}
						else {
							int max = Math.max(result[i][j+1][k+1], result[i+1][j][k+1]);
							max = Math.max(max, result[i+1][j+1][k]);
							
							result[i+1][j+1][k+1] = max;
						}
					}
				}
			}
			
			System.out.println(result[m][n][l]);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
