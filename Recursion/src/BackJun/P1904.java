package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1904 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			
			int n = Integer.valueOf(line);
			int[] value = new int[n+1];
			
			value[1] = 1;
			if(n>1)
			value[2] = 2;
			
			for(int i=3;i<=n;i++) {
				value[i] = (value[i-1] + value[i-2])%15746;
			}

			long result = value[n];
			System.out.println(result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
