package MST;

import java.util.ArrayList;

public class Vertex {
	
	private Vertex parent;
	private long id;
	private int size;
	private ArrayList<Edge> adjacent;
	
	public Vertex(long id) {
		this.id = id;
		this.adjacent = new ArrayList<>();
		this.size = 1;
	}
	
	public Vertex getParent() {
		return parent;
	}
	
	public void setParent(Vertex parent) {
		this.parent = parent;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<Edge> getAdjacent() {
		return adjacent;
	}
	
	
}