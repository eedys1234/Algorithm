package Programmers_2020;

import java.util.LinkedList;
import java.util.Queue;

public class P07 {

	public static boolean[][][] visited;
	public static int[] moveY = {1, -1, 0, 0};
	public static int[] moveX = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
				
		int[][] board = {
			{0, 0, 0, 1, 1}, 
			{0, 0, 0, 1, 0}, 
			{0, 1, 0, 1, 1}, 
			{1, 1, 0, 0, 1}, 
			{0, 0, 0, 0, 0}
		};
		
		System.out.println(solution(board));
	}
	
    public static int solution(int[][] board) {
    	visited = new boolean[board.length][board[0].length][2];
        int answer = bfs(board, 0, 0, 0);
                
        return answer;
    }
    
    public static int bfs(int[][] board, int y, int x, int z) {
    	
    	Queue<Location> queue = new LinkedList<>();
    	int depth = 0;
    	int min = Integer.MAX_VALUE;
    	int[][][] nodes = new int[board.length][board[0].length][2];
    	
    	for(int i=0;i<board.length;i++)
    	{
    		for(int j=0;j<board[0].length-1;j++) 
    		{
    			if(board[i][j] == 0 && board[i][j+1] == 0) {
    				nodes[i][j][0] = 1;
    			}
    		}
    	}
    	
     	for(int i=0;i<board.length-1;i++)
    	{
    		for(int j=0;j<board[0].length;j++) 
    		{
    			if(board[i][j] == 0 && board[i+1][j] == 0) {
    				nodes[i][j][1] = 1;
    			}
    		}
    	}
     	
    	queue.offer(new Location(y, x, z, depth));
    	visited[y][x][z] = true;
    	
    	while(!queue.isEmpty()) {
    	
    		Location location = queue.poll();
    		int curY = location.getY();
    		int curX = location.getX();
    		int curZ = location.getZ();
    		depth = location.getDepth();
    		
    		if((curZ == 0 && curY == board.length-1 && curX == board[0].length-2) || 
    				(curZ == 1 && curY == board.length-2 && curX == board[0].length-1)) {
    			return depth;    			
    		}
    		
    		//상하좌우 이동
    		for(int i=0;i<moveY.length;i++) {
    			
    			int nextY = curY + moveY[i];
    			int nextX = curX + moveX[i];
    			
    			if(nextY < 0 || nextX < 0 || nextY >= board.length || nextX >= board[0].length) {
    				continue;
    			}
    			
    			if(nodes[nextY][nextX][curZ] == 1 && !visited[nextY][nextX][curZ]) {
    				visited[nextY][nextX][curZ] = true;
    				queue.offer(new Location(nextY, nextX, curZ, depth+1));
    			}
    		}
    		
    		//가로회전
    		if(z == 0) {
    			
    			//윗 방향
    			if(curY-1 >=0 && board[curY-1][curX] == 0 && board[curY-1][curX+1] == 0) {
    				if(!visited[curY-1][curX][1]) {
    					visited[curY-1][curX][1] = true;
    					queue.offer(new Location(curY-1, curX, 1, depth+1));
    				}
    				if(!visited[curY-1][curX+1][1]) {
    					visited[curY-1][curX+1][1] = true;
    					queue.offer(new Location(curY-1, curX+1, 1, depth+1));
    				}
    			}
    			
    			//아래방향    			
    			if(curX+1 < board[0].length && curY+1 < board.length && board[curY+1][curX] == 0 && board[curY+1][curX+1] == 0){
    				if(!visited[curY][curX][1]) {
    					visited[curY][curX][1] = true;
    					queue.offer(new Location(curY, curX, 1, depth+1));
    				}
    				if(!visited[curY][curX+1][1]) {
    					visited[curY][curX+1][1] = true;
    					queue.offer(new Location(curY, curX+1, 1, depth+1));
    				}
    			}    			
    		}
    		//세로회전
    		else {
    			//왼쪽
    			if(curX-1 >=0 && board[curY][curX-1] == 0 && board[curY+1][curX-1] == 0) {
    				if(!visited[curY][curX-1][0]) {
    					visited[curY][curX-1][0] = true;
    					queue.offer(new Location(curY, curX-1, 0, depth+1));
    				}
    				if(!visited[curY+1][curX-1][0]) {
    					visited[curY+1][curX-1][0] = true;
    					queue.offer(new Location(curY+1, curX-1, 0, depth+1));
    				}
    			}
    			
    			//오른쪽
    			if(curY+1 < board.length && curX+1 < board[0].length && board[curY][curX+1] == 0 && board[curY+1][curX+1] == 0) {
    				if(!visited[curY][curX][0]) {
    					visited[curY][curX][0] = true;
    					queue.offer(new Location(curY, curX, 0, depth+1));
    				}
    				
    				if(!visited[curY+1][curX][0]) {
    					visited[curY+1][curX][0] = true;
    					queue.offer(new Location(curY+1, curX, 0, depth+1));
    				}
    			}
    		}
    	}
    	
    	return min;
    }
    
    public static class Location {
    	
    	private int y;
    	private int x;
    	private int z;
    	private int depth;
    	private int dir;
    	
    	public Location(int y, int x, int z, int depth) {
    		
    		this.y = y;
    		this.x = x;
    		this.z = z;
    		this.depth = depth;
   
    	}

		public int getY() {
			return y;
		}

		public int getX() {
			return x;
		}
		
		public int getZ() {
			return z;
		}

		public int getDepth() {
			return depth;
		}

		public int getDir() {
			return dir;
		}    	
    	
    }
}

