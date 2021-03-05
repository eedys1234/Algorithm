package BackJun2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//투포인터 문제
public class P2470 {

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			long[] liquid = new long[n];
			
			String[] temp = inbr.readLine().split(" ");

			for(int i=0;i<temp.length;i++) {
				liquid[i] = Long.valueOf(temp[i]);
			}
			
			Arrays.sort(liquid);
			
			int left = 0;
			int right = liquid.length-1;
			long min = Long.MAX_VALUE;
			int idx1 = 0;
			int idx2 = 0;
			
			while(left < right) {
				
				long mixliquid = liquid[left] + liquid[right];
				if(Math.abs(mixliquid) < min) {
					
					min = Math.abs(mixliquid);
					idx1 = left;
					idx2 = right;
				}
				
				if(mixliquid < 0) {
					left++;
				}
				else {
					right--;
				}
			}
			
			System.out.println(liquid[idx1]+" "+liquid[idx2]);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
