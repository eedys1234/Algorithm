package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14002 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] sequence = new int[n+1];
			int[] lis = new int[n+1];
			String[] path = new String[n+1];
			
			String[] temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++) {
				sequence[i+1] = Integer.valueOf(temp[i]);
			}
			
			for(int i=1;i<sequence.length;i++) 
			{
				lis[i] = 1;
				path[i] = String.valueOf(sequence[i]) + " ";
				
				for(int j=1;j<=i;j++) 
				{
					if(sequence[i] > sequence[j]) {
						if(lis[i] < lis[j]+1) {
							lis[i] = lis[j]+1;
							path[i] = path[j] + sequence[i] + " ";
						}
					}
				}
			}
			
			int max = 0;
			int k = 0;
			for(int i=1;i<lis.length;i++) {
				if(max < lis[i]) {
					max = lis[i];
					k = i;
				}
			}

			System.out.println(lis[k]);
			
			System.out.println(path[k].substring(0, path[k].length()-1));
			
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
