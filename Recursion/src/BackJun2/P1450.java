package BackJun2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1450 {

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int c = Integer.valueOf(temp[1]);
			int[] bag = new int[n];
			temp = inbr.readLine().split(" ");

			for(int i=0;i<n;i++) 
			{
				bag[i] = Integer.valueOf(temp[i]);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
