package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11726 {

	public static long[] dp;
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			dp = new long[n+1];
			
			System.out.println(tiling(n));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static long tiling(int k) {
		
		if(k==0) return 1;
		else if(k==1) return 1;
		else if(k==2) return 2;
		
		long ret = dp[k];
		if(ret > 0) return ret;
		
		dp[k] = ret = (tiling(k-1) + tiling(k-2)) % 10007;
		return ret;
	}
}
