package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P4811 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {		
			int t = Integer.valueOf(inbr.readLine());
			
			while(t!=0) {
				long[] dp = new long[t+1];
				dp[0] = 1;
				dp[1] = 1;
				
				for(int i=2;i<=t;i++) 
				{
					for(int j=1;j<=i;j++) 
					{
						dp[i] += dp[i-j]*dp[j-1];
					}
				} 
				
				System.out.println(dp[t]);
				t = Integer.valueOf(inbr.readLine());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
