package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1114 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int k = Integer.valueOf(temp[1]);
			int c = Integer.valueOf(temp[2]);
			int[] location = new int[k+1];

			if(c > k) {
				c = k;
			}

			temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++) {
				location[i] = Integer.valueOf(temp[i]);
			}
			
			location[k] = n;
			
			Arrays.sort(location);
			
			int left = 1;
			int mid = 0;
			int right = n;
			
			while(left < right) {
				
				mid = (left+right)/2;
				int cnt = c;
				int l = 0;
				
				if(location[0] > mid) {
					cnt = -1;
				}
				
				for(int i=1;i<location.length;i++) 
				{
					if(location[i]-location[i-1] > mid) {
						cnt = -1;
						break;
					}
				}
				
				for(int i=0;i<location.length-1;i++) {
					if(location[i+1] - l > mid) {
						l = location[i];
						cnt--;
					}
					
					if(cnt < 0) break;
				}
				
				
				if(cnt >= 0) {
					right = mid;
				}
				else {
					left = mid+1;
				}
			}
			
			int l = n;
			int cnt = c;
			
			for(int i=location.length-1;i>=0;i--) {
				
				if(l-location[i] > right) {
					l = location[i+1];
					cnt--;
				}				
			}
			
			if(cnt > 0) {
				System.out.println(right+" "+location[0]);
			}
			else {
				System.out.println(right+" "+l);				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
} 
