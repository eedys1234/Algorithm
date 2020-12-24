
public class Miro {

	public static int N = 8;
	public static int PATH = 0;
	public static int WALL = 1;
	public static int BLOCK = 2;
	public static int VISIT = 3;
	public static int EXIT = 4;
	
	public static int[][] maze = {
		{0, 0, 0, 0, 0, 0, 0, 1},
		{0, 1, 1, 0, 1, 1, 0, 1},
		{0, 0, 0, 1, 0, 0, 0, 1},
		{0, 1, 0, 0, 1, 1, 0, 0},
		{0, 1, 1, 1, 0, 0, 1, 1},
		{0, 1, 0, 0, 0, 1, 0, 1},
		{0, 0, 0, 1, 0, 0, 0, 1},
		{0, 1, 1, 1, 0, 1, 0, 0},
	};
	
	public static void main(String[] args) {
		
		printMaze();
		findMiroPath(0, 0);
		printMaze();			
	}
	
	public static boolean findMiroPath(int x, int y) {
		
		if(x < 0 || y < 0 || x >= N || y >= N)
			return false;
		else if(x == N-1 && y == N-1) {
			maze[x][y] = EXIT;
			return true;
		}
		else if(maze[x][y] != PATH)
			return false;
		else {
			maze[x][y] = VISIT;
			if(findMiroPath(x, y-1) || findMiroPath(x+1, y) || findMiroPath(x, y+1) || findMiroPath(x-1, y)) {
				return true;
			}
			maze[x][y] = BLOCK;
			return false;
		}
	}
	
	public static void printMaze() {
		for(int i=0;i<maze.length;i++) {
			for(int j=0;j<maze[0].length;j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();		
	}
}
