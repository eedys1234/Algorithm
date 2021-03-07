package BackJun2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P2836 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
//			2 10
//			2 8
//			6 4
			
			String[] temp = inbr.readLine().split(" ");
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			List<Distance> leftDistances = new ArrayList<>();
			int start = 0;
			int end = 0;
			long len = 0;
			
			for(int i=0;i<n;i++) {
				temp = inbr.readLine().split(" ");
				start = Integer.valueOf(temp[0]);
				end = Integer.valueOf(temp[1]);
				
				if(end - start < 0) {
					leftDistances.add(new Distance(end, start));
				}
			}
			
			Collections.sort(leftDistances, (Distance o1, Distance o2)->{
				if(Integer.compare(o1.start, o2.start) == 0) {
				return Integer.compare(o1.end, o2.end);
				}
				else {
					return Integer.compare(o1.start, o2.start);						
				}				
			});
			
			start = leftDistances.get(0).start;
			end = leftDistances.get(0).end;
			len = end - start;
			
			for(int i=1;i<leftDistances.size();i++) {
				Distance distance = leftDistances.get(i);
				
				if(end >= distance.start) {
					if(end < distance.end) {
						len += distance.end - end;
						end = distance.end;
					}
				}
				else {
					len += distance.end - distance.start;
					end = distance.end;
				}
			}
	
			System.out.println(m + 2 * len);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Distance {
		int start;
		int end;
		
		public Distance(int start, int end) {			
			this.start = start;
			this.end = end;
		}
	}
	
	
}
