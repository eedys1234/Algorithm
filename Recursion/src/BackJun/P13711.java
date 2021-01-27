package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P13711 {

	
	public static void main(String[] args) {
	
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String line = inbr.readLine();
			int t = Integer.valueOf(line);
			
			int[] x = new int[t+1];
			int[] y = new int[t+1];
			int[] lis_x = new int[t+1];
			int[] lis_y = new int[t+1];
						
			line = inbr.readLine();
			String[] temp = line.split(" ");
			
			for(int i=0;i<temp.length;i++) {
				x[i+1] = Integer.valueOf(temp[i]);
			}

			line = inbr.readLine();
			temp = line.split(" ");

			/*
			for(int i=0;i<temp.length;i++) {
				y[i+1] = Integer.valueOf(temp[i]);
			}
			*/
			
			for(int i=1;i<x.length;i++) {
				y[x[i]] = Integer.valueOf(temp[i-1]);
			}
			
			lis_x[1] = x[1];
			lis_y[1] = y[1];
			int i = 1;
			int j = 1;
			int k = 1;

			while(i<y.length) {
				
				/*
				if(lis_x[j] < x[i]) {
					lis_x[j+1] = x[i];
					j++;
				}
				else {
					int idx = binarySearch(lis_x, 1, j, x[i]);
					lis_x[idx] = x[i];
				}
				
				if(lis_y[k] < y[i]) {
					lis_y[k+1] = y[i];
					k++;
				}
				else {
					int idx = binarySearch(lis_y, 1, k, y[i]);
					lis_y[idx] = x[i];
				}
				*/
				
				if(lis_y[k] < y[i]) {
					lis_y[k+1] = y[i];
					k++;
				}
				else {
					int idx = binarySearch(lis_y, 1, k, y[i]);
					lis_y[idx] = x[i];
				}

				i++;
			}
						
			for(int l=1;l<lis_y.length;l++) {
				if(lis_y[l] != 0) {
					System.out.print(lis_y[l]+" ");					
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int binarySearch(int[] lis, int left, int right, int target) {

		int mid;
		
		while(left < right) {
			
			mid = (left + right)/2;
			
			if(lis[mid] < target) {
				left = mid+1;
			}
			else {
				right = mid;
			}
		}
		
		return right;
	}
}
