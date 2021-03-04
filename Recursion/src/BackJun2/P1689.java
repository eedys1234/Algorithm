package BackJun2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P1689 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			List<Pair> pairs = new ArrayList<>();
			
			for(int i=0;i<n;i++) 
			{
				String[] temp = inbr.readLine().split(" ");
				pairs.add(new Pair(Integer.valueOf(temp[0]), 1));
				pairs.add(new Pair(Integer.valueOf(temp[1]), -1));
			}
			
			Collections.sort(pairs, new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					if(Integer.compare(o1.x, o2.x) == 0) {
						return Integer.compare(o1.t, o2.t);
					}
					else {
						return Integer.compare(o1.x, o2.x);
					}
				}
			});
			
			int cnt = 0;
			int res = 0;
			
			for(int i=0;i<pairs.size();i++) {
				Pair pair = pairs.get(i);
				if(pair.t == 1) {
					cnt++;
				}
				else {
					cnt--;
				}
				
				res = Math.max(res, cnt);
			}
			
			System.out.println(res);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public static class Pair {
		
		int x;
		int t;
		
		public Pair(int x, int t) {
			this.x = x;
			this.t = t;
		}
	}
}
