package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P1504 {
	
	public static int[][] d;
		
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			String[] temp = line.split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int e = Integer.valueOf(temp[1]);
			List<Edge> edges = new ArrayList<>();
			d = new int[n][n];
			
			for(int i=0;i<e;i++) {
				line = inbr.readLine();
				temp = line.split(" ");
				
				edges.add(new Edge(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]), Integer.valueOf(temp[2])));
				edges.add(new Edge(Integer.valueOf(temp[1]), Integer.valueOf(temp[0]), Integer.valueOf(temp[2])));
			}
			
			line = inbr.readLine();
			temp = line.split(" ");
			
			int[] path = new int[3];
			path[0] = 1;
			path[1] = Integer.valueOf(temp[0]);
			path[2] = Integer.valueOf(temp[1]);
			
			List<Vertex> vertexs = new ArrayList<>();
			
			for(int i=1;i<=n;i++) {
				vertexs.add(new Vertex(i, Integer.MAX_VALUE));
			}
			
			for(int i=0;i<edges.size();i++) {
				Edge edge = edges.get(i);
				Vertex v = vertexs.get(edge.getStart()-1);
				v.getAdjacent().add(edge);
			}
			
			for(int i=0;i<d.length;i++) {
				for(int j=0;j<d[0].length;j++) {
					if(i==j) {
						d[i][j] = 0;						
					}
					else {
						d[i][j] = Integer.MAX_VALUE;						
					}
				}
			}
			
			int min = 0;

			int source = path[0];
			vertexs.get(source-1).setDistance(0);

			for(int i=0;i<path.length;i++) {
				source = path[i];
				initVertex(vertexs, path, i);

				dijstra(vertexs, edges, source);				
			}
			

			if( d[0][path[1]-1] != Integer.MAX_VALUE && 
				d[path[1]-1][path[2]-1] != Integer.MAX_VALUE && 
				d[path[2]-1][n-1] != Integer.MAX_VALUE	||
				d[0][path[2]-1] != Integer.MAX_VALUE && 
				d[path[2]-1][path[1]-1] != Integer.MAX_VALUE && 
				d[path[1]-1][n-1] != Integer.MAX_VALUE) {
				
				min = Math.min(d[0][path[1]-1]+d[path[1]-1][path[2]-1]+d[path[2]-1][n-1], d[0][path[2]-1]+d[path[2]-1][path[1]-1]+d[path[1]-1][n-1]);				
			}
			else {
				min = -1;
			}

			System.out.print(min);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void initVertex(List<Vertex> vertexs, int[] path, int j) {
		Vertex v = vertexs.get(path[j]-1);

		for(int i=0;i<vertexs.size();i++) {			
			vertexs.get(i).setDistance(Integer.MAX_VALUE);
		}

		v.setDistance(0);
	}
	
	public static int destDistance(List<Vertex> vertexs) {
		return vertexs.get(vertexs.size()-1).getDistance();		
	}
	
	public static void dijstra(List<Vertex> vertexs, List<Edge> edges, int source) {
		
		PriorityQueue<Vertex> heap = new PriorityQueue<Vertex>();
		
		heap.offer(vertexs.get(source-1));
		
		while(!heap.isEmpty()) {
			Vertex v = heap.poll();
			
			for(Edge edge : v.getAdjacent()) {

				Vertex u = vertexs.get(edge.getEnd()-1);
				int weight = edge.getWeight();
				
				if(v.getDistance() < Integer.MAX_VALUE && v.getDistance() >= 0 && u.getDistance() >= v.getDistance() + weight) {
					u.setDistance(v.getDistance() + weight);										
					d[source-1][u.getId()-1] = u.getDistance();
					heap.offer(u);
				}
			}
		}
	}
	
	static class Vertex implements Comparable<Vertex> {
		
		int id;
		int distance;
		boolean visited;
		List<Edge> adjacent;
		
		public Vertex(int id, int distance) {
			
			this.id = id;
			this.distance = distance;
			this.visited = false;
			this.adjacent = new ArrayList<>();
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public List<Edge> getAdjacent() {
			return adjacent;
		}

		public void setAdjacent(List<Edge> adjacent) {
			this.adjacent = adjacent;
		}

		public int getId() {
			return id;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.getDistance(), o.getDistance());
		}
		
	}
	
	static class Edge {
		
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		public int getWeight() {
			return weight;
		}
		
		
	}
}
