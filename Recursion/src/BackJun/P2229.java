package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2229 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] order = new int[n+1];
			int[] dp = new int[n+1];
			String[] temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++) {
				order[i+1] = Integer.valueOf(temp[i]);
			}
						
			for(int i=1;i<=n;i++) 
			{
				int low = Integer.MAX_VALUE;
				int high = Integer.MIN_VALUE;

				for(int j=1;j<=i;j++) 
				{
					low = Math.min(low, order[i-j+1]);
					high = Math.max(high, order[i-j+1]);
					dp[i] = Math.max(dp[i], dp[i-j]+high-low);
				}
			}
			
			System.out.print(dp[n]);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
