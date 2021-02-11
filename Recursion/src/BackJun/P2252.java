package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class P2252 {

	public static Stack<Integer> stack = new Stack<>();
	public static boolean[] visited;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			String[] temp = inbr.readLine().split(" ");

			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			ArrayList<Integer>[] ads = new ArrayList[n+1];
			visited = new boolean[n+1];
			
			for(int i=0;i<n;i++) {
				ads[i+1] = new ArrayList<Integer>();
			}
			
			for(int i=0;i<m;i++) {
				temp = inbr.readLine().split(" ");
				ads[Integer.valueOf(temp[0])].add(Integer.valueOf(temp[1]));
			}
			
			
			dfsAll(n, ads);
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
				sb.append(" ");
			}
			
			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void dfsAll(int n, ArrayList<Integer>[] ads) {
		
		for(int i=1;i<=n;i++) {
			if(!visited[i]) {
				dfs(i, ads);				
			}
		}
	}
	
	public static void dfs(int x, ArrayList<Integer>[] ads) {
		
		visited[x] = true;
		
		for(int i=0;i<ads[x].size();i++) {
			
			if(!visited[ads[x].get(i)]) {
				dfs(ads[x].get(i), ads);
			}			
		}
		
		stack.push(x);
	}
	
}
