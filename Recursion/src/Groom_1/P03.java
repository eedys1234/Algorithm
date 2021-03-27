package Groom_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P03 {
	
	public static void main(String[] args) throws Exception {
		//브루트포스
		//모든 경우의 수 다 셈
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(inbr.readLine());
		int[][] house = new int[n+1][n+1];
		int[] result = new int[n+1];
		int cnt = 0;
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=n;i++) 
		{
			String temp = inbr.readLine();
			for(int j=0;j<temp.length();j++) 
			{
				house[i][j+1] = Integer.valueOf(String.valueOf(temp.charAt(j)));
			}
		}

		for(int k=1;k<=n;k++) {
			cnt = countingProduct(house, k, n);			
			sum += cnt;
			result[k] = cnt;
		}
		
		sb.append("total: ").append(sum).append("\n");

		for(int k=1;k<result.length;k++) 
		{
			if(result[k] > 0) {
				sb.append("size["+k+"]: ").append(result[k]).append("\n");					
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static int countingProduct(int[][] house, int k, int n) {
		
		int cnt = 0;
		
		for(int i=1;i<house.length;i++)
		{
			if(i+k-1 > n) {
				continue;
			}

			for(int j=1;j<house[1].length;j++)
			{
				if(j+k-1 > n) {
					continue;
				}
				if(isAddProduct(house, i, j, k)) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	public static boolean isAddProduct(int[][] house, int startX, int startY, int k) {
		
		boolean isPossible = true;
		
		for(int i=startX;i<startX+k;i++)
		{
			for(int j=startY;j<startY+k;j++)
			{
				if(house[i][j] == 0) {
					isPossible = false;
					break;
				}
			}

			if(!isPossible) {
				break;
			}
		}

		return isPossible;
	}
}
