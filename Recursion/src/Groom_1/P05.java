package Groom_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P05 {
	
	public static int[][] next = {{1, 0}, {0, 1}, {0,-1}};
	public static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		
		//BFS로 풀이
		//최상단에서 최하단까지의 길이는 m
		//아래로만 내려갈 수 있기 때문에 이동 횟수는 m + a(가로로 이동한 경우)
		//이동 횟수 - m가 가장 작은 경로가 기준경로
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = inbr.readLine().split(" ");
		
		int n = Integer.valueOf(temp[0]);
		int m = Integer.valueOf(temp[1]);
		char[][] site = new char[m+1][n+1];
		visited = new boolean[m+1][n+1];
		int min = m * n + 1;
		int cnt = 0;
		
		for(int i=1;i<=m;i++) 
		{
			String line = inbr.readLine();
			for(int j=0;j<line.length();j++)
			{
				site[i][j+1] = line.charAt(j);
			}
		}

		for(int j=1;j<site[1].length;j++)
		{
			if(site[1][j] == 'c') {
				cnt = bfs(site, 1, j);
				
				if(cnt > -1) {
					min = Math.min(min, cnt - m);					
				}
				visitedInit();
			}
 		}
		
		if(min == m * n + 1) {			
			System.out.println("-1");			
		}
		else {
			System.out.println(min);			
		}
		
	}
	
	public static int bfs(char[][] site, int y, int x) {
		
		Queue<Location> queue = new LinkedList<>();
		
		queue.offer(new Location(x, y, 1));
		int depth = 0;
		int locationX = 0;
		int locationY = 0;
		int result = site.length * site[1].length + 1;
		
		while(!queue.isEmpty()) 
		{
			Location location = queue.poll();
			locationX = location.getX();
			locationY = location.getY();
			depth = location.getDepth();
			
			if(locationY == site.length-1) {
				result = Math.min(result, depth);
			}
			
			for(int[] p : next) {
				
				int nextX = locationX + p[1];
				int nextY = locationY + p[0];
				
				if(nextY > 0 && nextY < site.length && nextX > 0 && nextX < site[0].length && 
						site[nextY][nextX] == '.' && !visited[nextY][nextX]) {
				
					visited[nextY][nextX] = true;
					queue.offer(new Location(nextX, nextY, depth+1));
				}
			}
		}
		
		if(result == site.length * site[1].length + 1) {
			return -1;
		}
		
		return result;
	}
	
	public static void visitedInit() {

		for(int i=1;i<visited.length;i++) 
		{
			for(int j=1;j<visited[0].length;j++) 
			{
				visited[i][j] = false;
			}
		}	
	}
	
	public static class Location {
		
		int x;
		int y;
		int depth;
		
		public Location(int x, int y, int depth) {
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
