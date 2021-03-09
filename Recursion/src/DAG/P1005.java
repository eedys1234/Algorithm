package DAG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1005 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int t = Integer.valueOf(inbr.readLine());
			
			while(t-- > 0) {
				Queue<Pair> queue = new LinkedList<>();
				
				String[] temp = inbr.readLine().split(" ");
				int n = Integer.valueOf(temp[0]);
				int k = Integer.valueOf(temp[1]);
				int[] expensive = new int[n+1];
				int[][] order = new int[n+1][n+1];
				int[] in = new int[n+1];
				int[] result = new int[n+1];
				
				temp = inbr.readLine().split(" ");
				
				for(int i=0;i<temp.length;i++) {
					expensive[i+1] = Integer.valueOf(temp[i]);
				}
				
				for(int i=0;i<k;i++) {
					temp = inbr.readLine().split(" ");
					int a = Integer.valueOf(temp[0]);
					int b = Integer.valueOf(temp[1]);
					
					order[a][b] = 1;
					in[b] += 1;
				}
				
				int w = Integer.valueOf(inbr.readLine());
				
				for(int i=1;i<=n;i++) {
					result[i] = expensive[i];
					if(in[i] == 0) {
						queue.offer(new Pair(i, 1));
					}
				}
				
				while(!queue.isEmpty()) {
				
					Pair pair = queue.poll();
					int x = pair.id;
					int depth = pair.depth;

					if(x == w) {
						break;
					}
					
					for(int next=1;next<order[x].length;next++) {
						if(order[x][next] == 1) {							
							result[next] = Math.max(result[next], result[x]+expensive[next]);
							
							if(--in[next] == 0) {
								queue.offer(new Pair(next, depth+1));									
							}
						}
					}
				}
											
				System.out.println(result[w]);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Pair {
		
		int id;
		int depth; 
		
		public Pair(int id, int depth) {
			this.id = id;
			this.depth = depth;
		}
	}
}
