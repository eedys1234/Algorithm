package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P13305 {
	 
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		long min = Integer.MAX_VALUE;
		long sum = 0;

		try {
			 String line = inbr.readLine();
			 
			 int n = Integer.valueOf(line);
			 
			 line = inbr.readLine();
			 String[] temp = line.split(" ");
			 long[] street = new long[temp.length+1];
			 
			 for(int i=0;i<temp.length;i++) {
				 street[i+1] = Integer.valueOf(temp[i]);				 
			 }
			 
			 line = inbr.readLine();
			 temp = line.split(" ");
			 
			 long[] cities = new long[temp.length+1];
			 long[] result = new long[street.length];
			 
			 for(int i=0;i<temp.length;i++) {
				 cities[i+1] = Integer.valueOf(temp[i]);
			 }
			 
			min = cities[1];
			for(int i=1;i<street.length;i++) 
			{
				long w = min * street[i];
				result[i] = w;
				sum += result[i];
				
				if(min > cities[i+1]) {
					min = cities[i+1];
				}
			}
						
			System.out.println(sum);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
