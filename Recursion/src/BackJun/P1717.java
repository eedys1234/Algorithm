package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1717 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			String[] temp = inbr.readLine().split(" ");
			List<Node> nodes = new ArrayList<>();
			
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			
			for(int i=0;i<=n;i++) {
				nodes.add(new Node(i));
			}
			
			for(int i=0;i<m;i++) {
				temp = inbr.readLine().split(" ");
				int op = Integer.valueOf(temp[0]);
				
				int a = Integer.valueOf(temp[1]);
				int b = Integer.valueOf(temp[2]);
				
				//union
				if(op == 0) {
					union(nodes.get(a), nodes.get(b));
				}
				//find
				else {
					if(isSet(nodes.get(a), nodes.get(b))) {
						sb.append("YES");
					}
					else {
						sb.append("NO");						
					}
					sb.append("\n");
				}
			}
			
			System.out.println(sb.toString());

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Node findSet(Node x) {
		
		while(x!=x.parent) {
			x.parent = x.parent.parent;
			x = x.parent;
		}
		
		return x;
	}
	
	public static boolean isSet(Node x, Node y) {
		return findSet(x) == findSet(y);
	}
	
	public static void union(Node x, Node y) {

		Node rootX = findSet(x);
		Node rootY = findSet(y);
		
		if(rootX.size > rootY.size) {
			rootY.parent = rootX;
			rootX.size += rootY.size;
		}
		else {
			rootX.parent = rootY;
			rootY.size += rootX.size;
		}
		
	}
	
	public static class Node {
		
		int id;
		Node parent;
		int size;
		
		public Node(int id) {			
			this.id = id;
			this.size = 1;			
			this.parent = this;
		}
		
	}
}
