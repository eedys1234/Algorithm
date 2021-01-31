package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1300 {

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int start = 1;
			int end = 0;
			int mid = 0;
			int result = 0;
			
			int n = Integer.valueOf(inbr.readLine());
			int k = Integer.valueOf(inbr.readLine());
		
			end = n*n;
			
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
			
			System.out.println(mid);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
