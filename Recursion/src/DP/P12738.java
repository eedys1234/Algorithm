package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P12738 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] sequence = new int[n+1];
			int[] lis = new int[n+1];
			int count = 0;
			String[] temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++) {
				sequence[i+1] = Integer.valueOf(temp[i]);
			}
			
			int j = 0;
			if(n>=1) {
				lis[1] = sequence[1];
				j = 1;				
			}
			
			for(int i=2;i<sequence.length;i++) {
				
				if(lis[j] < sequence[i]) {
					j+=1;
					lis[j] = sequence[i];
				}
				else {
					int idx = binarySearch(lis, 1, j, sequence[i]);
					lis[idx] = sequence[i];
				}
			}
			
			count = j;
			
			System.out.println(count);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int binarySearch(int[] lis, int start, int end, int target) {
		
		int mid = 0;
		
		while(start < end) {
			mid = (start + end)/2;
			
			if(lis[mid] >= target) {
				end = mid;
			}
			else {
				start = mid+1;
			}
		}
		
		return end;
	}
	
	
} 
