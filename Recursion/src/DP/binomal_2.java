package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class binomal_2 {

	public static int[][] bino;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			String[] temp = line.split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int k = Integer.valueOf(temp[1]);
			
			bino = new int[n+1][n+1];
			
			int result = func(n, k);
			
			System.out.println(result);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int func(int n, int k) {
		
		for(int i=0;i<=n;i++) 
		{
			for(int j=0;j<=k && j<=i;j++) 
			{
				if(i==j || j==0) {
					bino[i][j] = 1;
				}
				else {
					bino[i][j] = bino[i-1][j] + bino[i-1][j-1];
				}
			}
		}
		
		return bino[n][k];
	}
}
