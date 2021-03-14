package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11066 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

		try {
			 String line = inbr.readLine();
			 
			 int t = Integer.valueOf(line);
			 int k = 1;
			 while(k<=t) {
				 line = inbr.readLine();
				 int n = Integer.valueOf(line);
				 int[] value = new int[n+1];
				 String[] temp = inbr.readLine().split(" ");
				 for(int i=0;i<temp.length;i++) {
					 value[i+1] = Integer.valueOf(temp[i]);
				 }
				 
				 long min = calculate(value, n);
				 System.out.println(min);
				 k++;
			 }
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	 
	public static long calculate(int[] value, int n) {
				
		int[][] result = new int[n+1][n+1];
		int sum = 0;
		
		for(int r=1;r<=n-1;r++) 
		{
			for(int i=1;i<=n-r;i++) 
			{
				int j = i+r;
				sum = 0;
				for(int l=i;l<=j;l++) {
					sum+=value[l];
				}
				result[i][j] = result[i][i] + result[i+1][j] + sum;//k=i;
				
				for(int k=i+1;k<=j-1;k++)
				{
					if(result[i][j] > result[i][k] + result[k+1][j] + sum) {
						result[i][j] = result[i][k] + result[k+1][j] + sum;
					}
				}
			}
		}
	
		return result[1][n];
	}

}
