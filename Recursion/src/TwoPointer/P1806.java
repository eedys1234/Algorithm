package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//투 포인터 문제
public class P1806 {

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			int n = Integer.valueOf(temp[0]);
			int s = Integer.valueOf(temp[1]);
			int[] value = new int[n];
			int start = 0;
			int end = 0;
			int cnt = 1;
			int sum = 0;
			int res = Integer.MAX_VALUE;
			
			temp = inbr.readLine().split(" ");

			for(int i=0;i<temp.length;i++) 
			{
				value[i] = Integer.valueOf(temp[i]);
				sum += value[i];
			}
			
			if(sum < s) {
				System.out.println("0");				
				return ;
			}
			
			sum = value[start];
			
			while(start < value.length && end < value.length)
			{				
				if(sum < s) {
					end++;
					cnt++;
					if(end < value.length) {
						sum += value[end];
					}
				}
				else {
					res = Math.min(res, cnt);
					sum -= value[start++];
					cnt--;
				}				
			}
			
			System.out.println(res);				
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
