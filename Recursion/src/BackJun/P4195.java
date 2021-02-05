package BackJun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class P4195 {

	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter outbr = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		try {
			int t = Integer.valueOf(inbr.readLine());
			
			while(t-->0) {
			
				Map<String, Node> store = new HashMap<>();
				int f = Integer.valueOf(inbr.readLine());
								
				for(int i=0;i<f;i++) {
					String[] temp = inbr.readLine().split(" ");
					for(int j=0;j<temp.length;j++)
					{
						if(!store.containsKey(temp[j])) {
							store.put(temp[j], new Node(temp[j]));
						}
					}
					union(store.get(temp[0]), store.get(temp[1]));			
					Node theRoot = findSet(store.get(temp[0]));
					sb.append(theRoot.size);
					sb.append("\n");
				}
			}
			

			outbr.write(sb.toString());
			outbr.flush();
			outbr.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Node findSet(Node x) {
		
		while(x != x.parent) {
			x.parent = x.parent.parent;
			x = x.parent;
		}
		
		return x;
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
	
	public static class Node {
		
		String name;
		int size;
		Node parent;
		
		public Node(String name) {
			
			this.name = name;
			this.size = 1;
			this.parent = this;
		}
	}
}
