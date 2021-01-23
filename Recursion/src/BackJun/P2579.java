package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2579 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			
			int n = Integer.valueOf(line);
			
			int[] stare = new int[n+1];
			int[] value = new int[n+1];
						
			for(int i=1;i<=n;i++) {
				stare[i] = Integer.valueOf(inbr.readLine());
			}

			value[1] = stare[1];
			if(n>=2)
				value[2] = value[1] + stare[2];
			
			for(int i=3;i<=n;i++) {
				value[i] = Math.max(value[i-2] + stare[i], value[i-3] + stare[i-1] + stare[i]);
			}
			
			System.out.println(value[n]);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
