package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P2141 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			List<Pair> pairs = new ArrayList<>(n);
			long sum = 0;
			
			for(int i=1;i<=n;i++) {
				String[] temp = inbr.readLine().split(" ");
				long x = Long.valueOf(temp[0]);
				long a = Long.valueOf(temp[1]);
				pairs.add(new Pair(x, a));
				sum += a;
			}
			
			Collections.sort(pairs, new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {					
					if(Long.compare(o1.x, o2.x) == 0) {
						return Long.compare(o1.a, o2.a);
					}
					return Long.compare(o1.x, o2.x);
				}
			});
			
			//sum /= 2;
			sum = (sum+1)/2;
			long leftSum = 0;
			int idx = 0;

			while(leftSum < sum) {
				leftSum += pairs.get(idx++).a;
			}
			
			System.out.println(pairs.get(idx-1).x);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Pair {
		
		long x;
		long a;
		
		public Pair(long x, long a) {
			this.x = x;
			this.a = a;
		}
	}
}
