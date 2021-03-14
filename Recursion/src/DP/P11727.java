package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11727 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			int[] dp = new int[n+1];
			
			dp[1] = 1;
			if(n >= 2) {
				dp[2] = 3;				
			}
			go(dp, n);
			
			System.out.println(dp[n]);			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int go(int[] dp, int k) {
		
		if(k == 0) {
			return 0;
		}
		
		if(k == 1) {
			return 1;
		}
		
		int ret = dp[k];
		if(ret > 0) return ret;
		
		dp[k] = (go(dp, k-2) * 2 + go(dp, k-1))%10007;
		return dp[k];
	}
}
