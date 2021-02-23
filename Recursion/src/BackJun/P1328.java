package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1328 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			int n = Integer.valueOf(temp[0]);
			int l = Integer.valueOf(temp[1]);
			int r = Integer.valueOf(temp[2]);
			
			long[][][] dp = new long[n+1][n+1][n+1];
			
			
			for(int i=1;i<=n;i++) {
				dp[n][i][n] = 1;
				dp[n][n][i] = 1;
			}
			
			dp[1][1][1] = 1;
			
			for(int k=2;k<=n;k++) 
			{
				for(int i=1;i<=l;i++)
				{
					for(int j=1;j<=r;j++)
					{
						dp[k][i][j] = (dp[k-1][i][j] * (k-2) + dp[k-1][i-1][j] + dp[k-1][i][j-1]) % 1000000007;						
					}
				}
			}
			
			System.out.println(dp[n][l][r]);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
