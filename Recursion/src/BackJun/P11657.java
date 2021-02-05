package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P11657 {
	
	public static final int INF = 100000000;

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			boolean minusCycle = false;
			
			List<Edge> edges = new ArrayList<>();
			List<Vertex> vertexs = new ArrayList<>();

			for(int i=0;i<m;i++) 
			{
				temp = inbr.readLine().split(" ");
				int start = Integer.valueOf(temp[0]);
				int end = Integer.valueOf(temp[1]);
				long weight = Long.valueOf(temp[2]);
				
				edges.add(new Edge(start, end, weight));
			}
			
			for(int i=0;i<n;i++) {
				vertexs.add(new Vertex(i+1));
			}

			Vertex s = vertexs.get(0);
			s.cost = 0;
			
			for(int i=0;i<vertexs.size();i++) 
			{
				for(int j=0;j<edges.size();j++) {

					Edge edge = edges.get(j);
					Vertex v = vertexs.get(edge.start-1);
					Vertex u = vertexs.get(edge.end-1);
					
					if(v.cost != INF && v.cost + edge.weight < u.cost) {
						if(i==n-1) {
							minusCycle = true;
							break;
						}
						u.cost = v.cost + edge.weight;

					}						
				}
				if(minusCycle) {
					break;
				}
			}
			
			if(minusCycle) {
				System.out.println("-1");
				return;
			}
			/*
			for(int j=0;j<edges.size();j++) {
				Edge edge = edges.get(j);
				Vertex v = vertexs.get(edge.start-1);
				Vertex u = vertexs.get(edge.end-1);
				if(v.cost + edge.weight < u.cost) {
					System.out.println("-1");					
					return ;
				}						
			}
			*/
			
			for(int i=1;i<vertexs.size();i++) 
			{
				Vertex v = vertexs.get(i);
				if(v.cost == INF) {
					System.out.println("-1");					
				}
				else {
					System.out.println(v.cost);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Vertex {
		int id;
		long cost;
		
		public Vertex(int id) {
			this.id = id;
			this.cost = INF;
		}
	}
	
	public static class Edge {
		
		int start;
		int end;
		long weight;
		
		Edge(int start, int end, long weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
}
