package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P17086 {
	
	public static int[][] next = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
	
	public static void main(String[] args) {
	
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
				
		try {
			line = inbr.readLine();
			String[] temp = line.split(" ");

			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			
			int[][] maze = new int[n][m];
			Queue<Integer> w = new LinkedList<>();
			Queue<Integer> h = new LinkedList<>();
			
			//¿Ï¼º
			for(int i=0;i<n;i++) 
			{
				line = inbr.readLine();
				temp = line.split(" ");

				for(int j=0;j<m;j++) 
				{
					int val = Integer.valueOf(temp[j]);
					if(val == 1) {
						w.offer(i);
						h.offer(j);
					}					
					maze[i][j] = val;
				}
			}
			
			int depth = BFS(w, h, maze);
			System.out.print(depth);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static int BFS(Queue<Integer> w, Queue<Integer> h, int[][] maze) {
		
		int depth = 0;
		int size = w.size();
		while(!w.isEmpty() && !h.isEmpty()) {

			int x = w.poll();
			int y = h.poll();
			size--;

			for(int[] n : next) {
				int cur_x = x+n[0];
				int cur_y = y+n[1];
				
				if(checked(maze, cur_x, cur_y)) {
					maze[cur_x][cur_y] = 2;
					w.offer(cur_x);
					h.offer(cur_y);
				}				
			}
			
			if(size == 0) {
				size = w.size();
				depth++;
			}

		}
		
		return depth-1;
	}	
	
	public static boolean checked(int[][] maze, int x, int y) {
		if(x < 0 || y < 0 || x >= maze.length || y >= maze[0].length) {
			return false;
		}
		else if(maze[x][y] != 0) {
			return false;
		}
		
		return true;
	}
}
