package BackJun2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2531 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int d = Integer.valueOf(temp[1]);
			int k = Integer.valueOf(temp[2]);
			int c = Integer.valueOf(temp[3]);
			int[] sushi = new int[n+1];
			boolean[] check = new boolean[d+1];
			int start = 0;
			int end = 1;
						
			for(int i=0;i<n;i++) {
				sushi[i+1] = Integer.valueOf(inbr.readLine());
			}
			
			check[sushi[start]] = check[sushi[end]] = true;
			
			while(end < sushi.length) {
			}			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
