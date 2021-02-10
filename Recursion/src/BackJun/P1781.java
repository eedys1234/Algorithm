package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P1781 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			List<Pair> pairs = new ArrayList<>(n);
			PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {

					return Integer.compare(o1.cups, o2.cups);
				}
			});
			
			int result = 0;
			
			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");
				Pair pair = new Pair(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]));
				pairs.add(pair);				
			}
			
			Collections.sort(pairs, new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					
					if(Integer.compare(o1.deadline, o2.deadline) == 0) {
						return Integer.compare(o1.cups, o2.cups);
					}
					
					return Integer.compare(o1.deadline, o2.deadline);
				}
			});			
						
			for(int i=0;i<pairs.size();i++) {
				
				pq.offer(pairs.get(i));
				
				if(pairs.get(i).deadline < pq.size()) {
					pq.poll();
				}
				
			}
			
			while(!pq.isEmpty()) {
				result += pq.poll().cups;
			}
			System.out.println(result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Pair {
		
		int deadline;
		int cups;
		
		public Pair(int deadline, int cups) {
			this.deadline = deadline;
			this.cups = cups;
		}
	}
}
