package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
public class P1949 {

	public static int[] people;
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			people = new int[n+1];
			String[] temp = inbr.readLine().split(" ");
			List<List<Integer>> adj1 = new ArrayList<>();
			List<List<Integer>> adj2 = new ArrayList<>();
			int[][] dp = new int[n+1][2];
			
			for(int i=0;i<temp.length;i++) {
				people[i+1] = Integer.valueOf(temp[i]);
			}
			
			for(int i=0;i<n;i++) {
				adj1.add(new ArrayList<Integer>());
				adj2.add(new ArrayList<Integer>());
			}
			
			for(int i=0;i<n-1;i++) {
				temp = inbr.readLine().split(" ");
				int a = Integer.valueOf(temp[0]);
				int b = Integer.valueOf(temp[1]);
				adj1.get(a-1).add(b);
				adj1.get(b-1).add(a);
			}
			
			makeTree(adj1, adj2, 0, 1);
			
			int max = Math.max(go(dp, adj2, 1, 0), go(dp, adj2, 1, 1));
			
			System.out.println(max);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void makeTree(List<List<Integer>> adj1, List<List<Integer>> adj2, int parent, int node) {
		
		if(parent != 0) {
			adj2.get(parent-1).add(node);
		}
		
		for(int next : adj1.get(node-1)) {
			if(parent == next) continue;
			makeTree(adj1, adj2, node, next);
		}
	}
	
	public static int go(int[][] dp, List<List<Integer>> adj, int node, int ex) {

		if(adj.get(node-1).size() == 0) {
			if(ex == 1) {
				return people[node];
			}
			else {
				return 0;
			}
		}
		
		int ret = 0;
		
		ret = dp[node][ex];
		if(ret > 0) {
			return ret;
		}
	
		//우수마을 선정
		if(ex == 1) {
			ret = people[node];
			for(int next : adj.get(node-1)) {
				ret += go(dp, adj, next, 0);
			}			
		}
		else {
			ret = 0;
			for(int next : adj.get(node-1)) {
				ret += Math.max(go(dp, adj, next, 0), go(dp, adj, next, 1));
			}						
		}
		
		dp[node][ex] = ret;
		return ret;
	}
}
