package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1520 {

	public static int[][] next = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	public static int cnt = 0;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

		try {
			 String line = inbr.readLine();
			 String[] temp = line.split(" ");
			 
			 int r = Integer.valueOf(temp[0]);
			 int c = Integer.valueOf(temp[1]);
			 
			 int[][] path = new int[r+1][c+1];
			 int[][] result = new int[r+1][c+1];
			 boolean[][] visited = new boolean[r+1][c+1];
			 
			 for(int i=1;i<=r;i++) 
			 {
				 line = inbr.readLine();
				 temp = line.split(" ");
			
				 for(int j=0;j<temp.length;j++)
				 {
					path[i][j+1] = Integer.valueOf(temp[j]);
				 }
			 }
			 
			 getPathCount(path, visited, result, 1, 1);
			 
			 System.out.println(result[1][1]);
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static int getPathCount(int[][] path, boolean[][] visited, int[][] result, int x, int y) {
				
		if(x == visited.length-1 && y== visited[0].length-1) {
			result[x][y]+=1;
			return 1;
		}
		else if(visited[x][y]) {
			return result[x][y];
		}
		else {
			
			visited[x][y] = true;
			for(int[] c : next) {
				int cur_x = x+c[0];
				int cur_y = y+c[1];
				
				if(!(cur_x <= 0 || cur_y <= 0 || cur_x >= visited.length || cur_y >= visited[0].length)) {
					if(path[x][y] > path[cur_x][cur_y]) {
						result[x][y] += getPathCount(path, visited, result, cur_x, cur_y);					
						//visited[x][y] = false;					
					}
				}

			}

			return result[x][y];
		}
		
	}
	
}
