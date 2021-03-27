package Groom_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P02 {
	
	public static long[] dp;
	public static boolean[] visited;
	
	public static void main(String[] args) throws Exception {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		//첫과 끝은 항상 1이며, 0이 두번 연속으로 들어오는 경우는 없음
		//메모이제이션을 이용하여 모든 경우의 수 탐색
		int n = Integer.valueOf(inbr.readLine());
		String path = inbr.readLine();
		char[] paths = path.toCharArray();
		dp = new long[n];
		visited = new boolean[n];
		
		if(paths[0] == '0') {
			System.out.println(0);
			return ;
		}

		System.out.println(go(paths, 0));

	}
	
	public static long go(char[] paths, int x) {

		long cnt = 0;
		
		//도착했을 때
		if(x == paths.length-1) {
			return 1;
		}
		else if(dp[x] > 0) {
			return dp[x];
		}
		else {
			for(int i=1;i<=2;i++) 
			{				
				int nextX = x+i;
				
				if(nextX >= 0 && nextX <paths.length && paths[nextX] != '0' && !visited[nextX]) {
					visited[nextX] = true;
					cnt += go(paths, nextX);									
					visited[nextX] = false;
				}
			}
			
			dp[x] = cnt;
			return cnt;
		}		
	}
}
