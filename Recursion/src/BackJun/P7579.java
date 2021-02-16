package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P7579 {
	
	public static int INF = 100000000;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			int[] memory = new int[n+1];
			int[] cost = new int[n+1];
			long[][] dp = new long[n+1][10001];
			int res = INF;
			
			temp = inbr.readLine().split(" ");
			
			for(int i=0;i<n;i++) {
				memory[i+1] = Integer.valueOf(temp[i]);				
			}
			
			temp = inbr.readLine().split(" ");
			
			for(int i=0;i<n;i++) {
				cost[i+1] = Integer.valueOf(temp[i]);
			}
			
			dp[1][cost[1]] = memory[1];
			
			for(int i=1;i<dp.length;i++) 
			{
				for(int j=1;j<dp[0].length;j++) 
				{
					if(j < cost[i]) {
						dp[i][j] = dp[i-1][j];
					}
					else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]]+memory[i]);
					}
					
					if(dp[i][j] >= m) {
						res = Math.min(res, j);
					}
				}
			}
			
			System.out.println(res);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
