package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1931 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();

			int n = Integer.valueOf(line);
			int[][] value = new int[n][3];
			int result = 0;

			for(int i=0;i<n;i++) {
				line = inbr.readLine();
				String[] temp = line.split(" ");				

				value[i][0] = Integer.valueOf(temp[0]);
				value[i][1] = Integer.valueOf(temp[1]);
				value[i][2] = value[i][1] - value[i][0];

			}			
						
			mergeSort(value, 0, value.length-1, 1);

			int diff = value[0][1];
			int offset = 0;
			int length = 0;

			for(int i=1;i<value.length;i++) 
			{
				if(diff == value[i][1]) {
					length++;
				}
				else {
					mergeSort(value, offset, offset + length, 0);	
					offset = i;
					diff = value[i][1];
					length = 0;
				}
			}
			
			if(length > 0) {
				mergeSort(value, offset, offset + length, 0);					
			}
			int t = 0;
			for(int i=0;i<value.length;i++) {
				int start = value[i][0];
				int end = value[i][1];
				
				if(start >= t) {
					t = end;
					result++;
				}				
			}
			
			System.out.println(result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void mergeSort(int[][] value, int left, int right, int col) {
		
		if(left < right) {
			
			int mid = (left + right)/2;
			mergeSort(value, left, mid, col);
			mergeSort(value, mid+1, right, col);
			merge(value, left, mid, right, col);
		}
	}
	
	public static void merge(int[][] value, int left, int mid, int right, int col) {
		
		int i = left;
		int j = mid+1;
		int k = 0;
		int m = left;
		
		int[][] temp = new int[right-left+1][3];
		
		while(i<=mid && j<=right) {
			
			if(value[i][col] < value[j][col]) {
				temp[k][0] = value[i][0];
				temp[k][1] = value[i][1];
				temp[k++][2] = value[i++][2];
			}
			else {
				temp[k][0] = value[j][0];
				temp[k][1] = value[j][1];
				temp[k++][2] = value[j++][2];				
			}
		}
		
		while(i<=mid) {
			temp[k][0] = value[i][0];
			temp[k][1] = value[i][1];
			temp[k++][2] = value[i++][2];			
		}

		while(j<=right) {
			temp[k][0] = value[j][0];
			temp[k][1] = value[j][1];
			temp[k++][2] = value[j++][2];			
		}
		
		for(int l=0;l<temp.length;l++) {
			value[m][0] = temp[l][0];
			value[m][1] = temp[l][1];
			value[m++][2] = temp[l][2];
		}

	}
	
}
