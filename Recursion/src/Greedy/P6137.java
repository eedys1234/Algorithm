package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//투 포인터 응용문제
public class P6137 {

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			char[] s = new char[n];
			int left = 0;
			int right = s.length-1;
			int k = 0;
			final int MOD = 80;
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<n;i++) {
				s[i] = inbr.readLine().charAt(0);
			}
			
			while(left <= right) {
				if(left == right) {
					k++;
					sb.append(s[left++]);
				}
				else if(s[left] < s[right]) {
					k++;
					sb.append(s[left++]);
				}
				else if(s[left] > s[right]){
					k++;
					sb.append(s[right--]);					
				}
				else {
					int i = 1;
					int j = 1;
										
					while(left+i < s.length && right-j >= 0) {
						if(s[left+i] < s[right-j]) {
							k++;
							sb.append(s[left++]);
							break;
						}
						else if(s[left+i] > s[right-j]){
							k++;
							sb.append(s[right--]);						
							break;
						}
						i++;
						j++;
					}
					if(left+i == s.length ||  right-j < 0) {
						k++;
						sb.append(s[left++]);
					}
				}
				
				if(k >= MOD) {
					sb.append("\n");
					k=0;
				}
			}
			
			if(sb.toString().length() > 0 ) {
				System.out.println(sb.toString());				
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
