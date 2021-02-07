package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14916 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {			
			int n = Integer.valueOf(inbr.readLine());
			int result = 0;
			int change = n;
			int[] ex = {5, 2};
			boolean isChangable = false;
			
			result = change/ex[0];
			change %= ex[0];
			
			for(int i=result;i>=0;i--) {				
				
				if(change%ex[1] == 0) {
					isChangable = true;
					result = i + change/ex[1];
					break;
				}
				change+=ex[0];
			}
			
			if(isChangable) {
				System.out.println(result);
			}
			else {
				System.out.println("-1");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
