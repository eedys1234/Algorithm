package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1641 {

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			long res = 0;
			int n = Integer.valueOf(temp[0]);
			int k = Integer.valueOf(temp[1]);
			int m = 0;
			int t = 0;
			
			int[] nagativeStep = new int[n];
			int[] positiveStep = new int[n];
			
			temp = inbr.readLine().split(" ");

			for(int i=0;i<n;i++) {
				int x = Integer.valueOf(temp[i]);
				if(x<0) {
					nagativeStep[m++] = x;
				}
				else {
					positiveStep[t++] = x;
				}
			}
			
			Arrays.sort(nagativeStep);
			Arrays.sort(positiveStep);
			int direction = 0;
			//0 left, 1 right

			if(Math.abs(nagativeStep[0]) < Math.abs(positiveStep[positiveStep.length-1])) {
				direction = 1;
			}
									
			for(int i=0;i<nagativeStep.length;i=i+k) 
			{
				res += 2 * Math.abs(nagativeStep[i]);
			}
			
			for(int i=positiveStep.length-1;i>=0;i=i-k) 
			{
				res += 2 * Math.abs(positiveStep[i]);				
			}
			
			if(direction == 1) {
				res -= Math.abs(positiveStep[positiveStep.length-1]);
			}
			else {
				res -= Math.abs(nagativeStep[0]);				
			}
			
			System.out.println(res);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
