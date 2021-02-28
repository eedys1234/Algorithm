package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14852 {

	public static long[][] dp;
	
	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			dp = new long[n+1][2];
			
			tiling(n);

			System.out.println(dp[n][0]);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void tiling(int k) {
		
		dp[0][0] = 1;
		dp[1][0] = 2;
		if(k>=2) {
			dp[2][0] = 7;
			dp[2][1] = 0;			
		}
		
		for(int i=3;i<=k;i++)
		{
			dp[i][1] = (dp[i-1][1] + dp[i-3][0]) % 1000000007;
			dp[i][0] = (dp[i-2][0] * 3 + dp[i-1][0] * 2 + dp[i][1] * 2) % 1000000007;
		}
	}
}
