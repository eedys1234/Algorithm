package Programmers;

public class P06 {

	public static void main(String[] args) {
		
	}
	
    public static int solution(int[][] board, int r, int c) {

    	int answer = 0;
        int currentCard = 0;
        Location location = null;
        
        for(int i=0;i<board.length;i++)
        {
        	for(int j=0;j<board[0].length;j++)
        	{
        		if(board[i][j] != 0) 
        		{
        			currentCard++;
        		}
        	}
        }
        
        
        while(currentCard > 0) {
        	
        	if(board[r][c] != 0) {
        		answer++;        		
        		location = findCard(board, board[r][c]);
        		
        		while(r != location.x) {

        			if(r - location.x > 0) {
        				r--;
        			}
        			else if(r - location.x < 0){
        				r++;
        			}
        			
        			if(board[r][c] == 0) {
        				
        			}
        		}
        	}
        	
        	
        	
        }
        
        return answer;
    }
    
    public static Location findCard(int[][] board, int x) {
    	
    	for(int i=0;i<board.length;i++)
    	{
    		for(int j=0;j<board[0].length;j++)
    		{
    			if(board[i][j] == x) {
    				return new Location(i, j);
    			}
    		}
    	}
    	
    	return null;
    }
    
    public static class Location {
    	
    	public int x;
    	public int y;
    	
    	public Location(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
}
