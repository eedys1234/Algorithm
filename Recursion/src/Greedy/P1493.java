package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1493 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int L = Integer.valueOf(temp[0]);
			int W = Integer.valueOf(temp[1]);
			int H = Integer.valueOf(temp[2]);
			
			int n = Integer.valueOf(inbr.readLine());
			int[] cube = new int[n];
			
			long res = 0;
			long before = 0;
			
			for(int i=0;i<n;i++) {
				temp = inbr.readLine().split(" ");
				cube[Integer.valueOf(temp[0])] = Integer.valueOf(temp[1]);
			}
			
			for(int i=n-1;i>=0;i--) {
			
				//2�� ���������� �����⶧���� L/W/H 2*2*2 = 8�� �����ش�.
				before <<= 3;
				
				//�ڽ��� 2^i�� ����  �� �� �������� ������ ��Ҿ��� ť�긦 ����(���� 8�� ���Ѱ� ���� ũ���� ť��� ������ ���ؼ�)
				long possibleCubeCnt = (long)(L >> i) * (W >> i) * (H >> i) - before;
				
				//2^i ũ���� ť�� ������ŭ
				long newCube = Math.min(cube[i], possibleCubeCnt);
				
				//���� �� �ִ� ť�� �߰�
				before+=newCube;
				res+=newCube;
			}
			
			//ť�긦 �� �־������
			if(before == (long)L*W*H) {
				System.out.println(res);
			}
			else {
				System.out.println("-1");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
