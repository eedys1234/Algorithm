package BackJun2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2798 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			int[] cards = new int[n];
			int max = 0;
			
			temp = inbr.readLine().split(" ");
			for(int i=0;i<n;i++) {
				cards[i] = Integer.valueOf(temp[i]);
			}
			
			for(int i=0;i<n-2;i++) 
			{
				for(int j=i+1;j<n-1;j++)
				{
					for(int k=j+1;k<n;k++)
					{
						int blackjak = cards[i]+cards[j]+cards[k];
						if(blackjak <= m && max < blackjak)
						{
							max = blackjak;
						}
					}
				}
			}
			
			System.out.println(max);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
