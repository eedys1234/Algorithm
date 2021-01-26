package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1463 {

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();			
			
			int n = Integer.valueOf(line);
			int[] result = new int[n+1];

			//3À¸·Î ³ª´®
			//2·Î ³ª´®
			//1À» »­
			
			int min = 0;
			for(int i=2;i<=n;i++) 
			{
				if(i%3 == 0 && i%2 == 0) {
					min = Math.min(result[i/3], result[i/2]);
					min = Math.min(min, result[i-1]);
					result[i] = min +1;
				}
				else if(i%3 == 0) {
					result[i] = Math.min(result[i/3], result[i-1]) + 1;					
				}
				else if(i%2 == 0) {
					result[i] = Math.min(result[i/2], result[i-1]) + 1;										
				}
				else {
					result[i] = result[i-1] + 1;
				}
			}
			
			System.out.println(result[n]); 
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
