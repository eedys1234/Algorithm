package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P5557 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			
			//더하거나 뺀 값이 0이상 20이하이므로
			long[][] dp = new long[n+1][21];
			int[] arr = new int[n+1];
			String[] temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++) {
				arr[i+1] = Integer.valueOf(temp[i]);
			}
			
			dp[1][arr[1]]+=1;
			
			for(int i=2;i<dp.length;i++) {
				for(int j=0;j<=20;j++) {					
					if(dp[i-1][j]>0) {
						if(j+arr[i] <= 20) {
							dp[i][j+arr[i]] += dp[i-1][j]; 
						}
						if(j-arr[i] >= 0) {
							dp[i][j-arr[i]] += dp[i-1][j];
						}
					}
				}
			}
			
			System.out.println(dp[n-1][arr[n]]);
					
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
