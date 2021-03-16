package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1932 {

	
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String line = inbr.readLine();
			
			int t = Integer.valueOf(line);
			int m = 1;
			int[][] n = new int[t+1][t+1];
			int[][] result = new int[t+1][t+1];
			
			while(m<=t) {
				line = inbr.readLine();
				String[] temp = line.split(" ");
				for(int i=0;i<temp.length;i++) {
					n[m][i+1] = Integer.valueOf(temp[i]);					
				}
				m++;				
			}
			
			for(int i=1;i<n.length;i++) 
			{
				for(int j=1;j<=i;j++) 
				{
					result[i][j] = Math.max(result[i-1][j-1], result[i-1][j]) + n[i][j];
				}
			}

			int max = 0;
			for(int j=1;j<result[0].length;j++) {
				if(max < result[t][j]) {
					max = result[t][j];
				}
			}
			
			System.out.print(max);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
