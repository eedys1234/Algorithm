package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1563 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			
			int[][][] dp = new int[n+1][3][4];
			
			System.out.println(attend(dp, 0, 0, 0));
						
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int attend(int[][][] dp, int day, int late, int absent) {
		
		if(late == 2 || absent == 3) {
			return 0;
		}
		
		if(day == dp.length-1) {
			return 1;
		}
		
		int ret = dp[day][late][absent];
		
		if(ret > 0) return ret;
		
		
		dp[day][late][absent] = (attend(dp, day+1, late, 0) + attend(dp, day+1, late+1, 0) + attend(dp, day+1, late, absent+1)) % 1000000;
		return dp[day][late][absent];
	}
}
