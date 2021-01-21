package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1574 {
	
	final static int BLANK = 1;

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			String[] temp = line.split(" ");
			
			int r = Integer.valueOf(temp[0]);
			int c = Integer.valueOf(temp[1]);
			int n = Integer.valueOf(temp[2]);
			
			int[][] maze = new int[r][c];
			int[] cols = new int[r];
			
			for(int i=0;i<n;i++) {
				line = inbr.readLine();
				temp = line.split(" ");
				
				int x = Integer.valueOf(temp[0]);
				int y = Integer.valueOf(temp[1]);
				
				maze[x-1][y-1] = BLANK;
			}
			
			for(int j=0;j<cols.length;j++) {
				cols[j] = -1;
			}
			
			count(maze, cols, 0);
			int max = 0;
			for(int j=0;j<cols.length;j++) {
				if(cols[j]!=-1) {
					max++;
				}
			}
			System.out.println(max);				

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean count(int[][] maze, int[] cols, int level) {
		if(level == maze.length) {
			return true;
		}
		else if(!check(cols, level)) {
			return false;
		}
		else {
			int cnt = 0;
			for(int j=0;j<maze[0].length;j++) {
				if(maze[level][j] != BLANK) {
					cols[level] = j;		
					count(maze, cols, level+1);
				}
				else {
					cnt++;
				}
			}
			
			if(cnt == maze[0].length) {
				count(maze, cols, level+1);				
			}
			
			return false;
		}
	}
	
	public static boolean check(int[] cols, int level) {
		
		for(int j=0;j<level;j++) {
			if(cols[j] == cols[level] && j != level) {
				return false;
			}
		}
		return true;
	}
	
}
