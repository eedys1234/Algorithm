package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1629 {

	public static void main(String[] args) {
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
						
			long a = Long.valueOf(temp[0]);
			long b = Long.valueOf(temp[1]);
			long c = Long.valueOf(temp[2]);
			
			long value = power(a, b, c);
			
			System.out.println(value);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static long power(long a, long b, long c) {
		
		if(b == 0) {
			return 1;
		}
		else if(b == 1) {
			return a%c;			
		}
		else if(b%2 == 1) {
			long half = power(a, (b-1)/2, c)%c;
			long result = (half*half)%c;
			return ((a%c) * result)%c;
		}
		else {
			long half = power(a, b/2, c)%c;
			long result = (half*half)%c;
			return result;			
		}
	}
}


