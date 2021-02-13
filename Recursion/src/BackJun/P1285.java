package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1285 {

	public static int res = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] coins = new int[n+1];
			String s = "";
			
			//동전뒤집기
			//비트마스킹을 통해 'T'가 존재하는 부분 체크 
			//각 행에 대한 배열에 현재 'T'가 존재하는 부분 체크
			for(int i=1;i<=n;i++) 
			{				
				s = inbr.readLine();
				int value = 1;
				
				for(int j=0;j<s.length();j++) 
				{
					if(s.charAt(j) == 'T') {
						coins[i] |= value;
					}
					
					value *= 2;
				}
			}
			
			go(1, n, coins);
									
			System.out.println(res);
		} catch(Exception e) {
			e.printStackTrace();			
		}
	}
	
	public static void go(int here, int n, int[] coins) {
		
		//끝나는 부분
		if(here == n+1) {			
			
			int sum = 0;
			//열
			for(int i=1;i<=(1<<n-1);i=i*2) 
			{
				int cnt = 0;
				//행
				for(int j=1;j<=n;j++) 
				{
					//해당 행에 T 존재 여부 
					if((coins[j] & i) > 0) {
						cnt++;
					}
				}
				
				//열을 뒤집었을때와 아닐때 체크
				sum += Math.min(cnt, n-cnt);
			}
			
			res = Math.min(res, sum);
			return ;
		}
		
		//행 뒤집기
		coins[here] = ~coins[here];
		go(here+1, n, coins);
		
		//행 뒤집기 X
		coins[here] = ~coins[here];
		go(here+1, n, coins);
	}
}
