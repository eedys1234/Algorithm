package Swiping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//½ºÀ§ÇÎ
public class P2170 {

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			List<Pair> pairs = new ArrayList<>(n);
			
			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");
				long start = Long.valueOf(temp[0]);
				long end = Long.valueOf(temp[1]);
				pairs.add(new Pair(start, end));
			}
			
			Collections.sort(pairs, new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					if(Long.compare(o1.start, o2.start) == 0) {
						return Long.compare(o1.end, o2.end);
					}
					else {						
						return Long.compare(o1.start, o2.start);
					}
				}
			});
			
			long start = pairs.get(0).start;
			long end = pairs.get(0).end;
			long line = 0;
			
			for(int i=1;i<pairs.size();i++) {
			
				Pair pair = pairs.get(i);
				if(end >= pair.start) {
					end = Math.max(end, pair.end);
				}
				else {
					line += end - start; 
					start = pair.start;
					end = pair.end;					
				}
			}

			line += end - start; 	
			
			System.out.println(line);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Pair {
		
		long start;
		long end;
		
		public Pair(long start, long end) {
			this.start = start;
			this.end = end;
		}
	}
}
