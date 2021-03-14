package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10844 {
	
	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			int n = Integer.valueOf(line);
			int[][] result = new int[n+1][12];
			
			for(int j=1;j<=9;j++) 
			{
				result[1][j] = 1;
			}
			
			for(int i=2;i<=n;i++) 
			{
				for(int j=1;j<11;j++) 
				{
					result[i][j] = (result[i-1][j-1] + result[i-1][j+1]) % 1000000000;												
				}
			}

			int sum = 0;
			for(int j=1;j<11;j++) {
				sum = (sum + result[n][j]) % 1000000000;
			}
			System.out.println(sum);				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
