package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2213 {

	public static int[] w;
	public static boolean[] visited;
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			w = new int[n+1];
			long[][] dp = new long[n+1][2];
			List<List<Integer>> adj1 = new ArrayList<>();
			List<List<Integer>> adj2 = new ArrayList<>();
			ArrayList<Integer> s = new ArrayList<Integer>();
			visited = new boolean[n+1];
			
			String[] temp = inbr.readLine().split(" ");
			
			for(int i=0;i<n;i++) {
				w[i+1] = Integer.valueOf(temp[i]);
			}
						
			for(int i=0;i<n;i++) {
				adj1.add(new ArrayList<>());
				adj2.add(new ArrayList<>());
			}
			
			for(int i=1;i<n;i++) {
				temp = inbr.readLine().split(" ");
				int a = Integer.valueOf(temp[0]);
				int b = Integer.valueOf(temp[1]);
				
				adj1.get(a-1).add(b);
				adj1.get(b-1).add(a);				
			}
			
			makeTree(adj1, adj2, 0, 1);
			
			long max = 0;
			long a = go(dp, adj2, 1, 0);
			long b = go(dp, adj2, 1, 1);
			
			if(a <= b) {
				max = b;
				visited[1] = true;
			}
			else {
				max = a;
			}
			
			track(adj2, s, 1, visited[1]);
			
			Collections.sort(s);
			
			for(int i=0;i<s.size();i++) {
				sb.append(s.get(i)).append(" ");
			}
			
			System.out.println(max);
			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void makeTree(List<List<Integer>> adj1, List<List<Integer>> adj2, int parent, int node) {
		
		if(parent != 0) adj2.get(parent-1).add(node);
		
		for(int next : adj1.get(node-1)) {
			if(parent == next) continue;
			makeTree(adj1, adj2, node, next);
		}
	}
	
	public static void track(List<List<Integer>> adj, ArrayList<Integer> list, int now, boolean isEx) {
		
		if(isEx) {
			list.add(now);
			for(int next : adj.get(now-1)) {
				track(adj, list, next, false);
			}
		}
		else {
			for(int next : adj.get(now-1)) {
				track(adj, list, next, visited[next]);
			}			
		}
	}
	
	public static long go(long[][] dp, List<List<Integer>> adj, int node, int isEx) {
		
		if(adj.get(node-1).size() == 0) {
			if(isEx == 1) {
				return w[node];
			}
			else return 0;
		}
		
		long ret = 0;
		ret = dp[node][isEx];
		
		if(ret > 0) return ret;
		
		if(isEx == 1) {
			ret = w[node];
			for(int next : adj.get(node-1)) {
				ret += go(dp, adj, next, 0);
			}
		}
		else {
			ret = 0;
			for(int next : adj.get(node-1)) {
				long a = go(dp, adj, next, 0);
				long b = go(dp, adj, next, 1);
				 
				if(a <= b) {
					ret += b;
					visited[next] = true;					
				}
				else {
					ret += a;
					visited[next] = false;					
				}
			}
		}
				
		dp[node][isEx] = ret;
		return ret;
	}
}
