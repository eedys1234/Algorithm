package BackJun2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2231 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int sum = 0;
			int k = 0;
			for(int i=1;i<n;i++)
			{
				sum = i;
				k = i;
				while(k>0) {
					sum += k%10;
					k /= 10;
				}
				
				if(sum == n) {
					System.out.println(i);
					return;
				}
			}
			
			System.out.println(0);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
