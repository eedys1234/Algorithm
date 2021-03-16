package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class P2624 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int t = Integer.valueOf(inbr.readLine());
			int k = Integer.valueOf(inbr.readLine());			
			Pair[] pairs = new Pair[k+1];
			int[][] dp = new int[t+1][k+1];

			for(int i=0;i<k;i++) {
				String[] temp = inbr.readLine().split(" ");
				int p = Integer.valueOf(temp[0]);
				int n = Integer.valueOf(temp[1]);
				pairs[i+1] = new Pair(p, n);
			}
			
			//Arrays.sort(pairs);
			dp[0][0] = 1;
			for(int i=1;i<=k;i++) 
			{
				for(int j=0;j<=pairs[i].n;j++)
				{
					for(int m=0;m<=t;m++) 
					{
						if(pairs[i].p * j + m > t) continue;
						dp[pairs[i].p * j + m][i] += dp[m][i-1];
					}
				}
			}
			
			System.out.println(dp[t][k]);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Pair implements Comparable<Pair> {
		
		int p;
		int n;
		
		public Pair(int p, int n) {
			this.p = p;
			this.n = n;
		}

		@Override
		public int compareTo(Pair o) {
			return this.p - o.p;
		}


	}
}
