package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2533 {
	
	public static final int INF = 987654321;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[][] dp = new int[n+1][2];
			List<List<Integer>> adjacent = new ArrayList<>();
			List<List<Integer>> adjacent2 = new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				adjacent.add(new ArrayList<>());
				adjacent2.add(new ArrayList<>());
			}
			
			for(int i=0;i<n-1;i++) {
				String[] temp = inbr.readLine().split(" ");
				int x = Integer.valueOf(temp[0]);
				int y = Integer.valueOf(temp[1]);
				adjacent.get(x-1).add(y);
				adjacent.get(y-1).add(x);
			}
			
			for(int i=1;i<dp.length;i++) {
				for(int j=0;j<dp[0].length;j++) {
					dp[i][j] = -1;
				}
			}
			
			/*
			for(int i=0;i<adjacent.size();i++) {
				for(int next : adjacent.get(i)) {
					System.out.println((i+1)+" "+next);
				}				
			}
			*/
			
			 makeTree(1, 0, adjacent, adjacent2);
			
			int ret = Math.min(solve(1, 1, dp, adjacent2), solve(1, 0, dp, adjacent2));
			System.out.println(ret);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void makeTree(int root, int parent, List<List<Integer>> adjacent, List<List<Integer>> adjacent2) {
		
		if(parent != 0) adjacent2.get(parent-1).add(root);
		
		for(int next : adjacent.get(root-1)) {
			if(next == parent) continue;
			makeTree(next, root, adjacent, adjacent2);
		}
	}
	
	public static int solve(int root, int isEA, int[][] dp, List<List<Integer>> adjacent) {
		
		if(adjacent.get(root-1).size() == 0) {
			if(isEA == 1) return 1;
			else return 0;
		}
		
		int ret = dp[root][isEA];
		
		if(ret != -1) return ret;
		
		if(isEA == 1) {
			ret = 1;
			for(int next : adjacent.get(root-1)) {
				ret += Math.min(solve(next, 0, dp, adjacent), solve(next, 1, dp, adjacent));
			}
		}
		else {
			ret = 0;
			for(int next : adjacent.get(root-1)) {
				ret += solve(next, 1, dp, adjacent);
			}
		}
		
		dp[root][isEA] = ret;
		//System.out.println(root+", "+isEA+" "+ret);
		return ret;
	}

}
