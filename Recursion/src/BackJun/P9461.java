package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9461 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			int t = Integer.valueOf(line);
			int k=1;
			while(k<=t) {
				
				line = inbr.readLine();
				int n = Integer.valueOf(line);
				
				long[] result = new long[n<=5?6:n+1];
				result[1] = 1;
				result[2] = 1;
				result[3] = 1;
				result[4] = 2;
				result[5] = 2;
				
				for(int i=6;i<=n;i++) {
					result[i] = result[i-5] + result[i-1];
				}				
				k++;		
				System.out.println(result[n]);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
