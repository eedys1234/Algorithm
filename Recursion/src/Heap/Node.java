package Heap;

public class Node {

	private int key;
	private Node parent;
	private Node left;
	private Node right;
	
	public Node() {
		
	}
	
	public Node(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
		
	
}
