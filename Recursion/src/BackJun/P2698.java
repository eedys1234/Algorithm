package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2698 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int t = Integer.valueOf(inbr.readLine());
			
			while(t-->0) {
				String[] temp = inbr.readLine().split(" ");
				
				int n = Integer.valueOf(temp[0]);
				int k = Integer.valueOf(temp[1]);
				long[][][] dp = new long[n+1][k+1][2];
											
				dp[1][0][0] = 1;
				dp[1][0][1] = 1;
				
				for(int i=1;i<=n;i++)
				{
					int min = Math.min(i, k);
					for(int j=0;j<=min;j++)
					{
						if(j==0) {
							dp[i][j][1] += dp[i-1][j][0];
						}
						else {
							dp[i][j][1] += dp[i-1][j-1][1] + dp[i-1][j][0];
						}
						dp[i][j][0] += dp[i-1][j][0] + dp[i-1][j][1];
					}
				}
				
				System.out.println(dp[n][k][0]+dp[n][k][1]);
			}			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
