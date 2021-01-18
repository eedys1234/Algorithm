package primMST;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private long id;
	private int key;
	private Vertex pi;
	private List<Vertex> adjacent;
	private boolean connected;
	
	public Vertex(long id) {
		this.id = id;
		this.connected = false;
		this.pi = null;
		this.key = Integer.MAX_VALUE;
		adjacent = new ArrayList<>();
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Vertex getPi() {
		return pi;
	}

	public void setPi(Vertex pi) {
		this.pi = pi;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public long getId() {
		return id;
	}

	public List<Vertex> getAdjacent() {
		return adjacent;
	}

	@Override
	public String toString() {
		return "Vertex [id=" + id + ", key=" + key + ", pi=" + pi.getId() + "]";
	}
	
	
}
