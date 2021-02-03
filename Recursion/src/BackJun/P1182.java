package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1182 {
	
	public static void main(String[] args) {
	
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int k = Integer.valueOf(temp[1]);
			int[] sequence = new int[n];
			
			temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++) {
				sequence[i] = Integer.valueOf(temp[i]);
			}
			
			System.out.println(backTraking(sequence, 0, k, 0));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int backTraking(int[] sequence, int s, int target, int m) {
		
		//
		int cnt = 0;

		if(m == sequence.length) {
			
			int ret = 0;

			for(int i=0;i<m;i++) {
				if((s & (1 << i)) > 0) {
					ret += sequence[i];					
				}
			}			
			
			if(ret == target && s != 0) {
				return 1;	
			}
			else {
				return 0;
			}
		}
		
		cnt += backTraking(sequence, s, target, m+1);
		
		cnt += backTraking(sequence, s | (1 << m), target, m+1);			
		
		return cnt;
	}
}
