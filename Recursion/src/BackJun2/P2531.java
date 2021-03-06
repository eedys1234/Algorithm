package BackJun2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

//�����̵� ������
public class P2531 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int d = Integer.valueOf(temp[1]);
			int k = Integer.valueOf(temp[2]);
			int c = Integer.valueOf(temp[3]);
			int[] sushi = new int[n];
			int[] sushiKind = new int[d+1];
			int cnt = 0;
			int res = 0;
			
			Deque<Integer> deq = new LinkedList<Integer>();
						
			for(int i=0;i<n;i++) {
				sushi[i] = Integer.valueOf(inbr.readLine());
			}
			
			for(int i=0;i<k;i++) {
				deq.push(sushi[i]);
				if(sushiKind[sushi[i]]++ == 0) {
					cnt++;
				}
				res = Math.max(res, cnt);
			}
			
			for(int i=0;i<n-1;i++) {
				
				//�� �տ� ���� ����
				deq.pop();
				//������ ���ð� �ϳ��ۿ� ���� ���ö�� ���� ����
				if(--sushiKind[sushi[i]] == 0) {
					cnt--;
				}
				
				//k��° ���� ���� �߰�
				deq.push(sushi[(i+k)%n]);
				
				//�߰��� ���ð� ���ο� ������� ���� �߰�
				if(sushiKind[sushi[(i+k)%n]]++ == 0) {
					cnt++;
				}
				
				if(sushiKind[c] == 0) {
					res = Math.max(res, cnt+1);
				}
				else {
					res = Math.max(res, cnt);					
				}
			}
			
			System.out.println(res);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
