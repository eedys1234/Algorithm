package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P3048 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			int n1 = Integer.valueOf(temp[0]);
			int n2 = Integer.valueOf(temp[1]);
			int m = 0;
			StringBuilder sb = new StringBuilder();
			
			String line = inbr.readLine();
			String A = sb.append(line).reverse().toString();
			String B = inbr.readLine();			
			char[] C = sb.append(B).toString().toCharArray();
			int[] direction = new int[n1+n2];
			int t = Integer.valueOf(inbr.readLine());
			
			for(int i=0;i<A.length();i++) {
				direction[i] = -1;
			}
			
			for(int i=A.length()+B.length()-1;i>=A.length();i--) {
				direction[i] = 1;
			}
			
			for(int k=1;k<=t;k++) 
			{								
				for(int j=m;j<direction.length-1;j++)
				{
					if(direction[j] != direction[j+1]) {
						char ch = C[j];
						C[j] = C[j+1];
						C[j+1] = ch;
						
						int l = direction[j];
						direction[j] = direction[j+1];
						direction[j+1] = l;
						j++;
					}					
				}
				
				if(direction[m] == 1) {
					m++;
				}
				
			}
			
			for(int i=0;i<C.length;i++)
			{
				System.out.print(C[i]);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
