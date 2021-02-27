package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2096 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			int[][] score = new int[n+1][4];
			int[][] minDP = new int[2][4];
			int[][] maxDP = new int[2][4];
						
			for(int i=1;i<=n;i++) 
			{
				String[] temp = inbr.readLine().split(" ");
				for(int j=0;j<temp.length;j++)
				{
					score[i][j+1] = Integer.valueOf(temp[j]);
				}
			}
			int k=1;
			int l=0;
			for(int i=1;i<=n;i++)
			{
				for(int j=1;j<=3;j++)
				{
					if(j > 1 && j < 3) {
						maxDP[k][j] = Math.max(maxDP[l][j-1], Math.max(maxDP[l][j+1], maxDP[l][j])) + score[i][j];
						minDP[k][j] = Math.min(minDP[l][j-1], Math.min(minDP[l][j+1], minDP[l][j])) + score[i][j];
					}
					else if(j==1) {
						maxDP[k][j] = Math.max(maxDP[l][j], maxDP[l][j+1]) + score[i][j];
						minDP[k][j] = Math.min(minDP[l][j], minDP[l][j+1]) + score[i][j];
					}
					else {
						maxDP[k][j] = Math.max(maxDP[l][j-1], maxDP[l][j]) + score[i][j];						
						minDP[k][j] = Math.min(minDP[l][j-1], minDP[l][j]) + score[i][j];						
					}
				}
				int temp = l;
				l = k;
				k = temp;
			}
			
			long min = Integer.MAX_VALUE;
			long max = 0;
			
			int i = n%2==0?0:1;
			for(int j=1;j<=3;j++) 
			{
				max = Math.max(max, maxDP[i][j]);
				min = Math.min(min, minDP[i][j]);
			}				
			
			System.out.println(max + " " + min);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
