package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1003 {

	public static void main(String[] args) {
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			
			int t = Integer.valueOf(line);
			
			while(t-- > 0) {
				line = inbr.readLine();
				int n = Integer.valueOf(line);
				int[][] value = new int[2][n+1];
				
				value[0][0] = 1;
				value[1][0] = 0;
				if(n>=1) {
					value[0][1] = 0;
					value[1][1] = 1;					
				}
				
				for(int i=2;i<=n;i++) {
					value[0][i] = value[0][i-1] + value[0][i-2];
					value[1][i] = value[1][i-1] + value[1][i-2];
				}
				
				System.out.println(value[0][n] + " " + value[1][n]);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
