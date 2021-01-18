package primMST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import primMST.Edge;

public class MST {
	
	public static int VERTEX_CNT = 9;
	
	public static void main(String[] args) {
		
		List<Vertex> vertexs = initVertex();
		List<Edge> edges = initEdge(vertexs);
		
		primMST(vertexs, edges);
	}
	
	public static Edge getEdge(List<Edge> edges, Vertex v, Vertex u) {
		Edge e = null;
		int j = -1;
		for(int i=0;i<edges.size();i++) {
			e = edges.get(i);
			if(e.getStart() == v && e.getEnd() == u || e.getStart() == u && e.getEnd() == v) {
				j=i;
				break;
			}
			
		} 
		
		return j>-1?edges.get(j):null;
	}
	
	public static Vertex minKeyVertex(List<Vertex> vertexs) {
		
		return vertexs.stream().filter(vertex->!vertex.isConnected()).min(Comparator.comparing(vertex->vertex.getKey())).get();
	}
	
	public static void primMST(List<Vertex> vertexs, List<Edge> edges) {

		int i=0;
		List<Vertex> mst = new ArrayList<>();
		vertexs.get(0).setKey(0);
		vertexs.get(0).setPi(vertexs.get(0));
		
		while(mst.size() < VERTEX_CNT) {
			Vertex v = minKeyVertex(vertexs);
			v.setConnected(true);
			System.out.println(v.toString());
			mst.add(v);
			
			for(Vertex u : v.getAdjacent()) {
				Edge e = getEdge(edges, v, u);
				if(u.getKey() >= e.getWeight()) {
					u.setPi(v);
					u.setKey(e.getWeight());
				}
			}
		}
		
	}
	
	public static List<Edge> initEdge(List<Vertex> vertexs) {
		
		List<Edge> edges = Arrays.asList(
		new Edge(vertexs.get(0), vertexs.get(1), 4),
		new Edge(vertexs.get(0), vertexs.get(7), 11),
		new Edge(vertexs.get(1), vertexs.get(2), 8),
		new Edge(vertexs.get(1), vertexs.get(7), 11),
		new Edge(vertexs.get(2), vertexs.get(3), 7),
		new Edge(vertexs.get(2), vertexs.get(5), 4),
		new Edge(vertexs.get(2), vertexs.get(8), 2),
		new Edge(vertexs.get(3), vertexs.get(4), 9),
		new Edge(vertexs.get(3), vertexs.get(5), 14),
		new Edge(vertexs.get(4), vertexs.get(5), 10),
		new Edge(vertexs.get(5), vertexs.get(6), 2),
		new Edge(vertexs.get(6), vertexs.get(7), 1),
		new Edge(vertexs.get(6), vertexs.get(8), 6),
		new Edge(vertexs.get(7), vertexs.get(8), 7));

		return edges;
	}
	
	public static List<Vertex> initVertex() {
		
		List<Vertex> vertexs = new ArrayList<>();
		
		for(int i=1;i<10;i++) {
			Vertex v = new Vertex(i);
			vertexs.add(v);
		}
		
		vertexs.get(0).getAdjacent().add(vertexs.get(1));
		vertexs.get(0).getAdjacent().add(vertexs.get(7));
	
		vertexs.get(1).getAdjacent().add(vertexs.get(2));
		vertexs.get(1).getAdjacent().add(vertexs.get(7));
		
		vertexs.get(2).getAdjacent().add(vertexs.get(3));
		vertexs.get(2).getAdjacent().add(vertexs.get(5));
		vertexs.get(2).getAdjacent().add(vertexs.get(8));
		
		vertexs.get(3).getAdjacent().add(vertexs.get(4));
		vertexs.get(3).getAdjacent().add(vertexs.get(5));
		
		vertexs.get(4).getAdjacent().add(vertexs.get(5));
		vertexs.get(5).getAdjacent().add(vertexs.get(6));
		
		vertexs.get(6).getAdjacent().add(vertexs.get(7));
		vertexs.get(6).getAdjacent().add(vertexs.get(8));
		
		vertexs.get(7).getAdjacent().add(vertexs.get(8));
		return vertexs;
	}
}
