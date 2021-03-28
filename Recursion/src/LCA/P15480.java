package LCA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P15480 {
	
	public static List<List<Integer>> adj;
	public static int[] depth;
	public static int[][] dp;
	public static int maxLevel;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.valueOf(inbr.readLine());
		adj = new ArrayList<>();
		depth = new int[n+1];
		dp = new int[n+1][20];
		
		maxLevel = (int)Math.floor(log2(n));		
		
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<>());	
		}
		
		for(int i=0;i<n-1;i++) 
		{
			String[] temp = inbr.readLine().split(" ");
			int parent = Integer.valueOf(temp[0]);
			int child = Integer.valueOf(temp[1]);
			
			adj.get(parent-1).add(child);
			adj.get(child-1).add(parent);
		}
		
		depth[0] = -1;
				
		int m = Integer.valueOf(inbr.readLine());
		
		for(int i=0;i<m;i++)
		{
			String[] temp = inbr.readLine().split(" ");
			
			int a = Integer.valueOf(temp[0]);
			int b = Integer.valueOf(temp[1]);
			int c = Integer.valueOf(temp[2]);
			
			getTree(a, 0);
			int lca = lca(b, c);
			
			sb.append(lca).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int lca(int a, int b) {
		
		int lca = a;
		
		if(depth[a] != depth[b]) 
		{
			if(depth[a] > depth[b]) {
				
				int t = a;
				a = b;
				b = t;
			}
			
			for(int i=maxLevel;i>=0;i--)
			{
				if(depth[a]< depth[dp[b][i]]) {
					b = dp[b][i];
				}
			}						
		}
		
		if(a != b) {
		
			for(int i=maxLevel;i>=0;i--)
			{
				if(dp[a][i] != dp[b][i]) {
					a = dp[a][i];
					b = dp[b][i];
				}
				
				lca = dp[a][i];
			}
		}				
		
		return lca;
	}

	public static void getTree(int here, int parent) {
		
		depth[here] = depth[parent] + 1;
		dp[here][0] = parent;
		
		for(int i=1;i<=maxLevel;i++)
		{
			int temp = dp[here][i-1];
			dp[here][i] = dp[temp][i-1];
		}
		
		int len = adj.get(here-1).size();

		for(int i=0;i<len;i++) 
		{
			int next = adj.get(here-1).get(i);
			if(parent != next) {
				getTree(next, here);
			}
		}
	}
	
	public static double log2(double x) {
		return Math.log(x) / Math.log(2);
	}
}
