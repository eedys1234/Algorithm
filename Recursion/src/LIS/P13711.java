package LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//LIS
public class P13711 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] x = new int[n+1];
			int[] y = new int[n+1];
			int[] lis = new int[n+1];
			
			String[] temp = inbr.readLine().split(" ");

			for(int i=0;i<temp.length;i++) {
				x[i+1] = Integer.valueOf(temp[i]);
			}

			temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++) {
				y[Integer.valueOf(temp[i])] = i+1;
			}
			
			lis[1] = y[x[1]];
			int j = 1; 

			for(int i=2;i<y.length;i++) {
				
				if(lis[j] < y[x[i]]) {
					j+=1;
					lis[j] = y[x[i]];
				}
				else {
					int idx = binarySearch(lis, 0, j, y[x[i]]);
					lis[idx] = y[x[i]];
				}				
			}
			int cnt = j;
			System.out.println(cnt);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int binarySearch(int[] lis, int left, int right, int target) {

		int mid = 0;

		while(left < right) {
			mid = (left + right)/2;
			
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
