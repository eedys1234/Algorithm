package BS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1920 {

	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			String line = inbr.readLine();

			int n = Integer.valueOf(line);
			int[] value = new int[n];
			
			line = inbr.readLine();
			String[] temp = line.split(" ");
			
			for(int i=0;i<temp.length;i++) {
				value[i] = Integer.valueOf(temp[i]);
			}
			
			line = inbr.readLine();
			int m = Integer.valueOf(line);
			
			int[] search = new int[m];
			
			line = inbr.readLine();
			temp = line.split(" ");
			
			for(int i=0;i<temp.length;i++) {
				search[i] = Integer.valueOf(temp[i]);
			}
			
			Arrays.sort(value);
			
			for(int i=0;i<search.length;i++) {
				boolean result = binarySearch(value, 0, value.length, search[i]);
				if(result) {
					sb.append("1");
				}
				else {					
					sb.append("0");
				}
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static boolean binarySearch(int[] value, int left, int right, int target) {
		
		while(left < right) {
			int mid = (left + right)/2;
			
			if(value[mid] < target) {
				left = mid + 1;
			}
			else if(value[mid] > target) {
				right = mid ;
			}
			else {
				return true;
			}
		}
		
		return false;
		
	}
}
