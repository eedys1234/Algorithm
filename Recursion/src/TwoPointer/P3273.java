package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//투포인터 문제
public class P3273 {

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			String[] temp = inbr.readLine().split(" ");
			int[] sequence = new int[n];
			int start = 0;
			int end = sequence.length-1;
			int x = 0;
			int res = 0;

			for(int i=0;i<n;i++) {
				sequence[i] = Integer.valueOf(temp[i]);
			}
			
			x = Integer.valueOf(inbr.readLine());
			
			Arrays.sort(sequence);
			
			while(start < end) {
				
				if(sequence[start] + sequence[end] == x) {
					res++;
					start++;
					end--;
				}
				else if(sequence[start] + sequence[end] > x) {
					end--;					
				}
				else {
					start++;
				}
			}
			
			System.out.println(res);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
