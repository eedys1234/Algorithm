package BackJun2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P12931 {

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {

			int n = Integer.valueOf(inbr.readLine());
			int[] b = new int[n+1];
			String[] temp = inbr.readLine().split(" ");

			for(int i=0;i<temp.length;i++) {
				b[i+1] = Integer.valueOf(temp[i]);
			}
			
			long res = 0;
			int cnt = 0;
			boolean isDouble = false;

			while(cnt != n) {
				
				cnt = 0;
				isDouble = false;
				
				for(int i=1;i<=n;i++) 
				{
					if(b[i] % 2 == 1) {
						b[i] -= 1;
						res++;
					}
				}
				
				for(int i=1;i<=n;i++) 
				{
					if(b[i] % 2 == 0 && b[i] > 0) {
						b[i] /= 2;
						isDouble = true;
					}
					
					if(b[i] == 0) {
						cnt++;
					}
				}
				
				if(isDouble) {
					res++;
				}
				
			}
			
			System.out.println(res);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
