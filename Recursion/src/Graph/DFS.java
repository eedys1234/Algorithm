package Graph;

import java.util.ArrayList;

public class DFS {
	
	public static void main(String[] args) {
	
		ArrayList<Node> graph = init();
		
		searchDFS(graph,graph.get(0));
	}
	
	public static void searchDFS(ArrayList<Node> graph, Node s) {
		
		s.setVisit(true);
		for(Node v : s.getAdjacent()) {
			if(!v.isVisit()) {
				System.out.print(v.getId() + " ");
				searchDFS(graph, v);
			}
		}
	}
	
	public static ArrayList<Node> init() {

		ArrayList<Node> nodes = new ArrayList<>();
		
		//畴靛 积己 棺 包府
		for(int i = 1; i<10; i++) {
			nodes.add(new Node(i));
		}

		nodes.get(0).getAdjacent().add(nodes.get(1));
		nodes.get(0).getAdjacent().add(nodes.get(2));
		
		nodes.get(1).getAdjacent().add(nodes.get(3));
		nodes.get(1).getAdjacent().add(nodes.get(4));

		nodes.get(2).getAdjacent().add(nodes.get(4));
		nodes.get(2).getAdjacent().add(nodes.get(6));
		nodes.get(2).getAdjacent().add(nodes.get(7));
		
		nodes.get(3).getAdjacent().add(nodes.get(1));
		nodes.get(3).getAdjacent().add(nodes.get(4));

		nodes.get(4).getAdjacent().add(nodes.get(2));
		nodes.get(4).getAdjacent().add(nodes.get(5));

		nodes.get(5).getAdjacent().add(nodes.get(4));

		nodes.get(6).getAdjacent().add(nodes.get(2));
		nodes.get(6).getAdjacent().add(nodes.get(7));

		nodes.get(7).getAdjacent().add(nodes.get(2));
		nodes.get(7).getAdjacent().add(nodes.get(6));

		return nodes;
	}

}
