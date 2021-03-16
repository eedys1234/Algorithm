package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1715 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			
			int n = Integer.valueOf(inbr.readLine());
			int[] card = new int[n];
			int result = 0;

			for(int i=0;i<n;i++) {
				card[i] = Integer.valueOf(inbr.readLine());
				pq.offer(card[i]);
			}
			
			while(pq.size() > 1) {
				
				int x = pq.poll();
				int y = pq.poll();
				
				int z = x+y;
				pq.offer(z);				
				result+=z;
			}
			
			System.out.println(result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
