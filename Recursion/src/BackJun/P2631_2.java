package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2631_2 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] order = new int[n];
			int[] result = new int[n];
			
			for(int i=0;i<order.length;i++) {
				order[i] = Integer.valueOf(inbr.readLine());
			}
			
			for(int i=0;i<order.length;i++) 
			{
				result[i] = 1;
				for(int j=0;j<order.length;j++) 
				{
					if(order[j] < order[i]) {
						result[i] = Math.max(result[i], result[j]+1);
					}
				}
			}
			
			int max = 0;
			
			for(int i=0;i<result.length;i++) {
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
