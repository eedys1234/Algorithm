package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2110 {
	
	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {			
			String line = inbr.readLine();
			String[] temp = line.split(" ");

			int start = 0;
			int end = 0;
			int mid = 0;
			long cnt = 1;
			long offset = 0;
			int m = Integer.valueOf(temp[0]);
			int router = Integer.valueOf(temp[1]);
						
			int[] location = new int[m+1]; 
			
			for(int i=0;i<m;i++) {
				line = inbr.readLine();
				location[i+1] = Integer.valueOf(line);
			}
			
			Arrays.sort(location);
			end = location[location.length-1];			
			offset = location[1];
			
			while(start <= end) {
				
				mid = (start + end)/2;
				
				for(int i=2;i<location.length;i++) {
					if(location[i] >= offset + mid) {
						cnt++;
						offset = location[i];
						//System.out.println(start+", "+mid+", "+end+" : "+cnt);
					}
				}
				
				if(cnt >= router) {
					start = mid+1;
				}
				else {
					end = mid-1;
				}
				
				cnt = 1;
				offset = location[1];
			}
			
			System.out.println(end);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
