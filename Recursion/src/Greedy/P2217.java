package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2217 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());			
			int[] rope = new int[n];
			int max = 0;
			
			for(int i=0;i<rope.length;i++) {
				rope[i] = Integer.valueOf(inbr.readLine());
			}
			
			Arrays.sort(rope);
			
			for(int i=0;i<rope.length;i++) {
				max = Math.max(max, rope[i] * (n-i));
			}
			
			System.out.println(max);
					
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
