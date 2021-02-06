package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P5585 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			int[] unit = {500, 100, 50, 10, 5, 1};
			int remain = 1000 - n;
			int i = 0;
			int result = 0;
			while(remain != 0) {
				
				result += remain / unit[i];
				remain %= unit[i];
				i++;
			}
			
			System.out.println(result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
