package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2178 {
	
	public static final int PATH = 1;
	public static final int WALL = 2;
	public static final int VISITED = 3;
	public static final int BLOCK = 4;
	
	
	public static int[][] next = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			
			String[] temp = line.split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			
			int[][] miro = new int[n][m];
			
			for(int i=0;i<miro.length;i++) 
			{
				line = inbr.readLine();
				for(int j=0;j<miro[0].length;j++) {
					miro[i][j] = Integer.valueOf(line.charAt(j)+"");
				}
			}
			

			int cnt = search(miro);
			System.out.print(cnt);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int search(int[][] miro) {
		int cnt = 0;
		
		cnt = BFS(miro, 0, 0);
		return cnt;
	}
	
	public static int BFS(int[][] miro, int start_x, int start_y) {
		
		Queue<Ent> q = new LinkedList<>();
		int depth = 1;
		q.offer(new P2178.Ent(start_x, start_y, depth));
		
		while(!q.isEmpty()) {
			Ent e = q.poll();
			int x = e.x;
			int y = e.y;
			depth = e.depth;
						
			for(int[] n : next) {
				int next_x = x + n[0];
				int next_y = y + n[1];
				int result = check(miro, next_x, next_y);
				if(result == 1)
				{
					q.offer(new P2178.Ent(next_x, next_y, depth+1));										
				}
				else if(result == 2) {
					depth += 1;
					q.clear();
					break;
				}
			}			
		}
		
		return depth;
	}
	
	public static int check(int[][] miro, int x, int y) {
		
		if(x < 0 || y < 0 || x >= miro.length || y >= miro[0].length) {
			return 0;
		}
		else if(x == miro.length-1 && y == miro[0].length-1) {
			miro[x][y] = VISITED;
			return 2;
		}
		else if(miro[x][y] != PATH) {
			return 0;
		}
		
		miro[x][y] = VISITED;
		return 1;
		
	}

	static class Ent {
		
		int x;
		int y;
		int depth;
		
		public Ent(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	
	}
}
