package kruskaMST;

public class Edge {
	
	private int weight;
	private long start;
	private long end;
	private boolean checked;
	
	public Edge() {
		
	}
	
	public Edge(long start, long end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
		this.checked = false;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "Edge [start=" + start + ", end=" + end + " weight=" + weight + "]";
	}
	
	
}
