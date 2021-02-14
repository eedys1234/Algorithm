package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1398 {

	public static final int INF = 100000000;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int t = Integer.valueOf(inbr.readLine());
			int[] dp = new int[101];
			int res = 0;
			
			for(int i=1;i<=100;i++) {
				dp[i] = INF;
			}
			
			//������ ������ ��Ģ�� ����
			//1, 10, 25 / 100, 1000, 2500 / ....
			//�������� ���κ��ٴ� ū ���� �������� �����°��� �̵�
			for(int i=1;i<=100;i++) {
				if(i-1 >= 0) {
					dp[i] = Math.min(dp[i], dp[i-1]+1);
				}
				if(i-10 >= 0) {
					dp[i] = Math.min(dp[i], dp[i-10]+1);					
				}
				if(i-25 >= 0) {
					dp[i] = Math.min(dp[i], dp[i-25]+1);					
				}
			}
			
			while(t-- > 0) {
				
				long n = Long.valueOf(inbr.readLine());
				
				while(n > 0) {
					res += dp[(int) (n % 100)];
					n= n/100;						
				}
				
				System.out.println(res);
				res = 0;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
