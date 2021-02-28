package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1793 {

	public static String[] dp;
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			dp = new String[251];
			tiling(250);
			String line = null;
			while((line=inbr.readLine()) != null) {
				int n = Integer.valueOf(line);				
				System.out.println(tiling(n));				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String tiling(int k) {
		
		if(k==0) return "1";
		else if(k==1) return "1";
		else if(k==2) return "3";
		
		String ret = dp[k];
		if(ret != null) return ret;
		
		//dp[k] = ret = tiling(k-1) + 2 * tiling(k-2);
		dp[k] = ret = bigNumAdd(tiling(k-1), bigNumAdd(tiling(k-2), tiling(k-2)));
		return ret;
	}
	
	public static String bigNumAdd(String num1, String num2) {
		
		int i = num1.length()-1;
		int j = num2.length()-1;
		
		long sum = 0;
		StringBuilder sb = new StringBuilder();
		
		while(i>=0 || j>=0) {
			
			if(i>=0) {
				long tmp = num1.charAt(i); 
				tmp -= 48;				
				sum += tmp;
				i--;
			}
			
			if(j>=0) {
				long tmp = num2.charAt(j); 
				tmp -= 48;				
				sum += tmp;
				j--;
			}
			
			sb.append(sum%10);
			sum /= 10;
		}
		if(sum > 0)	sb.append(sum);
		
		return sb.reverse().toString();
	}
}
