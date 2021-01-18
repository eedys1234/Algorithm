package kruskaMST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MST {
	
	public static void main(String[] args) {

		List<Edge> sortedEdges = sortEdge(initEdge());
		List<Vertex> vertexs = initVertex();
		
		kruskaMST(vertexs, sortedEdges);
		
	}
	
	public static void kruskaMST(List<Vertex> vertexs, List<Edge> edges) {
		int cnt = 0;
		for(int i=0;i<edges.size();i++) {
			Edge e = edges.get(i);
			Vertex v = getVertex(vertexs, e.getStart());
			Vertex u = getVertex(vertexs, e.getEnd());
			if(findset(v) != findset(u)) {
				cnt++;
				weight_union(v, u);
				e.setChecked(true);
				System.out.println(e.toString());
			}
			
			if(cnt == vertexs.size() - 1) {
				break;
			}
		}
	}
	
	public static Vertex getVertex(List<Vertex> vertexs, long id) {
		return vertexs.get((int)id-1);
	}
	
	public static Vertex findset(Vertex v) {

		Vertex x = v;
		while(x.getParent()!=x) {
			x.setParent(x.getParent().getParent());
			x = x.getParent();
		}
		
		return x;
	}
	
	public static void weight_union(Vertex v, Vertex u) {
		
		Vertex p = findset(v);
		Vertex q = findset(u);
		
		if(p.getSize() >= q.getSize()) {
			q.setParent(p);
			p.setSize(p.getSize()+q.getSize());
		}
		else {
			p.setParent(q);
			q.setSize(p.getSize()+q.getSize());
		}
	}
	
	public static List<Edge> sortEdge(List<Edge> edges) {
		return edges.stream().sorted(Comparator.comparing(edge->edge.getWeight())).collect(Collectors.toList());
	}
	
	public static List<Vertex> initVertex() {		
		List<Vertex> vertexs = new ArrayList<>();
		
		for(int i=1; i<10; i++) {
			Vertex v = new Vertex(i);
			v.setParent(v);
			vertexs.add(v);
		}
		
		return vertexs;
	}
	 
	public static List<Edge> initEdge() {
		
		List<Edge> edges = Arrays.asList(
		new Edge(1, 2, 4),
		new Edge(1, 8, 11),
		new Edge(2, 3, 8),
		new Edge(2, 8, 11),
		new Edge(3, 4, 7),
		new Edge(3, 6, 4),
		new Edge(3, 9, 2),
		new Edge(4, 5, 9),
		new Edge(4, 6, 14),
		new Edge(5, 6, 10),
		new Edge(6, 7, 2),
		new Edge(7, 8, 1),
		new Edge(7, 9, 6),
		new Edge(8, 9, 7));

		return edges;
	}
}
