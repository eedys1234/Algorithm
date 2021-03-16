package FindSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1976 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			int m = Integer.valueOf(inbr.readLine());
			List<Node> nodes = new ArrayList<>();
			String[] temp;

			int[][] w = new int[n+1][n+1];
			
			for(int i=1;i<=n;i++) {
				nodes.add(new Node(i));				
			}
			
			for(int i=1;i<=n;i++) 
			{
				temp = inbr.readLine().split(" ");
				for(int j=0;j<temp.length;j++)
				{
					w[i][j+1] = Integer.valueOf(temp[j]);
				}
			}
			
			temp = inbr.readLine().split(" ");
			int[] travle = new int[temp.length+1];
			
			for(int i=0;i<temp.length;i++) {
				travle[i+1] = Integer.valueOf(temp[i]);
			}
			
			for(int i=1;i<w.length;i++) 
			{
				for(int j=i;j<w[0].length;j++) 
				{
					if(w[i][j] == 1) {
						union(nodes.get(i-1), nodes.get(j-1));
					}
				}
			}
			
			System.out.println(findTravle(nodes, travle));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String findTravle(List<Node> nodes, int[] travle) {
		
		for(int i=1;i<travle.length-1;i++) {
			if(!isSet(nodes.get(travle[i]-1), nodes.get(travle[i+1]-1))) {
				return "NO";				
			}
		}
		
		return "YES";
	}
	
	public static boolean isSet(Node x, Node y) {
		return findSet(x) == findSet(y);
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
