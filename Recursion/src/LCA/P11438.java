package LCA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P11438 {

	public static int[] depth;
	public static int[][] dp;
	public static int maxLevel;
	public static List<List<Integer>> adj;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.valueOf(inbr.readLine());
		depth = new int[n+1];
		dp = new int[n+1][20];
		
		maxLevel = (int)Math.floor(log2(n));
		adj = new ArrayList<>();
		
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
		
		getTree(1, 0);
		
		int m = Integer.valueOf(inbr.readLine());
		
		for(int i=0;i<m;i++) 
		{
			String[] temp = inbr.readLine().split(" ");
			int a = Integer.valueOf(temp[0]);
			int b = Integer.valueOf(temp[1]);
			
			if(depth[a] != depth[b]) {
				
				//a를 상위로 고정시킴
				if(depth[a] > depth[b]) {
					
					int t = a;
					a = b;
					b = t;
				}
				
				//b를 a보다 높은 depth로 이동시킴
				for(int j=maxLevel;j>=0;j--)
				{
					if(depth[a] <= depth[dp[b][j]]) {
						b = dp[b][j];
					}
				}
			}
			
			int lca = a;

			if(a != b) {
				
				for(int j=maxLevel;j>=0;j--)
				{
					if(dp[a][j] != dp[b][j]) {
						a = dp[a][j];
						b = dp[b][j];
					}
					
					lca = dp[a][j];
				}
			}
			sb.append(lca).append("\n");
		}
		
		System.out.println(sb.toString());		
	}
	
	public static double log2(double x) {
		return Math.log(x)/Math.log(2);
	}
	
	public static void getTree(int here, int parent) {
				
		depth[here] = depth[parent] + 1;
		dp[here][0] = parent;
		
		for(int i=1;i<=maxLevel;i++) 
		{
			int tmp = dp[here][i-1];
			dp[here][i] = dp[tmp][i-1];
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
}
