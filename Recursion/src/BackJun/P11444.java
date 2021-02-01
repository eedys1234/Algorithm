package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11444 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {

			long n = Long.valueOf(inbr.readLine());
		
			long value = fibo(n);
			
			System.out.println(value);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static long fibo(long n) {
		
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}		
		else {		
			return 0;
			//return (long) (Math.pow(2, k) * fibo(n-2*k) + fibo(n-(2*k+1))) %1000000007;
		}				
	}
}
