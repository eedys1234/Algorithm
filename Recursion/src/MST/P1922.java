package MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class P1922 {

	public static List<Edge> edges;
	public static List<Vertex> vertexs;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int v = Integer.valueOf(inbr.readLine());
			int e = Integer.valueOf(inbr.readLine());
			edges = new ArrayList<>();
			vertexs = new ArrayList<>();

			for(int i=0;i<v;i++) {
				vertexs.add(new Vertex(i+1));
			}
			
			for(int i=0;i<e;i++) {
				String[] temp = inbr.readLine().split(" ");
				int a = Integer.valueOf(temp[0]);
				int b = Integer.valueOf(temp[1]);
				int c = Integer.valueOf(temp[2]);	
				
				edges.add(new Edge(a, b, c));
			}
			
			List<Edge> sortedEdges = edges.stream().sorted(Comparator.comparing(Edge::getWeight)).collect(Collectors.toList());
				
			System.out.println(mst(sortedEdges));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int mst(List<Edge> edges) {
		
		int sum = 0;
		
		for(int i=0;i<edges.size();i++) {
			Edge edge = edges.get(i);
			
			Vertex v = vertexs.get(edge.start-1);
			Vertex u = vertexs.get(edge.end-1);
			
			if(findSet(v) != findSet(u)) {
				union(v, u);
				sum += edge.weight;
			}
			
		}
		return sum;
	}
	
	public static void union(Vertex v, Vertex u) {
		
		Vertex rootV = findSet(v);
		Vertex rootU = findSet(u);
		
		if(rootV != rootU) {
			
			if(rootV.size > rootU.size) {
				rootU.parent = rootV;
				rootV.size += rootU.size;
			}
			else {
				rootV.parent = rootU;
				rootU.size += rootV.size;				
			}
		}
	}
	
	public static Vertex findSet(Vertex x) {
		
		while(x.parent != x) {			
			x.parent = x.parent.parent;
			x = x.parent;
		}

		return x;		
	}
	
	public static class Vertex {
		public int num;
		public int size;
		public Vertex parent;
		
		public Vertex(int num) {
			this.num = num;
			this.size = 1;
			this.parent = this;
		}
	}
	
	public static class Edge {

		public int start;
		public int end;
		public int weight;
		
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		public int getWeight() {
			return weight;
		}
		
		
	}
}
