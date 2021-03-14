package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P12970 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int k = Integer.valueOf(temp[1]);			
			int m = 1;
			int sum = 0;
			StringBuilder sb = new StringBuilder();
			
			//��� �ڸ����� B��� ����
			//i=0���� i=n-1���� B->A�� ��ȯ �� �߰��Ǵ� �� ���� n(��ü ũ��)-i(A�� �ε���)-m(A�� ����)
			for(int i=0;i<n;i++) {
				
				if(sum + (n-i-m) <= k && (n-i-m) > 0) {
					sb.append("A");
					sum += n-i-m;
					m++;
				}
				else {
					sb.append("B");
				}				
			}
			
			if(sum == k) {
				System.out.println(sb.toString());				
			}
			else {
				System.out.println("-1");
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
