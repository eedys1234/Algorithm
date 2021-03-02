package BackJun2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1132 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			boolean[] checker = new boolean[11];
			long[] num = new long[11];
			String[] input = new String[n+1];
			
			for(int i=0;i<n;i++)
			{
				input[i+1] = inbr.readLine();
			}
			
			for(int i=1;i<=n;i++)
			{
				checker[input[i].charAt(0) - 'A' + 1] = true;
				
				long value = 1;

				for(int j=input[i].length()-1;j>=0;j--)
				{
					num[input[i].charAt(j) - 'A' + 1] += value;
					value *= 10;
				}				
			}
			
			int j=0;
			
			for(int i=1;i<=10;i++) 
			{
				if(!checker[i]) {
					j = i;
					break;
				}				
			}

			/*
			for(int i=1;i<=10;i++) 
			{
				System.out.print(num[i]+" ");
			}
			*/
			
			for(int i=1;i<=10;i++) 
			{
				if(!checker[i] && num[i] < num[j]) {
					j = i;
				}
			}
			
			num[j] = 0;
			
			Arrays.sort(num);
			int k = 1;
			long res = 0;
			
			for(int i=10;i>0;i--) 
			{
				//System.out.print(num[i]*(i-k)+" ");
				res += num[i] * (i-k);
			}
			
			System.out.println(res);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
