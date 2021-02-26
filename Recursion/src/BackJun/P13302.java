package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P13302 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);			
			int m = Integer.valueOf(temp[1]);
			int[] holiday = new int[m+1];
			int[] right = {10000, 25000, 37000};
			int[] dp = new int[n+1];
			
			if(m > 0) {
				temp = inbr.readLine().split(" ");
				for(int i=0;i<m;i++) {
					holiday[i+1] = Integer.valueOf(temp[i]);				
				}				
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
