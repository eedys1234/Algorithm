package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P7562 {

	public static int[][] next = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			
			int t = Integer.valueOf(line);
			
			while(t-->0) {
			
				line = inbr.readLine();
				int n = Integer.valueOf(line);
				
				int[][] chess = new int[n][n];
				
				String[] temp = inbr.readLine().split(" ");
				int start_x = Integer.valueOf(temp[0]);
				int start_y = Integer.valueOf(temp[1]);

				temp = inbr.readLine().split(" ");
				int target_x = Integer.valueOf(temp[0]);
				int target_y = Integer.valueOf(temp[1]);
				
				int length = BFS(chess, start_x, start_y, target_x, target_y);
				System.out.println(length);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static int BFS(int[][] chess, int start_x, int start_y, int target_x, int target_y) {
		
		if(start_x == target_x && start_y == target_y) {
			return 0;
		}

		int depth = 0;
		Queue<Location> queue = new LinkedList<Location>();
				
		queue.offer(new Location(start_x, start_y, 0));
		
		while(!queue.isEmpty()) {
			
			Location lo = queue.poll();
			int x = lo.getX();
			int y = lo.getY();
			depth = lo.getDepth();
			
			if(x == target_x && y == target_y) {
				break;
			}
			else if(chess[x][y] != 1) {
				chess[x][y] = 1;
				
				for(int[] c : next) {
					int cur_x = x + c[0];
					int cur_y = y + c[1];					
					if(!(cur_x < 0 || cur_y < 0 || cur_x >= chess.length || cur_y >= chess.length)) {
						queue.offer(new Location(cur_x, cur_y, depth+1));						
					}
				}
			}				
		}
		
		return depth;
	}
	
	public static class Location {
		
		public int x;
		public int y;
		public int depth;
		
		Location(int x, int y, int depth) {
			this.x = x;			
			this.y = y;
			this.depth = depth;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getDepth() {
			return depth;
		}
		
		
	}
}
