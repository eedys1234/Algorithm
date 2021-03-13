package BipartiteMatching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P11376 {

	public static List<List<Integer>> adj;
	public static boolean[] v;
	public static int[] d;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			adj = new ArrayList<List<Integer>>();
			v = new boolean[m+1];
			d = new int[m+1];
			int cnt = 0;
			
			for(int i=0;i<n;i++) {
				adj.add(new ArrayList<Integer>());
				temp = inbr.readLine().split(" ");
				int k = Integer.valueOf(temp[0]);
				
				for(int j=1;j<=k;j++) {
					adj.get(i).add(Integer.valueOf(temp[j]));
				}
			}
			
			for(int k=0;k<2;k++) 
			{
				for(int i=1;i<=n;i++) 
				{
					if(dfs(i)) cnt++;				
					for(int j=1;j<v.length;j++) {
						v[j] = false;
					}
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
//				System.out.println(x + " " + t + " " + d[t]);
				return true;
			}
		}
		
		return false;
		
	}
}
