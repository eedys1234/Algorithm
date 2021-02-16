package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2631 {

public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			int[] order = new int[n];
			int[] arr = new int[n];
			int[] path = new int[n];
			
			for(int i=0;i<n;i++) {
				order[i] = Integer.valueOf(inbr.readLine());
			}
			
			arr[0] = order[0];
			path[0] = 0;
			int j = 0;			
			
			for(int i=1;i<order.length;i++) {
				
				if(arr[j] < order[i]) {
					j++;
					arr[j] = order[i];					
					path[i] = j;
				}
				else {
					int idx = binarySearch(arr, 0, j, order[i]);
					arr[idx] = order[i];
					path[i] = idx;
				}
			}		
			
			System.out.println(n-(j+1));
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static int binarySearch(int[] arr, int left, int right, int target) {
		
		int mid = 0;
		
		while(left < right) {
			
			mid = (left+right)/2;
			
			if(arr[mid] < target) {
				left = mid+1;
			}
			else {
				right = mid;
			}
		}
		
		return right;
	}

}
