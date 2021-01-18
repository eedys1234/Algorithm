package Heap;

import java.util.ArrayList;

public class Heap {

	private ArrayList<Node> list;
	private int type;
	private int position;
	
	public Heap(int type) {
		this.list = new ArrayList<>();
		list.add(new Node(Integer.MIN_VALUE));
		this.type = type;
		this.position = 1;
	}
	
	public boolean insert(Node v) {
		
		list.add(v);
		//root
		int tsize = list.size() - 1;
		Node parent = list.get(tsize/2);
		Node u = list.get(tsize);
		
		u.setParent(parent);

		if(parent.getLeft() == null) {
			parent.setLeft(u);
		}
		else {
			parent.setRight(u);
		}

		while(tsize > 1 && parent.getKey() < u.getKey()) {
			int temp = u.getKey();
			u.setKey(parent.getKey());
			parent.setKey(temp);
		}
		
		return true;
	}
	
	public int delete() {
		return 0;		
	}
	
	public Node search(int key) {
		return list.get(position++);
	}
	
	public Node succesor() {
		return null;
	}	
	
	
}
