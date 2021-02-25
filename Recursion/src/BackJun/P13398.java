package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P13398 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] sequence = new int[n+1];
			long[][] dp = new long[n+1][2];
			String[] temp = inbr.readLine().split(" ");
			long res = -1001;
			
			for(int j=0;j<temp.length;j++)
			{
				sequence[j+1] = Integer.valueOf(temp[j]);
			}
			
			for(int i=0;i<=1;i++)
			{
				for(int j=0;j<=n;j++)
				{
					dp[j][i] = -1001;
				}
			}
						
			for(int i=1;i<=n;i++)
			{
				dp[i][0] = Math.max(dp[i-1][0] + sequence[i], sequence[i]);
				dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + sequence[i]);
			}
			
			for(int i=1;i<=n;i++)
			{
				res = Math.max(res, dp[i][0]);
				res = Math.max(res, dp[i][1]);
			
			//	System.out.println(dp[i][0]+", "+dp[i][1]);
			}
			
			System.out.println(res);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
