package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2133 {

	public static int[] dp;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			
			dp = new int[n+1];
			
			System.out.println(tiling(n));		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int tiling(int k) {
		
		if(k==0) return 1;
		else if(k==1) return 0;
		else if(k==2) return 3;
		
		int ret = dp[k];
		if(ret > 0) return ret;
		
		ret = 3 * tiling(k-2);
		
		for(int i=4;i<=k;i=i+2) {
			ret += 2 * tiling(k-i);
		}
		
		return dp[k] = ret;
	}
}
