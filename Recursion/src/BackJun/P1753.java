package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P1753 {
	
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();			
			String[] temp = line.split(" ");
			
			int t = Integer.valueOf(temp[0]);
			int e = Integer.valueOf(temp[1]);
			
			line = inbr.readLine();			
			int source = Integer.valueOf(line);
			
			List<Edge> edges = new ArrayList<>();
			
			for(int i=0;i<e;i++) 
			{
				line = inbr.readLine();			
				temp = line.split(" ");
				
				int u = Integer.valueOf(temp[0]);
				int v = Integer.valueOf(temp[1]);
				int w = Integer.valueOf(temp[2]);
				
				edges.add(new Edge(u, v, w));
			}
			
			List<Vertex> vertexs = dijStra(edges, source, t);
			printVertex(vertexs);
						
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printVertex(List<Vertex> vertexs) {
		for(int i=0;i<vertexs.size();i++)
		{
			Vertex v = vertexs.get(i);
			if(v.getDistance()==Integer.MAX_VALUE) {
				System.out.println("INF");								
			}
			else {
				System.out.println(vertexs.get(i).getDistance());				
			}
		}
	}
	
	public static List<Vertex> dijStra(List<Edge> edges, int source, int t) {
		
		List<Vertex> vertexs = new ArrayList<>();
		PriorityQueue<Vertex> heap = new PriorityQueue<>();
		
		//시작점 세팅
		for(int i=1;i<=t;i++) {	
			Vertex v = null;
			if(i==source) {
				v = new P1753.Vertex(i, 0);
			}
			else {
				v = new P1753.Vertex(i, Integer.MAX_VALUE);				
			}
			vertexs.add(v);			
			heap.add(v);
		}
		
		for(int i=0;i<edges.size();i++) {
			Edge e = edges.get(i);
			vertexs.get(e.getStart()-1).getAdjacent().add(e);
		}
		
		while(!heap.isEmpty()) {
			Vertex v = heap.poll();		
			for(Edge edge : v.getAdjacent()) {				
				int weight = edge.getWeight();
				Vertex u = vertexs.get(edge.getEnd()-1);
				if(v.getDistance() != Integer.MAX_VALUE && u.getDistance() >= weight && u.getDistance() > v.getDistance() + weight) {
					Vertex temp = new Vertex(u.id, v.getDistance() + weight);
					temp.setAdjacent(u.getAdjacent());
					heap.remove(u);
					heap.add(temp);
					vertexs.set(edge.getEnd()-1, temp);
				}
			}
		}
				
		return vertexs;
	}		
	
	static class Vertex implements Comparable<Vertex>
	{
		int id;
		int distance;
		boolean visited;
		ArrayList<Edge> adjacent;
		
		Vertex(int id, int distance) {
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

		public ArrayList<Edge> getAdjacent() {
			return adjacent;
		}
		
		public void setAdjacent(ArrayList<Edge> adjacent) {
			this.adjacent = adjacent;
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

