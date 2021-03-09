package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14503 {

	public static boolean isPowerOff = false;
	public static int cnt = 0;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			int[][] space = new int[n+1][m+1];
			
			temp = inbr.readLine().split(" ");
			int r = Integer.valueOf(temp[0]);
			int c = Integer.valueOf(temp[1]);
			int direction = Integer.valueOf(temp[2]);
			
			for(int i=1;i<=n;i++)
			{
				temp = inbr.readLine().split(" ");
				for(int j=0;j<m;j++)
				{
					space[i][j+1] = Integer.valueOf(temp[j]);
				}
			}

			dfs(space, r+1, c+1, direction);
			System.out.println(cnt);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void dfs(int[][] space, int y, int x, int direction) {

		int[] c =  new int[2];
		
		if(space[y][x] == 0) {
			space[y][x] = 2;
			cnt++;			
		}

		for(int i=0;i<4;i++) 
		{							
			direction = (direction+3) % 4;
			
			switch (direction) {
				case 0:
					c[0] = -1;
					c[1] = 0;
					break;
				case 1:
					c[0] = 0;
					c[1] = 1;				
					break;
				case 2:
					c[0] = 1;								
					c[1] = 0;
					break;
				case 3:
					c[0] = 0;
					c[1] = -1;												
					break;
				default:
					break;
			}

//				System.out.println(y+", "+x+" : "+direction);
			
			int nextY = y + c[0];
			int nextX = x + c[1];
			
			if(nextY <= 0 || nextY >= space.length || nextX <= 0 || nextX >= space[0].length && space[nextY][nextX] == 1) {
				continue;
			}
			
			if(space[nextY][nextX] == 0) {
				dfs(space, nextY, nextX, direction);					
				return ;
			}
		}
		
		//네 방향 모두 벽이거나 청소했거나 
		//후진
		int d = (direction+2) % 4;

		switch (d) {
			case 0:
				c[0] = -1;
				c[1] = 0;
				break;
			case 1:
				c[0] = 0;
				c[1] = 1;				
				break;
			case 2:
				c[0] = 1;								
				c[1] = 0;
				break;
			case 3:
				c[0] = 0;
				c[1] = -1;												
				break;
			default:
				break;
		}

		int nextY = y + c[0];
		int nextX = x + c[1];
						
		//후진방향 벽
		if(space[nextY][nextX] == 1) {
			//종료
			isPowerOff = true;
			return;
		}
		else {
			dfs(space, nextY, nextX, direction);
		}
	}
}
