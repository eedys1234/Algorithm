package LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//LIS
public class P2352 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
//			6
//			4 2 6 3 1 5
			
			int n = Integer.valueOf(inbr.readLine());
			int[] conductor = new int[n+1];
			int[] lis = new int[n+1];
			int j = 1;
			String[] temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++) {
				conductor[i+1] = Integer.valueOf(temp[i]);
			}
			
			if(n>=2) {
				lis[1] = conductor[1];
			}
			
			for(int i=2;i<conductor.length;i++) {
				
				if(lis[j] < conductor[i]) {
					j+=1;
					lis[j] = conductor[i];
				}
				else {
					int idx = binarySearch(lis, 0, j, conductor[i]);
					lis[idx] = conductor[i];
				}
			}
			
			int count = j;
			System.out.println(count);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int binarySearch(int[] lis, int left, int right, int target) {
		
		int mid = 0;
		while(left < right) {
			mid = (left+right)/2;
			
			if(lis[mid] >= target) {
				right = mid;
			}
			else {
				left = mid+1;
			}
		}
		
		return right;
	}
}
