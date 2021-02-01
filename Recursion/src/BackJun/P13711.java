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
			int[] orderX = new int[t+1];
			int[] orderY = new int[t+1];
			
			int[] lis_x = new int[t+1];
						
			line = inbr.readLine();
			String[] temp = line.split(" ");
			
			for(int i=0;i<temp.length;i++) {
				x[i+1] = Integer.valueOf(temp[i]);
			}

			line = inbr.readLine();
			temp = line.split(" ");

			for(int i=0;i<temp.length;i++) {
				y[i+1] = Integer.valueOf(temp[i]);
			}
			
			for(int i=1;i<x.length;i++) {
				orderX[x[i]] = i;
			}

			for(int i=1;i<y.length;i++) {
				orderY[orderX[y[i]]] = i;
			}
			
			
			
			lis_x[1] = x[1];
			int j=1;
									
			for(int i=2;i<x.length;i++) {
				
				if(lis_x[j] < x[y[i]]) {
					j++;
					lis_x[j] = x[y[i]];
				}
				else {
					int idx = binarySearch(lis_x, 1, j, x[y[i]]);
					lis_x[idx] = x[y[i]];
				}
			}
			
			System.out.println(j);
			
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
	
	public static void mergeSort(int[][] value, int left, int right, int col) {
		
		int mid = 0;
		
		if(left < right) {
			
			mid = (left + right)/2;
			
			mergeSort(value, left, mid, col);
			mergeSort(value, mid+1, right, col);
			merge(value, left, mid, right, col);
		}
	}
	
	public static void merge(int[][] value, int left, int mid, int right, int col) {
		
		int i = left;
		int j = mid+1;
		int k = 0;
		
		int[][] temp = new int[right - left + 1][2];
		
		while(i<=mid && j<= right) {
			
			if(value[i][col] < value[j][col]) {
				temp[k][0] = value[i][0];
				temp[k++][1] = value[i++][1];
			}
			else {
				temp[k][0] = value[j][0];
				temp[k++][1] = value[j++][1];
			}
		}
		
		while(i<=mid) {
			temp[k][0] = value[i][0];
			temp[k++][1] = value[i++][1];			
		}
		
		while(j<=right) {
			temp[k][0] = value[j][0];
			temp[k++][1] = value[j++][1];			
		}
		
		for(int l=0;l<k;l++) {
			value[l+left][0] = temp[l][0];
			value[l+left][1] = temp[l][1];
		}
	}
}
