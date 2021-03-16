package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2228 {

	public static boolean[][] visited;
	public static int[] sequence;
	public static int INF = -3276801; 

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);			
			int m = Integer.valueOf(temp[1]);
			sequence = new int[n+1];
			int[][] dp = new int[m+1][n+1];
			visited = new boolean[m+1][n+1];
			
			for(int i=1;i<=n;i++) {
				sequence[i] = Integer.valueOf(inbr.readLine());
			}
			
			go(dp, m, n);
			
			System.out.println(dp[m][n]);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int go(int[][] dp, int m, int n) {
		
		if(m == 0) {
			return 0;
		}
		
		if(n <= 0) {
			return INF;
		}
		
		if(visited[m][n]) {
			return dp[m][n];
		}
		
		visited[m][n] = true;
		dp[m][n] = go(dp, m, n-1);
		int sum = 0;
		
		for(int i=n;i>0;i--) {
			sum += sequence[i];
			int tmp = go(dp, m-1, i-2) + sum;
			dp[m][n] = Math.max(dp[m][n], tmp);
		}
		
		return dp[m][n];
	}
}
