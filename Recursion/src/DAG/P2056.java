package DAG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P2056 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] time = new int[n+1];
			int[] in = new int[n+1];
			int[] dp = new int[n+1];
			List<List<Integer>> adjacent = new ArrayList<>();
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i=0;i<n;i++) {
				adjacent.add(new ArrayList<>());
			}
			
			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");
				
				time[i+1] = Integer.valueOf(temp[0]);
				int num = Integer.valueOf(temp[1]);
				
				for(int j=0;j<num;j++) {
					int builder = Integer.valueOf(temp[j+2]);
					adjacent.get(builder-1).add(i+1);
					in[i+1]++;
				}
			}
			
			
			for(int i=1;i<in.length;i++) {
				dp[i] = time[i];
				if(in[i] == 0) {
					queue.offer(i);
				}
			}
			
			while(!queue.isEmpty()) {
								
				int x = queue.poll();
				
				for(int next : adjacent.get(x-1)) {
					dp[next] = Math.max(dp[next], dp[x]+time[next]);
					if(--in[next] == 0) {
						queue.offer(next);
					}					
				}
			}
			
			int max = 0;
			for(int i=1;i<dp.length;i++) {
				max = Math.max(max, dp[i]);
			}
			
			System.out.println(max);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
