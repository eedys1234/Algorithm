package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P17144 {

	public static void main(String[] args) throws Exception {
						
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		int result = 0;
		
		int r = 0;
		int c = 0;
		int t = 0;

		String[] temp = inbr.readLine().split(" ");		
		r = Integer.valueOf(temp[0]);
		c = Integer.valueOf(temp[1]);
		t = Integer.valueOf(temp[2]);

		int[][] room = new int[r+1][c+1];
		int[] cleaner = new int[2];
		int k = 0;
		
		for(int i=1;i<=r;i++) 
		{
			temp = inbr.readLine().split(" ");

			for(int j=0;j<temp.length;j++)
			{
				room[i][j+1] = Integer.valueOf(temp[j]);

				//공기청정기 위치
				if(room[i][j+1] == -1) {
					cleaner[k++] = i;
				}
			}			
		}

		
		//t초 이후
		while(t-- > 0) {			
			room = spread(room, r, c);
			clockWise(room, cleaner, r, c);
			antiClockWise(room, cleaner, r, c);
		}

		for(int i=1;i<=r;i++)
		{
			for(int j=1;j<=c;j++)
			{
				result += room[i][j];
			}
		}
		
		System.out.println(result);
	}

	//확산함수
	public static int[][] spread(int[][] room, int r, int c) {
		
		int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int[][] temp = new int[room.length][room[0].length];
		
		for(int i=1;i<room.length;i++) 
		{
			for(int j=1;j<room[0].length;j++)
			{
				temp[i][j] = room[i][j];
			}
		}
		
		for(int i=1;i<=r;i++)
		{
			for(int j=1;j<=c;j++)
			{
				int cnt = 0;
				if(room[i][j] > 0) {
					
					for(int[] p : next) 
					{
						int nextR = i + p[0];
						int nextC = j + p[1];
						
						//범위 벗어난 경우
						if(nextR <= 0 || nextR > r || nextC <= 0 || nextC > c) {
							continue;
						}
						
						if(room[nextR][nextC] > -1) {
							temp[nextR][nextC] += room[i][j]/5;							
							//확산된 방향 수 
							cnt++;
						}
						
					}
					
					temp[i][j] -= (room[i][j]/5) * cnt;
				}
			}
		}
		
		return temp;
	}
	
	public static void clockWise(int[][] room, int[] cleaner, int r, int c) {
		
		//시계 방향
		for(int i=cleaner[0]-1;i>=1;i--) 
		{
			room[i+1][1] = room[i][1];
		}
		
		for(int j=2;j<=c;j++) {
			room[1][j-1] = room[1][j];
		}
		
		for(int i=1;i<cleaner[0];i++)
		{
			room[i][c] = room[i+1][c];
		}

		for(int j=c-1;j>=1;j--)
		{
			room[cleaner[0]][j+1] = room[cleaner[0]][j];				
		}
					
		room[cleaner[0]][1] = 0;
		room[cleaner[0]][2] = 0;
	}
	
	public static void antiClockWise(int[][] room, int[] cleaner, int r, int c) {
		
		//반시계 방향
		for(int i=cleaner[1];i<r;i++) 
		{
			room[i][1] = room[i+1][1];
		}
		
		for(int j=2;j<=c;j++) {
			room[r][j-1] = room[r][j];
		}
		
		for(int i=r-1;i>=cleaner[0];i--)
		{
			room[i+1][c] = room[i][c];
		}

		for(int j=c-1;j>=1;j--)
		{
			room[cleaner[1]][j+1] = room[cleaner[1]][j];				
		}

		room[cleaner[1]][1] = 0;
		room[cleaner[1]][2] = 0;
	}
}
