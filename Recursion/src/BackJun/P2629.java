package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2629 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

		try {
			 String line = inbr.readLine();
			 
			 int sum = 0;
			 int n = Integer.valueOf(line);
			 line = inbr.readLine();			 
			 String[] temp = line.split(" ");
			 
			 int[] sniker = new int[n+1];
			 
			 for(int i=0;i<temp.length;i++) {
				 sniker[i+1] = Integer.valueOf(temp[i]);
				 sum+=sniker[i+1];
			 }
			 
			 line = inbr.readLine();
			 int m = Integer.valueOf(line);
			 
			 int[] marble = new int[m+1];
			 
			 line = inbr.readLine();
			 temp = line.split(" ");

			 for(int i=0;i<temp.length;i++)
			 {
				marble[i+1] = Integer.valueOf(temp[i]); 
			 }
						 
			 int[][] result = new int[n+1][sum+1];

			
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
