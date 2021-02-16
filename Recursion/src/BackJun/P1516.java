package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P1516 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] build = new int[n+1];
			int[] in = new int[n+1];
			int[] dp = new int[n+1];
			
			Queue<Integer> queue = new LinkedList<>();
			List<List<Integer>> adjacent = new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				adjacent.add(new ArrayList<Integer>());
			}
			
			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");
				
				build[i+1] = Integer.valueOf(temp[0]);
				int j = 1;
				int num = Integer.valueOf(temp[j]);
				while(num != -1 && j < temp.length) {
					
					adjacent.get(num-1).add(i+1);
					in[i+1]++;
					j++;
					num = Integer.valueOf(temp[j]);
				}
			}
			
			for(int i=1;i<in.length;i++) {	
				dp[i] = build[i];
				if(in[i] == 0) {
					queue.offer(i);
				}
			}
			
			
			while(!queue.isEmpty()) {
				
				int x = queue.poll();
				
				for(int y : adjacent.get(x-1)) {
					
					dp[y] = Math.max(dp[y], dp[x]+build[y]);
					if(--in[y] == 0) {
						queue.offer(y);
					}
				}
			}
			
			for(int i=1;i<dp.length;i++) {
				System.out.println(dp[i]);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
