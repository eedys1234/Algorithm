package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2212 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			int k = Integer.valueOf(inbr.readLine());
			int[] location = new int[n];
			int[] distance = new int[n];
			int result = 0;
			
			String[] temp = inbr.readLine().split(" ");

			for(int i=0;i<temp.length;i++) {
				location[i] = Integer.valueOf(temp[i]);
			}
			
			Arrays.sort(location);
						
			for(int i=0;i<location.length-1;i++) {
				distance[i] = Math.abs(location[i]-location[i+1]);
			}
			
			Arrays.sort(distance);
			
			/*
			for(int i=distance.length-1;i>=distance.length-(k-1);i--) {
				distance[i] = 0;
			}
			
			*/

			for(int i=0;i<distance.length-(k-1);i++) {
				result+=distance[i];
			}
			
			System.out.println(result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 
}
