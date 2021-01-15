package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		
		ArrayList<Node> nodes = init();
		searhBFS(nodes, nodes.get(0));
	}
	
	public static void searhBFS(ArrayList<Node> nodes, Node s) {
		
		Queue<Node> q = new LinkedList<>();
		
		Node previous = null;
		
		//시작
		q.offer(s);
		s.setLength(0);
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(Node v : node.getAdjacent()) {
				if(!v.isVisit()) {
					v.setVisit(true);
					System.out.print(v.getId() + " ");
					q.offer(v);
					v.setLength(node.getLength() + 1);
					previous = node;
				}
			}			
		}
		
	}
	
	public static ArrayList<Node> init() {

		ArrayList<Node> nodes = new ArrayList<>();
		
		//노드 생성 및 관리
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
