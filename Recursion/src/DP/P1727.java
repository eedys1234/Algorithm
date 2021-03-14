package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1727 {

	public static int INF = 1000000000;
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
						
			int[] male = new int[n+1];
			int[] female = new int[m+1];
			int[][] dp = new int[n+1][m+1];
			
			temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++)
			{
				male[i+1] = Integer.valueOf(temp[i]);
			}
			
			temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++)
			{
				female[i+1] = Integer.valueOf(temp[i]);				
			}
			
			Arrays.sort(male);
			Arrays.sort(female);
			
			for(int i=1;i<=n;i++) 
			{
				for(int j=1;j<=m;j++)
				{
					if(i==j) {
						dp[i][j] = dp[i-1][j-1] + Math.abs(male[i]-female[j]);
					}
					else if(i>j) {
						dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1] + Math.abs(male[i]-female[j]));
					}
					else {
						dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j-1] + Math.abs(male[i]-female[j]));
					}
				}
			}
			
			System.out.println(dp[n][m]);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
