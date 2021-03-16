package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1937 {

	public static int[][] next = {{-1, 0}, {0, -1}, {1,0}, {0,1}};
	public static boolean[][] visited;
	
	public static void main(String[] args) {
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			int[][] forest = new int[n+1][n+1];
			int[][] dp = new int[n+1][n+1];
			visited = new boolean[n+1][n+1];

			for(int i=1;i<=n;i++) {
				String[] temp = inbr.readLine().split(" ");
				for(int j=0;j<temp.length;j++) {
					forest[i][j+1] = Integer.valueOf(temp[j]);
				}
			}
			
			int max = 0;
												
			for(int i=1;i<forest.length;i++) 
			{
				for(int j=1;j<forest[0].length;j++) 
				{
					int value = dfs(dp, forest, i, j);
					if(max < value) {
						max = value;
					}
				}
			}
			
			System.out.println(max);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static int dfs(int[][] dp, int[][] forest, int y, int x) {
		
		if(visited[y][x]) {
			return dp[y][x];
		}
		else {
			visited[y][x] = true;
			dp[y][x] = 1;
			
			for(int[] c : next) {
				
				int nextX = x + c[1];
				int nextY = y + c[0];
				
				if(0<=nextX && 0<=nextY && nextX < forest[0].length && nextY < forest.length) {
					
					if(forest[y][x] < forest[nextY][nextX]) {
						dp[y][x] = Math.max(dp[y][x], dfs(dp, forest, nextY, nextX)+1);
					}
				}				
			}
			
			return dp[y][x];
			
		}		
	}
}

