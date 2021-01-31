package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1300 {

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			long start = 1;
			long end = 0;
			long mid = 0;
			long result = 0;
			
			long n = Long.valueOf(inbr.readLine());
			long k = Long.valueOf(inbr.readLine());
		
			end = k;
			
			while(start <= end) {
			
				mid = (start + end)/2;
				
				for(int i=1;i<=n;i++) {
					result += Math.min(mid/i, n);
				}
				
				if(result >= k) {
					end = mid-1;
				}
				else {
					start = mid+1;
				}
				result = 0;
			}
			
			System.out.println(start);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
