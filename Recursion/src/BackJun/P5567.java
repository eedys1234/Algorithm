package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P5567 {

	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			 String line = inbr.readLine();
			 int n = Integer.valueOf(line);
			 line = inbr.readLine();
			 int m = Integer.valueOf(line);

			 int[][] location = new int[2][m];
						 
			 for(int i=0;i<m;i++) {
				 line = inbr.readLine();
				 String[] temp = line.split(" ");
				 location[0][i] = Integer.valueOf(temp[0]);
				 location[1][i] = Integer.valueOf(temp[1]);
			 }
			 
			 int poeple = BFS(location, n);
			System.out.println(poeple);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int BFS(int[][] location, int n) {

		int depth = 0;
		int cnt = 0;
		Queue<Pair> queue = new LinkedList<Pair>();
		//HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		boolean[] invited = new boolean[n+1];
		
		 for(int i=0;i<location.length;i++) 
		 {
			 for(int j=0;j<location[0].length;j++)
			 {
				 if(i==0 && location[i][j] == 1 && location[0][j] != location[1][j]) {
					 if(!invited[location[1][j]]) {
						 invited[location[1][j]] = true;
						queue.offer(new Pair(location[0][j], location[1][j], 1));
						cnt++;						 
					 }
				 }
				 else if(i== 1 && location[i][j] == 1 && location[0][j] != location[1][j]) {
					 if(!invited[location[0][j]]) {
						invited[location[0][j]] = true;
						int temp = location[0][j];
						location[0][j] = location[1][j];
						location[1][j] = temp;
						queue.offer(new Pair(location[0][j], location[1][j], 1));
						cnt++;
					 }
				 }
			 }
		 }
		
		while(!queue.isEmpty()) {
			
			Pair pair = queue.poll();
			int x = pair.getX();
			int y = pair.getY();
			depth = pair.getDepth();

			if(depth == 2) {
				break;
			}
			
			for(int j=0;j<location[0].length;j++)
			{
				 if(location[0][j] == y) {
					 if(!invited[location[1][j]] && location[1][j] != 1 ) {
						invited[location[1][j]] = true;
						cnt++;
						queue.offer (new Pair(location[0][j], location[1][j], depth+1));						 
					 }
				 }
				 else if(location[1][j] == y) {
					 if(!invited[location[0][j]] && location[0][j] != 1 ) {
						invited[location[0][j]] = true;
						cnt++;
						queue.offer(new Pair(location[0][j], location[1][j], depth+1));						 
					 }
				 }
			}
		}
		
		return cnt;
	}	
	
	public static class Pair {
		
		public int x;
		public int y;
		public int depth;
		
		public Pair(int x, int y, int depth) {
			
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
