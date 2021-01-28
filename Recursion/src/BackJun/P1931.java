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
			int max = 0;
			int result = 0;

			for(int i=0;i<n;i++) {
				line = inbr.readLine();
				String[] temp = line.split(" ");				

				value[i][0] = Integer.valueOf(temp[0]);
				value[i][1] = Integer.valueOf(temp[1]);
				value[i][2] = value[i][1] - value[i][0];

			}			
						
			quickSort(value, 0, value.length-1, 1, 0);

			int diff = value[0][2];
			int offset = 0;
			int length = 0;

			for(int i=1;i<value.length;i++) 
			{
				if(diff == value[i][2]) {
					length++;
				}
				else {
					quickSort(value, offset, offset + length, 2, 0);	
					offset = i;
					diff = value[i][2];
					length = 0;
				}
			}
			
			int t = 0;
			for(int i=0;i<value.length;i++) {
				int start = value[i][0];
				int end = value[i][1];
				
				if(start>=t) {
					t = end;
					result++;
				}				
			}
			
			System.out.println(result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void quickSort(int[][] value, int left, int right, int col, int order) {
		
		
		if(left < right) {

			int pivot = partition(value, left, right, col, order);
			quickSort(value, left, pivot-1, col, order);
			quickSort(value, pivot+1, right, col, order);
			
		}
		
	}
	
	public static int partition(int[][] value, int left, int right, int col, int order) {
		
		int i = left-1;
		
		int r = value[right][col];
		
		for(int j=left;j<=right;j++) {

			if(order == 0)
			{
				if(value[j][col] < r) {
					i++;
					swap(value, i, j);
				}				
			}
			else {
				if(value[j][col] > r) {
					i++;
					swap(value, i, j);
				}
			}
		}
		
		swap(value, i+1, right);
		right = i+1;
		return right;
	}
	
	public static void swap(int[][] value, int i, int j) {
		
		for(int x=0;x<value[0].length;x++) {
			int temp = value[i][x];
			value[i][x] = value[j][x];
			value[j][x] = temp;			
		}
	}
}
