package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11047 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			 String line = inbr.readLine();
			 String[] temp = line.split(" ");

			 int result = 0;
			 int n = Integer.valueOf(temp[0]);
			 int[] coin = new int[n];
			 int k = Integer.valueOf(temp[1]);
			 
			 for(int i=0;i<n;i++) {
				 coin[i] = Integer.valueOf(inbr.readLine());
			 }
			 
			 for(int i=n-1;i>=0;i--) {
				 result += k/coin[i];
				 k %= coin[i];
			 }
			 
			 System.out.println(result);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
