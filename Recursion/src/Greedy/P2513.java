package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P2513 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int k = Integer.valueOf(temp[1]);
			int s = Integer.valueOf(temp[2]);
			int res = 0;
			int distance = 0;
			int people = 0;
			
			List<Pair> leftPairs = new ArrayList<>();
			List<Pair> rightPairs = new ArrayList<>();

			for(int i=0;i<n;i++) {
				temp = inbr.readLine().split(" ");
				int x = Integer.valueOf(temp[0]);
				int p = Integer.valueOf(temp[1]);

				if(x < s) {
					leftPairs.add(new Pair(x, p));					
				}
				else {
					rightPairs.add(new Pair(x, p));
				}		
			}
			
			Collections.sort(leftPairs);
			
			Collections.sort(rightPairs, new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					return Integer.compare(o2.x, o1.x);
				}
			});
			
			for(int i=0;i<leftPairs.size();i++) {
				
				people = 0;
				int j = 0;
				
				for(j=i;j<leftPairs.size();j++) {
					
					Pair pair = leftPairs.get(j);
					people += pair.p;
					
					if(people > k) {
						pair.p = people-k;
						break;
					}
				}	
				res += Math.abs(s - leftPairs.get(i).x)*2;
				i = --j;
			}
			
			for(int i=0;i<rightPairs.size();i++) 
			{				
				people = 0;
				int j = 0;
				
				for(j=i;j<rightPairs.size();j++) 
				{					
					Pair pair = rightPairs.get(j);
					people += pair.p;
					
					if(people > k) {
						pair.p = people-k;
						break;
					}
				}
				res += Math.abs(s - rightPairs.get(i).x)*2;
				i = --j;
			}
			
			System.out.println(res);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static class Pair implements Comparable<Pair> {
				
		int x;
		int p;
		
		public Pair(int x, int p) {
			this.x = x;
			this.p = p;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.x, o.x);
		}
	}
}
