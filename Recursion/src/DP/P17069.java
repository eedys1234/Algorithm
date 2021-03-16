package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P17069 {

	public static int[][] house;
	public static long[][][] dp;
		
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			house = new int[n+1][n+1];
			dp = new long[n+1][n+1][3];
			
			for(int i=1;i<=n;i++) 
			{
				String[] temp = inbr.readLine().split(" ");
				for(int j=0;j<temp.length;j++) 
				{
					house[i][j+1] = Integer.valueOf(temp[j]);
				}
			}
			
			go(1, 2, 0);

			System.out.println(dp[1][2][0]);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static long go(int y, int x, int direction) {
		
		if(y == house.length-1 && x == house[0].length-1) {
			dp[y][x][direction] = 1;
			return 1;
		}
		else if(dp[y][x][direction] > 0) {
			return dp[y][x][direction];
		}
		else {
			long cnt = 0;
			int[][] next;
			//가로
			if(direction == 0) {
			
				next = new int[2][3];
//				next = {{0,1,0}, {1,1,2}};
				next[0][0] = 0;
				next[0][1] = 1;
				next[0][2] = 0;

				next[1][0] = 1;
				next[1][1] = 1;
				next[1][2] = 2;

			}
			//세로
			else if(direction == 1) {
				
				next = new int[2][3];
//				next = {{1,0,1}, {1,1,2}};
				next[0][0] = 1;
				next[0][1] = 0;
				next[0][2] = 1;

				next[1][0] = 1;
				next[1][1] = 1;
				next[1][2] = 2;
				
			}
			//대각선
			else {
				
				next = new int[3][3];
//				next = {{1,0,1}, {0,1,0}, {1,1,2}};
				next[0][0] = 1;
				next[0][1] = 0;
				next[0][2] = 1;

				next[1][0] = 0;
				next[1][1] = 1;
				next[1][2] = 0;

				next[2][0] = 1;
				next[2][1] = 1;
				next[2][2] = 2;

			}
			
			for(int[] c : next) {
				
				int nextY = y+c[0];
				int nextX = x+c[1];
				
				if(nextY > 0 && nextX > 0 && nextY < house.length && nextX < house[0].length && house[nextY][nextX] == 0) {

					if(c[2] == 2) {
						if(house[nextY-1][nextX] == 1 || house[nextY][nextX-1] == 1) {
							continue;
						}
						if(house[nextY-1][nextX] == 0) house[nextY-1][nextX] = 2;						
						if(house[nextY][nextX-1] == 0) house[nextY][nextX-1] = 2;						
					}

					house[nextY][nextX] = 2;

					cnt += go(nextY, nextX, c[2]);

					if(c[2] == 2) {
						if(house[nextY-1][nextX] == 2) house[nextY-1][nextX] = 0;						
						if(house[nextY][nextX-1] == 2) house[nextY][nextX-1] = 0;						
					}
					
					house[nextY][nextX] = 0;
				}
			}
			
			dp[y][x][direction] = cnt;
			return cnt;
		}
	}
}
