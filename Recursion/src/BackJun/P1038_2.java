package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1038_2 {

	public static int cnt = 0;
	
	public static void main(String[] args) {
	
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			int i=1;
			long result = -1;
			
			if(n > 1022) {
				System.out.println("-1");
				return;
			}
			
			while(result == -1) {
				result = isDecreasing(n, i, i, 0L, 10);
				i++;
			}
			
			System.out.println(result);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static long isDecreasing(int n, int len, int digit, long value, int limit) {
		
		long result = 0;
		
		if(digit == 0) {
			
			if(value != 0) {
				cnt++;				
			}
			
			if(n == cnt) {
				return value;
			}
			return -1;
		}
				
		for(int i=0;i<limit;i++) {		
			if(len > 1 && len == digit && i==0) {
				continue;
			}
			result = isDecreasing(n, len, digit-1, (value * 10) + i, i);
			
			if(result != -1) {
				return result;
			}
		}
		
		return -1;
	}
	
}
