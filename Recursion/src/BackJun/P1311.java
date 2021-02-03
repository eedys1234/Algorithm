package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1311 {

	public static final int INF = 1000000000;
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			int n = Integer.valueOf(line);
			int[][] W = new int[n][n];
			int[][] dp = new int[n][1 << n];
			
			for(int i=1;i<=n;i++) 
			{
				line = inbr.readLine();
				String[] temp = line.split(" ");
				W[Integer.valueOf(temp[0])-1][Integer.valueOf(temp[1])-1] = Integer.valueOf(temp[2]);
			}
						
			System.out.println(TSP(0, 0, dp, W));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int TSP(int curr, int S, int[][] dp, int[][] W) {
		
		int ret = dp[curr][S];
		
		if(ret != 0) {
			return ret;
		}
		
		if(S == ((1 << W.length)-1)) {
			return 0;
		}
		
		ret = INF;
		
		for(int i=0;i<W.length;i++) {
			if((S & (1 << i)) == 0) {
				ret = Math.min(ret, TSP(i, S | (1 << i), dp, W)+W[curr][i]);
			}
		}
		
		dp[curr][S] = ret;		
		return ret;
		
	}
}
