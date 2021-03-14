package LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


//LIS
public class P2550 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] bulbs = new int[n+1];
			int[] switchs = new int[n+1];
			int[] result = new int[n+1];
			String[] temp = inbr.readLine().split(" ");
			int cnt = 0;

//			����ġ�� ������� ������ ������ Ŀ���� ��ġ�� ������ �������� ����
//			����ġ�� ����� ������ ������ ����
//			������ ������ ���� Ŀ���� lis�� ����
//			2 4 1 5 3
//			5 1 3 2 4
//			1 1 2 2 3
			
			for(int i=0;i<temp.length;i++) {
				switchs[i+1] = Integer.valueOf(temp[i]);
			}
			
			temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++) {
				bulbs[Integer.valueOf(temp[i])] = i+1;
			}
			
			for(int i=1;i<=n;i++) 
			{
				result[i] = 1;
				for(int j=1;j<i;j++) 
				{
					if(bulbs[switchs[i]] > bulbs[switchs[j]]) {
						result[i] = Math.max(result[i], result[j]+1);
					}
				}				
			}
			
			for(int i=1;i<result.length;i++) {
				cnt = Math.max(cnt, result[i]);
				
			}
			
			System.out.println(cnt);

			//�����ϴ� ����
			int[] ans = new int[cnt];
			int k = 0;
			
			for(int i=result.length-1;i>=1;i--) {
				if(result[i] == cnt) {
					ans[k++] = switchs[i];
					cnt--;
				}
			}

			Arrays.sort(ans);
			System.out.println(Arrays.toString(ans).replace("[", "").replace("]", "").replace(",", ""));			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Bulb {
		
		public int switchNm;
		public int bulbNm;
		
	}
}
