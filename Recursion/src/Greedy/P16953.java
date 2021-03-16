package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P16953 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int start = Integer.valueOf(temp[0]);
			int end = Integer.valueOf(temp[1]);
			int cnt = 1;
			
			while(start < end) {
				
				if(end%2 == 0) {
					cnt++;
					end /= 2;
				}
				else if(end%10 == 1){
					cnt++;
					end /= 10;
				}
				else {
					break;
				}
			}
			
			if(start == end) {				
				System.out.println(cnt);
			}
			else {
				System.out.println("-1");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
