package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P3106 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
		
			String[] temp = inbr.readLine().split(" ");

			int r = Integer.valueOf(temp[0]);
			int c = Integer.valueOf(temp[1]);
			
			char[][] space = new char[r][c];
			
			for(int i=0;i<r;i++) 
			{
				String line = inbr.readLine();
				for(int j=0;j<line.length();j++) {
					space[i][j] = line.charAt(j);
				}
			}
			
			int max = 0;
			
			for(int i=0;i<space.length;i++) {
				max += search(space, i, 0, i);				
			}
			
			System.out.println(max);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int search(char[][] space, int y, int x, int start) {
		
		int cnt = 0;
		
		if(x == space[0].length-1) {
			space[y][x] = '#';
			return 1;
		}		
		else {
			
			//space[y][x] = '#';
			
			//start : 1, y : 3, start - y < 0 : up, start - y > 0 : down
			int place = start - y;
			int[] nextOrder = new int[3];
			nextOrder[0] = -1;
			nextOrder[1] = 0;
			nextOrder[2] = 1;
			
			/*
			if(place > 0) {
				nextOrder[0] = 1;
				nextOrder[1] = 0;
				nextOrder[2] = -1;
			}
			else if(place < 0){
				nextOrder[0] = -1;
				nextOrder[1] = 0;
				nextOrder[2] = 1;
			}
			else {
				nextOrder[0] = 0;
				nextOrder[1] = -1;
				nextOrder[2] = 1;
			}
			*/
			
			for(int i=0;i<nextOrder.length;i++) {
				
				int curY = y + nextOrder[i];
				int curX = x + 1;
				
				if(curY>= 0 && curY < space.length && space[curY][curX] == '.') {
					space[curY][curX] = '#';
					cnt = search(space, curY, curX, start);					
					
					if(cnt == 1) {
						return cnt;
					}
					//space[curY][curX] = '.';
				}
			}
						
		}
		
		return cnt;
	}
}
