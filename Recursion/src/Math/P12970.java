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
			
			//모든 자리수가 B라고 가정
			//i=0부터 i=n-1까지 B->A로 변환 시 추가되는 쌍 개수 n(전체 크기)-i(A의 인덱스)-m(A의 개수)
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
