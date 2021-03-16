package DAG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P1766 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			
			int n = Integer.valueOf(temp[0]);
			int k = Integer.valueOf(temp[1]);
			List<List<Integer>> order = new ArrayList<>();
			int[] in = new int[n+1];
			int[] result = new int[n];
			
			for(int i=0;i<n;i++) {
				order.add(new ArrayList<Integer>());
			}
			
			for(int i=0;i<k;i++) {
				temp = inbr.readLine().split(" ");
				
				int a = Integer.valueOf(temp[0]);
				int b = Integer.valueOf(temp[1]);
				
				order.get(a-1).add(b);
				in[b] += 1;
			}
			
			for(int i=1;i<=n;i++) {
				if(in[i]==0) {
					pq.offer(i);
				}
			}
			
			int idx = 0;
			
			while(!pq.isEmpty()) {
				
				int x = pq.poll();
				
				result[idx++] = x;
				
				for(int y : order.get(x-1)) {
					if(--in[y] == 0) {
						pq.offer(y);
					}
				}
			}
			
			for(int i=0;i<result.length;i++) {
				sb.append(result[i]+" ");
			}
			
			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
