package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1720 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			long[] dp = new long[n+1];
			
			dp[1] = 1;
			if(n>=2) {
				dp[2] = 3;				
			}
			
			for(int i=3;i<=n;i++)
			{
				dp[i] = dp[i-1] + dp[i-2] * 2;
			}
			
			long cnt = 0;
			
			if(n%2 == 1) {
				cnt = (dp[n] + dp[(n-1)/2])/2;
			}
			else {
				cnt = (dp[n] + dp[n/2] + dp[(n-2)/2] * 2)/2;
			}
			
			if(n==1) {
				cnt = dp[1];
			}
			else if(n==2) {
				cnt = dp[2];
			}
			
			System.out.println(cnt);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
