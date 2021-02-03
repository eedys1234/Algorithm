package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2098 {
	
	public static final int INF = 1000000000;
	
	public static void main(String[] args) {
				
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			int k = 0;
			int[][] W = new int[n][n];
			int[][] dp = new int[n][(1 << n)];
			
			while(k<n) {
			
				String line = inbr.readLine();
				String[] temp = line.split(" ");
				
				for(int j=0;j<temp.length;j++) {
					W[k][j] = Integer.valueOf(temp[j]);
				}
				k++;
			}
			
			int min = go(0, 1, dp, W);
			System.out.println(min);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int go(int curr, int S, int[][] dp, int[][] W) {
		
		int ret = dp[curr][S];
		
		//
		if(ret != 0) {
			return ret;
		}
		
		if(S ==((1 << W.length)-1)) {
			if(W[curr][0] != 0) {
				return W[curr][0];
			}
			return INF;
		}
		
		ret = INF;
		
		for(int i=0;i<W.length;i++) {
			if(W[curr][i] > 0 && (S & (1 << i)) == 0) {
				ret = Math.min(ret, go(i, S | (1 << i), dp, W) + W[curr][i]);
			}
		}
		
		dp[curr][S] = ret;
		
		return ret;
	}
}
