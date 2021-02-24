package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2616 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] people = new int[n+1];
			int[][] dp = new int[4][n+1];
			int[] s = new int[n+1];
			String[] temp = inbr.readLine().split(" ");
			
			for(int j=0;j<temp.length;j++)
			{
				people[j+1] = Integer.valueOf(temp[j]);
			}
			
			int p = Integer.valueOf(inbr.readLine());
			
			int sum = 0;
			for(int i=1;i<=n;i++)
			{
				sum += people[i];
				s[i] = sum;
			}
			int res = 0;
			for(int i=1;i<4;i++)
			{
				for(int j=i*p;j<=n;j++)
				{
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-p]+s[j]-s[j-p]);						
				}
			}
			
			System.out.println(dp[3][n]);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
