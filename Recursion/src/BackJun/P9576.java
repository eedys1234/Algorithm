package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class P9576 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int t = Integer.valueOf(inbr.readLine());
			
			while(t-- > 0) {
				String[] temp = inbr.readLine().split(" ");
				int n = Integer.valueOf(temp[0]);
				int m = Integer.valueOf(temp[1]);
				int result = 0;
				
				List<Pair> pairs = new ArrayList<>(m);
				boolean[] visited = new boolean[n+1];
				int[] assign = new int[n+1];
							
				pairs.add(new Pair(0, 0));
				
				for(int i=0;i<m;i++) {
					temp = inbr.readLine().split(" ");
					pairs.add(new Pair(Integer.valueOf(temp[0]), Integer.valueOf(temp[1])));
				}
				
				for(int i=1;i<pairs.size();i++) {
					
					for(int j=1;j<visited.length;j++) {
						visited[j] = false;
					}
					
					if(dfs(pairs, i, visited, assign)) {
						result++;
					}
				}
				
				System.out.println(result);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean dfs(List<Pair> pairs, int x, boolean[] visited, int[] assign) {
		
		Pair pair = pairs.get(x);
		
		for(int i=pair.start;i<=pair.end;i++) {
		
			if(visited[i]) {
				continue;
			}
			
			visited[i] = true;
			
			if(assign[i] == 0 || dfs(pairs, assign[i], visited, assign)) {
				assign[i] = x;
				return true;
			}
			
		}		
		
		return false;
	}
	
	public static class Pair implements Comparable<Pair> {
		
		int start;
		int end;
		
		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Pair o) {
			
			if(Integer.compare(this.start, o.start) == 0) {
				return Integer.compare(this.end, o.end);
			}			
			return Integer.compare(this.start, o.start);
		}
	}

}
