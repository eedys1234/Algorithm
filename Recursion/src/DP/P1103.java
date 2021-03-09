package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1103 {

	public static int[][] dp;
	public static boolean[][] visited;
	public static boolean isCycle = false;

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			String[][] board = new String[n+1][m+1];
			dp = new int[n+1][m+1];
			visited = new boolean[n+1][m+1];
			int max = 0;
			
			for(int i=0;i<n;i++) 
			{
				String line = inbr.readLine();
				for(int j=0;j<line.length();j++)
				{
					board[i+1][j+1] = String.valueOf(line.charAt(j));					
				}				
			}
			
			go(board, 1, 1);
						
			if(isCycle) {
				isCycle = false;
				System.out.print("-1");				
				return;
			}
			
			for(int i=1;i<dp.length;i++)
			{
				for(int j=1;j<dp[0].length;j++)
				{
					max = Math.max(max, dp[i][j]);
				}
			}

			System.out.println(max);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int go(String[][] board, int y, int x) {
		
		if(y <= 0 || x  <= 0 || y >= board.length || x >= board[0].length) {
			return 0;
		}
		else if("H".equals(board[y][x])) {
			return 0;
		}
		else if(visited[y][x]) {
			isCycle = true;
			return 0;
		}
		else if(dp[y][x] > 0) {
			return dp[y][x];
		}
		else {
			
			int distance = Integer.valueOf(board[y][x]);
			int[][] next = {{-1 * distance, 0}, {distance, 0}, {0, -1 * distance}, {0, distance}};

			for(int[] c : next) {
			
				int nextY = y + c[0];
				int nextX = x + c[1];	
				
				visited[y][x] = true;
				dp[y][x] = Math.max(dp[y][x], go(board, nextY, nextX)+1);											
				visited[y][x] = false;
				
			}			
						
			return dp[y][x];
		}
	}
}
