package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class P10217 {

	public static final int INF = 1000000000;

	public static void main(String[] args) {
				
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int t = Integer.valueOf(inbr.readLine());
			
			while(t-->0) {

				
				String[] temp = inbr.readLine().split(" ");
				
				int n = Integer.valueOf(temp[0]);
				int m = Integer.valueOf(temp[1]);
				int k = Integer.valueOf(temp[2]);
				int[][] dp = new int[n+1][m+1];
				ArrayList<Edge>[] edges = new ArrayList[n+1];
				
				for(int i=1;i<=n;i++) {
					edges[i] = new ArrayList<Edge>();
					for(int j=1;j<=m;j++) 
					{
						dp[i][j] = INF;
					}
				}				
				
				for(int i=0;i<k;i++) {
					temp = inbr.readLine().split(" ");
					int start = Integer.valueOf(temp[0]);
					int end = Integer.valueOf(temp[1]);
					int distance = Integer.valueOf(temp[2]);
					int time = Integer.valueOf(temp[3]);
					
					edges[start].add(new Edge(end, distance, time));					
				}
								
				dijakstar(dp, edges, n, m);
				
				printVertex(dp, n);				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printVertex(int[][] dp, int n) {

		int min = INF;
		for(int i=1;i<dp[0].length;i++) {
			min = Math.min(min, dp[n][i]);
		}
		
		if(min == INF) {
			System.out.println("Poor KCM");
		}
		else {
			System.out.println(min);			
		}
	}
	
	public static void dijakstar(int[][] dp, List<Edge>[] edges, int n, int m) {
		
		PriorityQueue<Airport> heap = new PriorityQueue<>();
		
		heap.add(new Airport(1, 0, 0));
		dp[1][0] = 0;
		
		while(!heap.isEmpty()) {
		
			Airport v = heap.poll();
			
			int currVertex = v.start;
			int currCost = v.cost;
			int currTime = v.time;
			
			if(currVertex == n) {
				break;
			}
			
			for(Edge edge : edges[currVertex]) {
				
				int nextCost = currCost + edge.getDistance();
				int nextVertex = edge.getEnd();
				int nextTime = currTime + edge.getTime();

				if(m < nextCost) {
					continue;
				}
				
				if(dp[nextVertex][nextCost] <= nextTime) {
					continue;
				}
				
				for(int i=nextCost;i<=m;i++) {
					if(dp[nextVertex][i] > nextTime) {
						dp[nextVertex][i] = nextTime;						
					}
				}
				
				dp[nextVertex][nextCost] = nextTime;
				heap.offer(new Airport(nextVertex, nextCost, nextTime));

				
				
			}
		}
		
	}
	
	public static class Airport implements Comparable<Airport> {

		int start;
		int cost;
		int time;
		
		public Airport(int start, int cost, int time) {
			this.start = start;
			this.cost = cost;
			this.time = time;
		}
		
		public int getStart() {
			return start;
		}

		public int getCost() {
			return cost;
		}

		public int getTime() {
			return time;
		}

		@Override
		public int compareTo(Airport o) {
			return Integer.compare(this.getTime(), o.getTime());					
		}
	}
	
	
	public static class Edge {
		
		int end;
		int distance;
		int time;
		
		public Edge(int end, int distance, int time) {
			this.end = end;
			this.distance = distance;
			this.time = time;
		}

		public int getEnd() {
			return end;
		}

		public int getDistance() {
			return distance;
		}

		public int getTime() {
			return time;
		}
		
	}
}
