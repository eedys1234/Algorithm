package Programmers_2021;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//다익스트라가 사용될줄 몰랐음
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
    	
    	//쌍으로 찾아야 하기 때문에 각 카드의 위치를 저장
    	//저장하지 않으면 매번 board를 탐색해야하는 오버헤드가 발생
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
    	
    	//어떤 순서로 카드를 짝 맞출기 결정
    	//모든 경우의 수 다 조사(조합)
    	combination(cards, max, 1);
    	
    	for(int i=0;i<comb.size();i++) 
    	{
    		String[] path = comb.get(i).split(",");
    		answer = Math.min(answer, brute(board, cards_number, path, 0, r, c));
    	}    	

        return answer;
    }
    
    //백트래킹
    public static int brute(int[][] board, List<List<Location>> cards_number, String[] path, int k, int r, int c) {
    	
    	if(k == path.length) {
    		return 0;
    	}
    	
    	int ans = Integer.MAX_VALUE;    			
		int num = Integer.valueOf(path[k]);
		Location first = cards_number.get(num-1).get(0);
		Location second = cards_number.get(num-1).get(1);
		
		//다익스트라 알고리즘을 사용하여 1이라고 적힌 첫번째 카드에서 1이라고 적힌 2번째 카드로 이동거리 구함
		//쌍으로 존재하기 때문에 첫번째 카드를 먼저 찾을지, 두번째 카드를 먼저 찾을지 둘다 구해야함
		int cal1 = dijkstra(board, r, c, first.y, first.x) 
				+ dijkstra(board, first.y, first.x, second.y, second.x) 
				+ 2;
		
		int cal2 = dijkstra(board, r, c, second.y, second.x) 
				+ dijkstra(board, second.y, second.x, first.y, first.x) 
				+ 2;
		
		//찾았던 카드는 제거
		board[first.y][first.x] = 0;
		board[second.y][second.x] = 0;
		
		//첫번째를 마지막으로 찾은경우와 두번째를 마지막으로 찾은경우를 출발점으로 다음 순서의 카드 짝을 구함
		ans = Math.min(ans, Math.min(cal1 + brute(board, cards_number, path, k+1, second.y, second.x), 
				cal2 + brute(board, cards_number, path, k+1, first.y, first.x)));
		
		//다른 순서도 구해야하기 때문에 원상복귀
		board[first.y][first.x] = num;
		board[second.y][second.x] = num;
		
    	return ans;
    }
    
    //ctrl + 연산에 의해 다익스트라 알고리즘 사용해야함
    public static int dijkstra(int[][] board, int y, int x, int endY, int endX) {
    	
    	PriorityQueue<Location> pq = new PriorityQueue<>();
    	int[][] dist = new int[4][4];
    	int distance = 0;
    	
    	//출발지에서 각 2차원 도착지의 거리 초기화
    	for(int i=0;i<dist.length;i++)
    	{
    		for(int j=0;j<dist[0].length;j++)
    		{
    			dist[i][j] = Integer.MAX_VALUE;
    		}
    	}
    	
    	//출발지 거리 초기화
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
    			
    			//해당 방향으로 계속 갈수 있다면 
    			while(range(cy+dy[i], cx+dx[i])) {
    				
    				//방향키로만 이동했을 경우
    				cnt++;
    				cx += dx[i];
    				cy += dy[i];
    				
    				//이동 경로에 카드가 있다면 빠져나옴
    				if(board[cy][cx] != 0) break;
    				
    				if(dist[cy][cx] > distance + cnt) {
    					dist[cy][cx] = distance + cnt;
    					pq.offer(new Location(cx, cy, dist[cy][cx]));
    				}
    			}
    			
    			//방향키로만 이동했던 경로보다 ctrl로 이동한 경로가 짧을 경우 추가
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
