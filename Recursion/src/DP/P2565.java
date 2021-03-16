package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2565 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			
			int n = Integer.valueOf(line);
			int[] pole = new int[501];
			int[] result = new int[501];
			
			for(int i=1;i<=n;i++) 
			{
				line = inbr.readLine();
				String[] temp = line.split(" ");
							
				pole[Integer.valueOf(temp[0])] = Integer.valueOf(temp[1]);
			}
			
			
			for(int i=1;i<pole.length;i++) 
			{
				result[i] = 1; 
				for(int j=1;j<i;j++) 
				{
					if(pole[j] < pole[i] && pole[j] != 0) {
						result[i] = Math.max(result[i], result[j]+1);
					}
				}
			}
			
			int max = 0;
			
			for(int i=1;i<result.length;i++)
			{
				if(max < result[i]) {
					max = result[i];
				}
			}
			System.out.println(n-max);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
