package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2169 {

	public static int[][] next = {{0, -1}, {1, 0}, {0, 1}};
	public static boolean[][] visited;
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			
			int[][] mars = new int[n+1][m+1];
			long[][][] dp = new long[n+1][m+1][3];
			visited = new boolean[n+1][m+1];
			
			for(int i=1;i<=n;i++) 
			{
				temp = inbr.readLine().split(" ");
				
				for(int j=0;j<temp.length;j++) 
				{					
					mars[i][j+1] = Integer.valueOf(temp[j]);
				}
			}
			
			for(int i=1;i<dp.length;i++) {
				for(int j=1;j<dp[0].length;j++) {
					dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = Integer.MIN_VALUE;
				}
			}
			
			visited[1][1] = true;
			System.out.println(dfs(mars, dp, 1, 1, 0));
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static long dfs(int[][] mars, long[][][] dp, int y, int x, int z) {
				
		if(x == mars[0].length-1 && y == mars.length-1) {
			return mars[y][x];
		}
		else if(dp[y][x][z] != Integer.MIN_VALUE){			
			return dp[y][x][z];
		}
		else {
						
			for(int i=0;i<next.length;i++) {
				
				int nextY = y+next[i][0];
				int nextX = x+next[i][1];
				
				if(nextX >= 1 && nextX >= 1 && nextY < mars.length && nextX < mars[0].length && !visited[nextY][nextX]) {
					
					visited[nextY][nextX] = true;
					dp[y][x][z] = Math.max(dp[y][x][z], dfs(mars, dp, nextY, nextX, i) + mars[y][x]);						
					visited[nextY][nextX] = false;
				}
			}
			
			return dp[y][x][z];
		}
		
	}
}
