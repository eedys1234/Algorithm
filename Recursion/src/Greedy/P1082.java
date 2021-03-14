package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1082 {

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			int[] cost = new int[n];
			int change = 0;
			
			String[] temp = inbr.readLine().split(" ");

			for(int i=0;i<temp.length;i++)
			{
				cost[i] = Integer.valueOf(temp[i]);
			}
			
			change = Integer.valueOf(inbr.readLine());
			String[] dp = new String[change+1];			
			dp[0] = "";
			
			for(int i=1;i<=change;i++) 
			{
				dp[i] = "";
				for(int j=0;j<cost.length;j++) 
				{
					if(cost[j] <= i) {
						if(j>0) {
							dp[i] = max(dp[i], j+dp[i-cost[j]]);							
						}
						else {
							if(dp[i-cost[j]].length() > 0 && dp[i-cost[j]].charAt(0) != '0') {
								dp[i] = max(dp[i], dp[i-cost[j]]+j);							
							}
							else if(dp[i-cost[j]].length() == 0){
								dp[i] = max(dp[i], dp[i-cost[j]]+j);															
							}
							else {
								dp[i] = max(dp[i], dp[i-cost[j]]);																							
							}
						}
					}
				}
			}
			
			System.out.println(dp[change]);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String max(String num1, String num2) {
		
		if(num1.length() > 0 && num2.length() > 0) {
			
			int i = num1.length()-1;
			int j = num2.length()-1;
			int min = Math.min(i, j);
			//4321
			//210
			
			if(i < j) {				
				return num2;				
			}
			else if(i > j){				
				return num1;				
			}

			for(int k=0;k<=min;k++) {
				int a = num1.charAt(k) - 48;
				int b = num2.charAt(k) - 48;
				if(a < b) {
					return num2;
				}
				else if(a > b) {
					return num1;
				}					
			}
			
			return num1;
						
		}
		else if(!num1.equals("")) {
			return num1;
		}
		else if(!num2.equals("")) {
			return num2;
		}
		
		return "";
	}
}
