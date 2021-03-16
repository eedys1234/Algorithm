package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P7570 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] order = new int[n+1];
			int[] position = new int[n+2];
			
			String[] temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++) {
				order[i+1] = Integer.valueOf(temp[i]);
				position[order[i+1]] = i+1;
			}
			
			int len = 0;
			
			for(int i=1;i<n;i++) {
			
				int p = order[i]+1;
				int ni = position[p];
				int pi = i;
				int value = 1;
				
				while(ni > pi) {
					pi = ni;
					ni = position[++p];					
					value++;
				}
				 
				if(value > len) {
					len = value;
				}
			}
						
			System.out.println(n-len);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
