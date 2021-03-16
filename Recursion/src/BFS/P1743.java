package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class P1743 {
		
	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = inbr.readLine();
			String[] alpa = line.split(" ");

			int h = Integer.valueOf(alpa[0]);
			int w = Integer.valueOf(alpa[1]);
			int k = Integer.valueOf(alpa[2]);
			
			int[][] maze = new int[h][w];
			
			for(int i=0;i<k;i++) {
				line = inbr.readLine();
				String[] str = line.split(" ");
				int x = Integer.valueOf(str[0]);
				int y = Integer.valueOf(str[1]);
				
				maze[x-1][y-1] = 1;			
			}
			
			int max = 0;
			
			for(int i=0;i<maze.length;i++) {
				for(int j=0;j<maze[0].length;j++) {
					int result = countCells(maze, i, j);
					if(max <= result) {
						max = result;
					}
				}
			}
			
			System.out.print(max);
			
		}catch(Exception e) {
			
		}
	}
	
	public static int countCells(int[][] maze, int x, int y) {
		if(x<0 || y<0 || x >= maze.length || y >= maze[0].length) {
			return 0;
		}
		else if(maze[x][y] != 1) {
			return 0;
		}
		else {
			maze[x][y] = 2;
			return 1 + countCells(maze, x-1, y) + countCells(maze, x, y+1) + countCells(maze, x+1, y) + countCells(maze, x, y-1);
		}
	}

}

