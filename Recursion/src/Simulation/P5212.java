package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P5212 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringBuilder sb = new StringBuilder();
			String[] temp = inbr.readLine().split(" ");
			int r = Integer.valueOf(temp[0]);
			int c = Integer.valueOf(temp[1]);
			char[][] map = new char[r+1][c+1];
			int[][] changeMap = new int[r+1][c+1];
			int[][] next = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			int sea = 0;
			int top = 1;
			int bottom = r;
			int left = 1;
			int right = c;
			int topCnt = 0;
			int bottomCnt = 0;
			int leftCnt = 0;
			int rightCnt = 0;
			
			//¹Ù´Ù : 0, ¶¥ : 1
			for(int i=1;i<map.length;i++) 
			{
				String line = inbr.readLine();
				for(int j=0;j<line.length();j++) 
				{
					map[i][j+1] = line.charAt(j);
					if(map[i][j+1] == 'X') {
						changeMap[i][j+1] = 1;
					}
				}
			}
			
			for(int i=1;i<map.length;i++) 
			{
				for(int j=1;j<map[0].length;j++)
				{
					sea = 0;
					for(int[] add : next) 
					{
						int nextR = i+add[0];
						int nextC = j+add[1];
						
						if(nextR <= 0 || nextR >= map.length || nextC <= 0 || nextC >= map[0].length) {
							sea++;
							continue;
						}
						
						if(map[nextR][nextC] == '.') {
							sea++;
						}
					}				
					
					if(sea >= 3) {
						changeMap[i][j] = -1;
					}
				}
			}
			
			for(int i=1;i<map.length;i++)
			{
				for(int j=1;j<map[0].length;j++)
				{
					if(changeMap[i][j] == -1) {
						map[i][j] = '.';
					}
					else if(changeMap[i][j] == 1){
						map[i][j] = 'X';
					}
				}
			}						

			//À§
			while(top < bottom) {
				
				for(int j=1;j<map[0].length;j++)
				{
					if(map[top][j] == '.') {
						topCnt++;
					}
					if(map[bottom][j] == '.') {
						bottomCnt++;
					}
				}
								
				if(topCnt == c) {
					top++;
				}
				
				if(bottomCnt == c) {
					bottom--;
				}

				if(topCnt < c && bottomCnt < c) {
					break;
				}

				topCnt = 0;
				bottomCnt = 0;
				
			}
			
			while(left < right) 
			{

				for(int i=1;i<map.length;i++)
				{
					if(map[i][left] == '.') {
						leftCnt++;
					}
					if(map[i][right] == '.') {
						rightCnt++;
					}
				}

				if(leftCnt == r) {
					left++;
				}

				if(rightCnt == r) {
					right--;
				}
				
				if(leftCnt < r && rightCnt < r) {
					break;
				}

				leftCnt = 0;
				rightCnt = 0;
			}

			for(int i=top;i<=bottom;i++)
			{
				for(int j=left;j<=right;j++)
				{
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}						

			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
