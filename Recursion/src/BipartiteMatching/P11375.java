package BipartiteMatching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//ÀÌºÐ¸ÅÄª
public class P11375 {

	public static boolean[] c;
	public static int[] d;
	public static List<List<Integer>> adj;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			adj = new ArrayList<>();
			d = new int[m+1];
			c = new boolean[m+1];
			int cnt = 0;
			
			for(int i=1;i<=n;i++) {
				adj.add(new ArrayList<Integer>());
			}
			
			for(int i=1;i<=n;i++) 
			{
				temp = inbr.readLine().split(" ");

				for(int j=1;j<temp.length;j++) 
				{
					adj.get(i-1).add(Integer.valueOf(temp[j]));					
				}				
			}	
			
			for(int i=1;i<=n;i++) 
			{
				if(dfs(i)) cnt++;
				for(int j=1;j<c.length;j++) {
					c[j] = false;
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
			
			if(c[t]) continue;
			
			c[t] = true;
			
			if(d[t] == 0 || dfs(d[t])) {
				d[t] = x;
				return true;
			}
		}
		return false;
	}
}
