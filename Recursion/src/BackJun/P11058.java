package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11058 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			long[] dp = new long[n+1];
			
			for(int i=1;i<=n;i++)
			{
				dp[i] = dp[i-1]+1;
				for(int j=3;j<=i;j++)
				{
					dp[i] = Math.max(dp[i], dp[i-j]*(j-1));
				}
			}

			System.out.println(dp[n]);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
