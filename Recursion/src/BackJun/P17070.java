package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P17070 {

	public static int[][] house = new int[18][18];
	public static int[][][] dp = new int[18][18][3];
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {			
			int n = Integer.valueOf(inbr.readLine());
			
			for(int i=1;i<=n;i++) {
				String[] temp = inbr.readLine().split(" ");
				for(int j=0;j<temp.length;j++)
				{
					house[i][j+1] = Integer.valueOf(temp[j]);
				}
			}
			
			dp[1][2][0] = 1;
			
			for(int y=1;y<=n;y++) 
			{
				for(int x=1;x<=n;x++) 
				{
					if(house[y][x+1] == 0) {
						dp[y][x+1][0] += dp[y][x][0] + dp[y][x][2];
					}
					
					if(house[y+1][x] == 0) {
						dp[y+1][x][1] += dp[y][x][1] + dp[y][x][2];
					}
					
					if(house[y][x+1] == 0 && house[y+1][x] == 0 && house[y+1][x+1] == 0) {
						dp[y+1][x+1][2] += dp[y][x][0] + dp[y][x][1] + dp[y][x][2]; 
					}
				}
			}
			
			long cnt = 0;
			for(int i=0;i<3;i++) {
				cnt += dp[n][n][i];
			}
			
			System.out.println(cnt);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}