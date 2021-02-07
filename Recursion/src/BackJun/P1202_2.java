package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1202_2 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int k = Integer.valueOf(temp[1]);
			long sum = 0;
			
			int[][] jewelry = new int[n][2];
			//0 무게, 1 가치
			int[][] bag = new int[k][2];
			
			for(int i=0;i<n;i++) {
				temp = inbr.readLine().split(" ");
				jewelry[i][0] = Integer.valueOf(temp[0]);
				jewelry[i][1] = Integer.valueOf(temp[1]);				
			}
			
			for(int i=0;i<k;i++) {
				bag[i][0] = Integer.valueOf(inbr.readLine());
			}
			
			//sorting
			mergeSort(bag, 0, bag.length-1, 0, 0);
			mergeSort(jewelry, 0, jewelry.length-1, 1, 1);
			
			System.out.println(search(jewelry, bag));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static long search(int[][] jewelry, int[][] bag) {
	
		long res = 0;
		int idx = 0;
		int k = 0;

		for(int i=0;i<jewelry.length;i++) {
			idx = lowerBound(bag, 0, bag.length-1, jewelry[i][0]);

			if(k < bag.length) {
				while(bag[idx][1] != 0 && idx < bag.length-1) {
					idx++;
				}
				res += jewelry[i][1];
				bag[idx][1] = jewelry[i][1];					
				k++;
			}
		}
		return res;
	}
	
	public static int lowerBound(int[][] bag, int left, int right, int target) {
		
		int mid = 0;
		
		while(left < right) {
			mid = (left + right)/2;
			
			if(bag[mid][0] <= target) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		
		return right;
		
	}
	
	
	public static void mergeSort(int[][] jewelry, int left, int right, int col, int order) {
		
		if(left < right) {
			
			int mid = (left + right)/2;
			
			mergeSort(jewelry, left, mid, col, order);
			mergeSort(jewelry, mid+1, right, col, order);
			merge(jewelry, left, mid, right, col, order);
		}
	}
	
	public static void merge(int[][] jewelry, int left, int mid, int right, int col, int order) {
		
		int i = left;
		int j = mid+1;
		int k = 0;
		
		int[][] temp = new int[right-left+1][2];
		
		while(i<=mid && j<=right) {
			
			if(order == 0) {
				if(jewelry[i][col] < jewelry[j][col]) {
					temp[k][0] = jewelry[i][0];
					temp[k++][1] = jewelry[i++][1];				
				}
				else {
					temp[k][0] = jewelry[j][0];
					temp[k++][1] = jewelry[j++][1];								
				}				
			}
			else {
				if(jewelry[i][col] > jewelry[j][col]) {
					temp[k][0] = jewelry[i][0];
					temp[k++][1] = jewelry[i++][1];				
				}
				else {
					temp[k][0] = jewelry[j][0];
					temp[k++][1] = jewelry[j++][1];								
				}				
			}
		}
		
		while(i<=mid) {
			
			temp[k][0] = jewelry[i][0];
			temp[k++][1] = jewelry[i++][1];				
		}

		while(j<=right) {
			
			temp[k][0] = jewelry[j][0];
			temp[k++][1] = jewelry[j++][1];				
		}
		
		for(int l=0;l<k;l++) {
			jewelry[left+l][0] = temp[l][0];
			jewelry[left+l][1] = temp[l][1];			
		}
	}
	
}
