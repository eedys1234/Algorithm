package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class Topological {
	
	public static Stack<Node> stack = new Stack<>();
	
	public static void main(String[] args) {
		
		ArrayList<Node> graph = init();
		
		DFSAll(graph);
		
		for(Node v : stack) {
			System.out.print(v.getId() + " ");			
		}
		
	}
	
	public static void DFSAll(ArrayList<Node> graph) {
		
		for(int i=0;i<graph.size();i++) {
			DFS(graph, graph.get(i));
		}
	}
	
	public static void DFS(ArrayList<Node> graph, Node s) {
		
		s.setVisit(true);
		
		for(Node v : s.getAdjacent()) {
			if(!v.isVisit()) {
				DFS(graph, v);
			}
		}
		
		if(!stack.contains(s))
			stack.push(s);
		
	}
	
	public static ArrayList<Node> init() {
		
		ArrayList<Node> graph = new ArrayList<>();
		
		for(int i=1; i<7; i++) {
			graph.add(new Node(i));
		}
		
		graph.get(0).getAdjacent().add(graph.get(1));

		graph.get(1).getAdjacent().add(graph.get(2));
		graph.get(1).getAdjacent().add(graph.get(3));
		graph.get(1).getAdjacent().add(graph.get(4));

		graph.get(2).getAdjacent().add(graph.get(4));
		graph.get(3).getAdjacent().add(graph.get(4));

		graph.get(5).getAdjacent().add(graph.get(2));
		graph.get(5).getAdjacent().add(graph.get(3));

		
		return graph;
	}
}
