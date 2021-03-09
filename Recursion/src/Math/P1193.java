package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1193 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			int x = Integer.valueOf(line);
			int sum = 0;
			int i = 0;
			int k = 0;
			String str = "";
			
			while(sum < x) {
				i++;
				sum+=i;
			}
			
			k = x-(sum-i);
			if(i%2 == 1) {
				str = (i+1-k)+ "/" + k;
			}
			else {
				str = k + "/" + (i+1-k);
			}
			
			System.out.print(str);
			
		} catch(Exception e) {
			
		}
	}
}
