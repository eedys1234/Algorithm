package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2437 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {		
			int n = Integer.valueOf(inbr.readLine());
			long[] value = new long[n];
			long min = 0;
			long sum = 0;
			
			String[] temp = inbr.readLine().split(" ");

			for(int i=0;i<temp.length;i++) {
				value[i] = Long.valueOf(temp[i]);
			}
			
			Arrays.sort(value);
			
			if(value[0] >1) {
				System.out.println(1);
				return;
			}
			for(int i=0;i<value.length;i++) {
				sum += value[i];
				if(i != value.length-1 && sum+1 < value[i+1]) {
					break;
				}				
			}
			
			min = sum + 1;
			
			System.out.println(min);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
