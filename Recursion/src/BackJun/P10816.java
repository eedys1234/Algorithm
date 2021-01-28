package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10816 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] value = new int[n];
			
			String[] temp = inbr.readLine().split(" ");

			for(int i=0;i<n;i++) {
				value[i] = Integer.valueOf(temp[i]);
			}
			
			int m = Integer.valueOf(inbr.readLine());
			int[] target = new int[m];

			temp = inbr.readLine().split(" ");

			for(int i=0;i<m;i++) {
				target[i] = Integer.valueOf(temp[i]);
			}

			Arrays.sort(value);
			for(int i=0;i<target.length;i++) {
				int lowerIdx = lowerBound(value, 0, value.length, target[i]);
				int upperIdx = upperBound(value, 0, value.length, target[i]);
				
				sb.append(upperIdx-lowerIdx);
				sb.append(" ");
			}
			
			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int lowerBound(int[] value, int left, int right, int target) {
		
		int mid = 0;
		
		while(left < right) {
			
			mid = (left+right)/2;
			if(value[mid] < target) {	
				left = mid+1;
			}
			else if(value[mid] >= target){
				right = mid;
			}
		}
		
		return right;
	}
	
	public static int upperBound(int[] value, int left, int right, int target) {
		
		int mid = 0;
		
		while(left < right) {

			mid = (left+right)/2;
			if(value[mid] <= target) {	
				left = mid+1;
			}
			else if(value[mid] > target){
				right = mid;
			}
		}
		
		return right;
	}

}
