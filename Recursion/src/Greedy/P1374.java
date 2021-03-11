package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P1374 {

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			List<Lecture> lectures = new ArrayList<>();

			PriorityQueue<Lecture> pq = new PriorityQueue<>((Lecture l1, Lecture l2)-> {
				
				if(Integer.compare(l1.end, l2.end) == 0) {
					return Integer.compare(l1.start, l2.start);					
				}
				return Integer.compare(l1.end, l2.end);
			});

			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");
				int index = Integer.valueOf(temp[0]);
				int start = Integer.valueOf(temp[1]);
				int end = Integer.valueOf(temp[2]);
				
				lectures.add(new Lecture(index, start, end));				
			}
			
			Collections.sort(lectures);
			pq.offer(lectures.get(0));
			
			for(int i=1;i<lectures.size();i++) {
				
				if(pq.peek().end <= lectures.get(i).start) {
					pq.poll();
				}
				pq.offer(lectures.get(i));
			}
			
			System.out.println(pq.size());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Lecture implements Comparable<Lecture> {
		
		public int index = 0;
		public int start = 0;
		public int end = 0;
		
		public Lecture(int index, int start, int end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {
			if(Integer.compare(this.start, o.start) == 0) {
				return Integer.compare(this.end, o.end);
			}
			else {					
				return Integer.compare(this.start, o.start);
			}		
		}
	}
}
