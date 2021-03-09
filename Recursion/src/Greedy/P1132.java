package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class P1132 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

		try {
			
			int n = Integer.valueOf(inbr.readLine());
			long[] num = new long[10];
			boolean[] checker = new boolean[10];
			
			String[] alphbet = new String[n];
			
			for(int i=0;i<n;i++) {
				alphbet[i] = inbr.readLine();
			}
			
			for(int i=0;i<alphbet.length;i++) {
				
				long value = 1;

				if(alphbet[i].length() == 1) {
					checker[alphbet[i].charAt(0) - 'A'] = true;
				}
				
				for(int j=alphbet[i].length()-1;j>=0;j--) {
					
					long temp = num[alphbet[i].charAt(j) - 'A'];
					temp += value;
					num[alphbet[i].charAt(j) - 'A'] = temp;
										
					value *= 10;
				}
			}
			
			int l = 0;
			long sum = 0;
			long k = 9;
						
			for(int i=0;i<10;i++) {
				
				if(!checker[i] && num[i] < num[l]) {
					l = i;
				}				
			}
			
			num[l] = 0;
			
			Arrays.sort(num);
			
			for(int i=num.length-1;i>=0;i--) {				
				sum += num[i] * k;
				k--;				
			}
			
			System.out.println(sum);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
