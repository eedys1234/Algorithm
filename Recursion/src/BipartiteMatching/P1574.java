package BipartiteMatching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1574 {

	public static boolean[] v;
	public static int[] d;	
	public static List<List<Integer>> adj;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int r = Integer.valueOf(temp[0]);
			int c = Integer.valueOf(temp[1]);
			int n = Integer.valueOf(temp[2]);
			int[][] chess = new int[r+1][c+1];
			adj = new ArrayList<>();
			d = new int[c+1];
			v = new boolean[c+1];
			int cnt = 0;
			
			for(int i=0;i<n;i++) {
				temp = inbr.readLine().split(" ");
				int a = Integer.valueOf(temp[0]);
				int b = Integer.valueOf(temp[1]);
				
				//1:ºóÄ­Ã³¸®
				chess[a][b] = 1;
			}
						
			for(int i=1;i<=r;i++) 
			{
				adj.add(new ArrayList<Integer>());
				for(int j=1;j<=c;j++)					
				{
					if(chess[i][j] == 0) adj.get(i-1).add(j);
				}
			}
			
			for(int i=1;i<=r;i++) {
				
				if(dfs(i)) cnt++;
				for(int j=1;j<v.length;j++) {
					v[j] = false;
				}
			}
			
			System.out.println(cnt);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean dfs(int x) {
		
		for(int i=0;i<adj.get(x-1).size();i++) {
			
			int t = adj.get(x-1).get(i);
			
			if(v[t]) continue;
			
			v[t] = true;
			
			if(d[t] == 0 || dfs(d[t])) {
				d[t] = x;
				return true;
			}
		}
		return false;
	}
}
