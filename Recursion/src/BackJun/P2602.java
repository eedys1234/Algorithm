package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2602 {

	public static char[] order;
	public static char[] angel;
	public static char[] devil;
	public static int[][][] dp;

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int res = 0;
			
			order = inbr.readLine().toCharArray();
			angel = inbr.readLine().toCharArray();
			devil = inbr.readLine().toCharArray();			
			dp = new int[order.length+1][angel.length+1][2];
			
			res = move(0, 0, 0);
			res += move(0, 0, 1);
			
			System.out.println(res);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int move(int f, int s, int r) {
		
		if(f == order.length) {
			return 1;
		}
		
		int ret = 0;
		ret = dp[f][s][r];
		if(ret > 0) {
			return ret;
		}
		
		ret = 0;
		//angel
		if(r == 0) {
			for(int i=s;i<angel.length;i++) {
				if(order[f] == angel[i]) {
					ret += move(f+1, i+1, 1);
				}
			}
		}
		//devil
		else {
			for(int i=s;i<devil.length;i++) {
				if(order[f] == devil[i]) {
					ret += move(f+1, i+1, 0);
				}
			}			
		}
		
		return dp[f][s][r] = ret;
	}
}
