package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2294 {

	public static final int INF = 100000;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");

			int n = Integer.valueOf(temp[0]);
			int k = Integer.valueOf(temp[1]);
			int[] coins = new int[n];
			int[] d = new int[k+1];
						
			for(int i=0;i<n;i++) {				
				coins[i] = Integer.valueOf(inbr.readLine());				
				if(k > coins[i]) {
					d[coins[i]] = 1;
				}
			}
			
			for(int i=1;i<=k;i++) 
			{
				d[i] = INF;
			}
			
			for(int i=1;i<=k;i++) 
			{
				for(int j=0;j<coins.length;j++) 
				{
					if(i>=coins[j]) {
						int m = i-coins[j] > 0 ? i-coins[j] : 0;
						d[i] = Math.min(d[i], d[m]+1);
					}
				}
			}			
						
			if(d[k] == INF) {
				System.out.println("-1");	
			}
			else {
				System.out.println(d[k]);				
			}
						
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
