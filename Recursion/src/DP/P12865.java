package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P12865 {

	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			
			String[] temp = line.split(" ");
			
			int n = Integer.valueOf(temp[0]); //°³¼ö
			int total_w = Integer.valueOf(temp[1]); // ÃÑ ¹«°Ô
			int[][] value = new int[2][n+1];
			int[][] bag = new int[n+1][total_w + 1];
			int k = 1;
			
			while(n-->0) {				
				line = inbr.readLine();
				temp = line.split(" ");
				int w = Integer.valueOf(temp[0]);
				int v = Integer.valueOf(temp[1]);
				value[0][k] = w;
				value[1][k++] = v;
			}
			
			for(int i=1;i<bag.length;i++) 
			{
				for(int j=1;j<bag[0].length;j++) 
				{
					if(value[0][i] <= j) {
						int m = j-value[0][i]<=0?0:j-value[0][i];
						bag[i][j] = Math.max(bag[i-1][j], bag[i-1][m]+value[1][i]);						
					}
					else {
						bag[i][j] = bag[i-1][j];
					}
				}
			}
			
			int max = 0;
			
			for(int i=1;i<bag.length;i++) {
				if(max < bag[i][total_w]) {
					max = bag[i][total_w];
				}
			}
			System.out.println(max);
			
		} catch(Exception e) {			
			e.printStackTrace();
		}
	}
}
