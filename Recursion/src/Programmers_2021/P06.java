package Programmers_2021;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P06 {

	public static boolean[] visited;
	public static int[] space;
	public static List<String> comb;
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) {
		
		int[][] board = {
//			{1, 0, 0, 3},
//			{2, 0, 0, 0},
//			{0, 0, 0, 2},
//			{3, 0, 1, 0}
			{3, 0, 0, 2},
			{0, 0, 1, 0},
			{0, 1, 0, 0},
			{2, 0, 0, 3}
		};
		
		int r = 0;
		int c = 1;
		
		System.out.println(solution(board, r, c));
	}
	
    public static int solution(int[][] board, int r, int c) {

    	int answer = Integer.MAX_VALUE;
    	List<List<Location>> cards_number = new ArrayList<>();
    	comb = new ArrayList<>();
    	int number = 0;
    	int max = 0;
    	
    	for(int i=0;i<6;i++) 
    	{
    		cards_number.add(new ArrayList<>());
    	}
    	
    	for(int i=0;i<board.length;i++) 
    	{
    		for(int j=0;j<board[0].length;j++) 
    		{
				number = board[i][j];
				
    			if(number > 0) {
    				cards_number.get(number-1).add(new Location(j, i, 0));
    				max = Math.max(max, number);
    			}
    		}
    	}
    	
    	visited = new boolean[max+1];
    	space = new int[max+1];
    	int[] cards = new int[max+1];

    	for(int i=1;i<cards.length;i++) {
    		cards[i] = i;
    	}
    	
    	combination(cards, max, 1);
    	
    	for(int i=0;i<comb.size();i++) 
    	{
    		System.out.println(comb.get(i));
    		String[] path = comb.get(i).split(",");
    		answer = Math.min(answer, brute(board, cards_number, path, 0, r, c));
    	}    	

        return answer;
    }
    
    public static int brute(int[][] board, List<List<Location>> cards_number, String[] path, int k, int r, int c) {
    	
    	if(k == path.length) {
    		return 0;
    	}
    	
    	int ans = Integer.MAX_VALUE;    			
		int num = Integer.valueOf(path[k]);
		Location first = cards_number.get(num-1).get(0);
		Location second = cards_number.get(num-1).get(1);
		
		int cal1 = dijkstra(board, r, c, first.y, first.x) 
				+ dijkstra(board, first.y, first.x, second.y, second.x) 
				+ 2;
		
		int cal2 = dijkstra(board, r, c, second.y, second.x) 
				+ dijkstra(board, second.y, second.x, first.y, first.x) 
				+ 2;
		
		board[first.y][first.x] = 0;
		board[second.y][second.x] = 0;
			
		ans = Math.min(ans, Math.min(cal1 + brute(board, cards_number, path, k+1, second.y, second.x), 
				cal2 + brute(board, cards_number, path, k+1, first.y, first.x)));
		
		board[first.y][first.x] = num;
		board[second.y][second.x] = num;
		
    	return ans;
    }
    
    public static int dijkstra(int[][] board, int y, int x, int endY, int endX) {
    	
    	PriorityQueue<Location> pq = new PriorityQueue<>();
    	int[][] dist = new int[4][4];
    	int distance = 0;
    	
    	for(int i=0;i<dist.length;i++)
    	{
    		for(int j=0;j<dist[0].length;j++)
    		{
    			dist[i][j] = Integer.MAX_VALUE;
    		}
    	}
    	
    	dist[y][x] = 0;
    	pq.offer(new Location(x, y, 0));
    	
    	while(!pq.isEmpty()) {
    	
    		distance = pq.peek().distance;
    		int nx = pq.peek().x;
    		int ny = pq.peek().y;
    		pq.poll();
    		
    		if(nx == endX && ny == endY) {

    			return distance;
    		}
    		
    		for(int i=0;i<4;i++) 
    		{
    			int cnt = 0;
    			int cx = nx;
    			int cy = ny;
    			
    			while(range(cy+dy[i], cx+dx[i])) {
    				
    				cnt++;
    				cx += dx[i];
    				cy += dy[i];
    				
    				if(board[cy][cx] != 0) break;
    				
    				if(dist[cy][cx] > distance + cnt) {
    					dist[cy][cx] = distance + cnt;
    					pq.offer(new Location(cx, cy, dist[cy][cx]));
    				}
    			}
    			
    			if(dist[cy][cx] > distance+1) {
    				dist[cy][cx] = distance+1;
					pq.offer(new Location(cx, cy, dist[cy][cx]));
    			}
    		}
    	}
    	
    	
    	return 0;
    }
    
    public static boolean range(int y, int x) {
    	if(x < 0 || y < 0 || x >= 4 || y >= 4) {
    		return false;
    	}
    	
    	return true;
    }
    
    public static void combination(int[] cards, int r, int depth) {
    	
    	if(r == 0) {
    		StringBuilder sb = new StringBuilder();
    		
    		for(int i=1;i<space.length;i++) 
    		{
				sb.append(space[i]).append(",");
    		}
    		
    		comb.add(sb.toString().substring(0, sb.toString().length()-1));
    		return ;
    	}
    	
    	for(int i=1;i<cards.length;i++) {
    		
    		if(!visited[i]) {
    			visited[i] = true;
    			space[depth] = cards[i];
    			combination(cards, r-1, depth+1);
    			visited[i] = false;
    		}    		
    	}
    	
    }
    
    public static class Location implements Comparable<Location> {
    	
    	public int x;
    	public int y;
    	public int distance;
    	
    	public Location(int x, int y, int distance) {
    		this.x = x;
    		this.y = y;
    		this.distance = distance;
    	}

		@Override
		public int compareTo(Location o) {
			return Integer.compare(this.distance, o.distance);
		}
    }

}
