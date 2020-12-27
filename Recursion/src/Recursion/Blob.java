package Recursion;

public class Blob {

	public static int BACKGROUND_PIXEL = 0;
	public static int IMAGE_PIXEL = 1;
	public static int ALREADY_PIXEL = 2;
	
	public static void main(String[] args) {
		
		int[][] maze = {
			{1, 0, 0, 0, 0, 0, 0, 1},	
			{0, 1, 1, 0, 0, 1, 0, 0},	
			{1, 1, 0, 0, 1, 0, 1, 0},	
			{0, 0, 0, 0, 0, 1, 0, 0},	
			{0, 1, 0, 1, 0, 1, 0, 0},	
			{0, 1, 0, 1, 0, 1, 0, 0},					
			{1, 0, 0, 0, 1, 0, 0, 1},					
			{0, 1, 1, 0, 0, 1, 1, 1},					
		};
		
		System.out.println(countCells(maze, 1, 5));
		
	}
	
	public static int countCells(int[][] maze, int x, int y) {
		
		if(x < 0 || y < 0 || x >= maze.length || y >= maze.length) {
			return 0;
		}
		else if(maze[x][y] != IMAGE_PIXEL) {
			return 0;
		}
		else {
			maze[x][y] = ALREADY_PIXEL;
			return 1 + countCells(maze, x-1, y-1) + countCells(maze, x, y-1) + countCells(maze, x+1, y-1) 
			+ countCells(maze, x-1, y) + countCells(maze, x+1, y) + countCells(maze, x-1, y+1) + countCells(maze, x, y+1) + countCells(maze, x+1, y+1);
		}
	}
}
