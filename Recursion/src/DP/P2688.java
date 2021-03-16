package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2688 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int t = Integer.valueOf(inbr.readLine());
			
			while(t-->0) {
				
				int n = Integer.valueOf(inbr.readLine());
				long[][] dp = new long[n+1][10];
				
				for(int j=0;j<10;j++)
				{
					dp[1][j] = 1;
				}
				
				for(int i=2;i<=n;i++) 
				{
					for(int j=0;j<10;j++)
					{
						for(int k=0;k<=j;k++)
						{
							dp[i][j] += dp[i-1][k];							
						}
					}
				}
				
				long sum = 0;
				for(int j=0;j<10;j++)
				{
					sum += dp[n][j];
				}
				
				System.out.println(sum);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
