package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P2109 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
		
			int n = Integer.valueOf(inbr.readLine());
			ArrayList<Pair> pairs = new ArrayList<>(n);
			PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					return Integer.compare(o1.p, o2.p);
				}
			});
			
			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");
				pairs.add(new Pair(Integer.valueOf(temp[0]), Integer.valueOf(temp[1])));				
			}
			
			Collections.sort(pairs, new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					if(Integer.compare(o1.d, o2.d) == 0) {
						return Integer.compare(o1.p, o2.p);
					}
					return Integer.compare(o1.d, o2.d);
				}
			});
		
			for(int i=0;i<pairs.size();i++) {
				
				pq.offer(pairs.get(i));
				
				if(pairs.get(i).d < pq.size()) {
					pq.poll();
				}
				
			}
			
			int result = 0;
			while(!pq.isEmpty()) {
				result += pq.poll().p;
			}
			
			System.out.println(result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static class Pair {
		
		int d;
		int p;
		
		public Pair(int p, int d) {
			this.p = p;
			this.d = d;
		}
	}
}
