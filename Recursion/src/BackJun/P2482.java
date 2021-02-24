package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2482 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int k = Integer.valueOf(inbr.readLine());
			long[][] dp = new long[n+1][k+1];
			
			for(int i=1;i<=n;i++)
			{
				dp[i][1] = i;
			}
			
			for(int i=4;i<=n;i++) 
			{
				int min = Math.min(i, k);
				for(int j=2;j<=min;j++)
				{
					dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) % 1000000003;
				}
			}
			
			System.out.println(dp[n][k]);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
