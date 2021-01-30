package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2193 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

		try {
			 String line = inbr.readLine();

			 int n = Integer.valueOf(line);
			 long[] fibo = new long[n+1];
			 fibo[1] = 1;
			 
			 for(int i=2;i<=n;i++) {
				 fibo[i] = fibo[i-2] + fibo[i-1];
			 }
			 
			 System.out.println(fibo[n]);
			 
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
