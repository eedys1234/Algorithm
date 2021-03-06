package BackJun2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2836 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
//			2 10
//			2 8
//			6 4
			
			String[] temp = inbr.readLine().split(" ");
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			
			for(int i=0;i<n;i++) {
				temp = inbr.readLine().split(" ");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
