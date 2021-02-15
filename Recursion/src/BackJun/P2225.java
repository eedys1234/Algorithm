package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2225 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int k = Integer.valueOf(temp[1]);
			
			long[][] dp = new long[k+1][n+1];
			
			for(int j=0;j<dp[0].length;j++) 
			{
				dp[1][j] = 1;
			}
			
			//n 이하의 수가 중복사용되는 점이 핵심
			for(int i=2;i<dp.length;i++) 
			{
				for(int j=0;j<=n;j++) 
				{
					for(int l=0;l<=n;l++) 
					{
						if(j+l <= n) {
							dp[i][j+l] = (dp[i][j+l] + dp[i-1][j]) % 1000000000;
						}
					}
				}
			}
						
			System.out.println(dp[k][n]%1000000000);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
