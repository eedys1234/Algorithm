package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P20040 {

	public static void main(String[] args) {
	
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			List<Node> nodes = new ArrayList<>();
			
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			int k = 0;
			
			for(int i=0;i<n;i++) {
				nodes.add(new Node(i));
			}
			
			for(int i=0;i<m;i++) {
				
				temp = inbr.readLine().split(" ");
				int a = Integer.valueOf(temp[0]);
				int b = Integer.valueOf(temp[1]);
				
				Node x = nodes.get(a);
				Node y = nodes.get(b);				
				
				if(findSet(x) == findSet(y)) {
					k = i+1;
					break;
				}
				else {
					union(x, y);					
				}
				
			}
			
			System.out.println(k);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void union(Node x, Node y) {
		
		Node rootX = findSet(x);
		Node rootY = findSet(y);
		
		if(rootX != rootY) {
			
			if(rootX.size > rootY.size) {
				rootY.parent = rootX;
				rootX.size += rootY.size;
			}
			else {
				rootX.parent = rootY;
				rootY.size += rootX.size;				
			}
		}
		
	}
	
	public static Node findSet(Node x) {
		
		while(x != x.parent) {
			x.parent = x.parent.parent;
			x = x.parent;
		}
		
		return x;
	}
	
	public static class Node {
		
		int id;
		int size;
		Node parent;
		
		public Node(int id) {
			this.id = id;
			this.size = 1;
			this.parent = this;
		}
	}
	
}
