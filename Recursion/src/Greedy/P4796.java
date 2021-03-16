package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P4796 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int i = 1;
			
			while(true) 
			{
				String[] temp = inbr.readLine().split(" ");

				int l = Integer.valueOf(temp[0]);
				int p = Integer.valueOf(temp[1]);
				int v = Integer.valueOf(temp[2]);
				
				if(l == 0 && p == 0 && v == 0) {
					break;
				}
				
				int max = (v/p) * l + Math.min(v%p, l);
				System.out.println("Case "+i+": "+max);
				i++;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
