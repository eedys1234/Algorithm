package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P8980 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
					
			int n = Integer.valueOf(temp[0]);
			int c = Integer.valueOf(temp[1]);
			int m = Integer.valueOf(inbr.readLine());
			long result = 0;
			List<Deliver> delivers = new ArrayList<>();
			int[] capacity = new int[n+1];
			
			for(int i=0;i<m;i++) {
				temp = inbr.readLine().split(" ");
				delivers.add(new Deliver(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]), Integer.valueOf(temp[2])));
			}
			
			Collections.sort(delivers);
			
			for(int i=0;i<delivers.size();i++) {
				
				Deliver deliver = delivers.get(i);
				int boxCnt = 0;
				
				for(int j=deliver.start;j<deliver.end;j++) {
					boxCnt = Math.max(boxCnt, capacity[j]);
				}
				
				int remain = Math.min(deliver.weight, c-boxCnt);
				result += remain;
				
				for(int j=deliver.start;j<deliver.end;j++) {
					capacity[j] += remain; 
				}
				
			}
			
			System.out.println(result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	 
	public static class Deliver implements Comparable<Deliver> {
		
		int start;
		int end;
		int weight;
		
		public Deliver(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
			
		}

		@Override
		public int compareTo(Deliver o) {
			
			if(Integer.compare(this.end, o.end) == 0) {
				return Integer.compare(this.start, o.start);
			}
			
			return Integer.compare(this.end, o.end);
		}
		
		
	}
}
