package Bitmasking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2718 {

	public static int[] dp;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int t = Integer.valueOf(inbr.readLine());
			
			while(t-- > 0) {
				int n = Integer.valueOf(inbr.readLine());
				dp = new int[n+1];
				
				System.out.println(tiling(n));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static int tiling(int k) {
		
		if(k==0) return 1;
		else if(k==1) return 1;
		else if(k==2) return 5;
				
		int ret = dp[k];
		if(ret > 0) return ret;
		
		ret = tiling(k-1) + 4 * tiling(k-2);
		
		for(int i=3;i<=k;i++) {
			
			if(i%2==0) {
				ret += 3 * tiling(k-i);
			}
			else {
				ret += 2 * tiling(k-i);
			}			
		}
		
		return dp[k] = ret;
	}
}
