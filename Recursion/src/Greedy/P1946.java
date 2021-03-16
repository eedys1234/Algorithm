package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1946 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int t = Integer.valueOf(inbr.readLine());			
			String[] temp;
			
			while(t-- > 0) {
				int n = Integer.valueOf(inbr.readLine());			
				int[] score = new int[n+1];
				int result = 1;
				int min = 0;
				
				for(int i=0;i<n;i++) {
					temp = inbr.readLine().split(" ");
					score[Integer.valueOf(temp[0])] = Integer.valueOf(temp[1]);
				}
				min = score[1];
				for(int i=2;i<score.length;i++) 
				{
					if(min > score[i]) {
						min = score[i];
						result++;
					}
				}
				
				System.out.println(result);
			}
						
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

