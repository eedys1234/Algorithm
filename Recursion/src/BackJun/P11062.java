package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11062 {

	public static Node theRoot;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int t = Integer.valueOf(inbr.readLine());
			
			while(t-- > 0) {
				
				int n = Integer.valueOf(inbr.readLine());
				int[] cards = new int[n];
				String[] temp = inbr.readLine().split(" ");
				
				for(int i=0;i<temp.length;i++) {
					cards[i] = Integer.valueOf(temp[i]);
				}				
				
				makeTree(theRoot, cards, 0, cards.length-1);
				//dfs(theRoot);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int dfs(Node root, int depth) {
		
		int value = 0;
		if(root != null) {
			if(depth%2 == 1) {
				value += root.value;
			}
			
			dfs(root.left, depth+1);
			dfs(root.right, depth+1);
		}
		
		return value;		
	}
	
	public static void makeTree(Node root, int[] cards, int left, int right) {
				
		if(left < right) {
			
			if(root.left == null) {
				root.left = new Node(cards[left]);
				makeTree(root.left, cards, left+1, right);
			}
			
			if(root.right == null) {
				root.right = new Node(cards[right]);				
				makeTree(root.right, cards, left, right+1);
			}			
		}
		
	}
	
	public static class Node {
		
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
				
	}
}
