package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class binomial {

	public static int[][] bino;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			String[] temp = line.split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int k = Integer.valueOf(temp[1]);
			
			bino = new int[n+1][n+1];
			int result = func(n, k);
			System.out.print(result);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int func(int n, int k) {
		
		if(n==k || k==0) {
			return 1;
		}
		else if(bino[n][k] > 0) {
			return bino[n][k];
		}
		else {
			bino[n][k] = func(n-1, k) + func(n-1, k-1);
			return bino[n][k];
		}
	}

	
}
