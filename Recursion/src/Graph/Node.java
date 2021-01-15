package Graph;

import java.util.ArrayList;

//Graph Node
public class Node {
	
	private boolean visit;
	private long id;
	private int length;
	private ArrayList<Node> adjacent;

	Node(long id) {
		this.visit = false;
		this.id = id;
		this.adjacent = new ArrayList<>();
	}

	public boolean isVisit() {
		return visit;
	}

	public void setVisit(boolean visit) {
		this.visit = visit;
	}

	public long getId() {
		return id;
	}

	public ArrayList<Node> getAdjacent() {
		return adjacent;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
		
}
