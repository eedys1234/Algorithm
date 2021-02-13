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
			
			//����������
			//��Ʈ����ŷ�� ���� 'T'�� �����ϴ� �κ� üũ 
			//�� �࿡ ���� �迭�� ���� 'T'�� �����ϴ� �κ� üũ
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
		
		//������ �κ�
		if(here == n+1) {			
			
			int sum = 0;
			//��
			for(int i=1;i<=(1<<n-1);i=i*2) 
			{
				int cnt = 0;
				//��
				for(int j=1;j<=n;j++) 
				{
					//�ش� �࿡ T ���� ���� 
					if((coins[j] & i) > 0) {
						cnt++;
					}
				}
				
				//���� ������������ �ƴҶ� üũ
				sum += Math.min(cnt, n-cnt);
			}
			
			res = Math.min(res, sum);
			return ;
		}
		
		//�� ������
		coins[here] = ~coins[here];
		go(here+1, n, coins);
		
		//�� ������ X
		coins[here] = ~coins[here];
		go(here+1, n, coins);
	}
}
