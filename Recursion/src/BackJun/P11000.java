package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P11000 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			List<Pair> sortedPairs = new ArrayList<>();
			PriorityQueue<Pair> wait = new PriorityQueue<>(new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					
					if(Integer.compare(o1.end, o2.end) == 0)
					{
						return Integer.compare(o1.start, o2.start);
					}
					return Integer.compare(o1.end, o2.end);
				}
			});
			
			for(int i=0;i<n;i++) 
			{
				String[] temp = inbr.readLine().split(" ");				
				sortedPairs.add(new Pair(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]), i));				
			}
			
			Collections.sort(sortedPairs);
			
			wait.offer(sortedPairs.get(0));
			
			for(int i=1;i<sortedPairs.size();i++) {
				
				if(wait.peek().end > sortedPairs.get(i).start) {
					wait.offer(sortedPairs.get(i));
				}
				else {
					wait.poll();
					wait.offer(sortedPairs.get(i));
				}
			}

			System.out.println(wait.size());			
			
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static class Pair implements Comparable<Pair>{
		
		int start;
		int end;
		int index;
		boolean used;
		
		public Pair(int start, int end, int index) {
			this.start = start;
			this.end = end;
			this.index = index;
			this.used = false;
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
