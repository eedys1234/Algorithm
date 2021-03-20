package Groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P06 {
	
	public static void main(String[] args) throws Exception {

		//dp로 풀이		
		//오른쪽과 아래로만 이동하기 때문에 왼쪽에서 온 경우의 수와 위에서 온 경우의 수 중 큰 수 체크
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));		
		String[] temp = inbr.readLine().split(" ");
		
		int n = Integer.valueOf(temp[0]);
		int m = Integer.valueOf(temp[1]);
		
		int[][] store = new int[m+1][n+1];
		int[][] dp = new int[m+1][n+1];
		
		for(int i=1;i<=m;i++) 
		{
			temp = inbr.readLine().split(" ");
			for(int j=0;j<temp.length;j++)
			{
				store[i][j+1] = Integer.valueOf(temp[j]);
			}
		}
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				//왼쪽에서 왔을경우와 위에서 왔을경우의 값 중 큰 값 선택
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + store[i][j];
			}
		}
		
		System.out.println(dp[m][n]);
		
	}
}
