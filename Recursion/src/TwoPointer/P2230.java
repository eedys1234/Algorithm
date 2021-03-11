package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//Two Pointer
public class P2230 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			int n = Integer.valueOf(temp[0]);
			long m = Integer.valueOf(temp[1]);
			long[] sequence = new long[n];
			int start = 0;
			int end = 1;
			long min = 0;
			
			for(int i=0;i<n;i++) {
				sequence[i] = Long.valueOf(inbr.readLine());
			}
			
			Arrays.sort(sequence);
			min = Long.MAX_VALUE;
						
			//m = 0인경우도 고려해야하기 때문에 start 값과 end 값이 같은 조건도 포함
			while(start <= end && start < sequence.length && end < sequence.length) {
				
				long diff = sequence[end] - sequence[start];

				if(diff < m) {
					end++;
				}
				else {
					start++;					
					min = Math.min(min, diff);
				}
			}
			
			System.out.println(min);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
