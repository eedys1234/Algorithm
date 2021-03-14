package LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P2568 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] lis = new int[n+1];
			int[] path = new int[n+1];
			int[][] wire = new int[n+1][2];
			int j = 1;
			StringBuilder sb = new StringBuilder();
			Stack<Integer> stack = new Stack<Integer>();
			
			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");
				wire[i+1][0] = Integer.valueOf(temp[0]);
				wire[i+1][1] = Integer.valueOf(temp[1]);
			}
						
			//quick sort
			quickSort(wire, 1, wire.length-1);
			

			if(n>=2) {
				lis[1] = wire[1][1];	
				path[1] = j;
			}
			
			for(int i=2;i<wire.length;i++) {
				if(lis[j] < wire[i][1]) {
					j++;
					lis[j] = wire[i][1];
					path[i] = j;
				}
				else {
					int idx = binarySearch(lis, 1, j, wire[i][1]);
					lis[idx] = wire[i][1];
					path[i] = idx;
				}
			}
			
			sb.append(n-j).append("\n");
			int cnt = j;

			for(int i=path.length-1;i>=1;i--) {
				if(path[i] == cnt) {
					cnt--;
				}
				else {
					stack.push(wire[i][0]);
				}
			}
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop()).append("\n");
			}
			
			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int binarySearch(int[] wire, int left, int right, int target) {

		int mid = 0;
		
		while(left < right) 
		{
			mid = (left + right)/2;
			
			if(wire[mid] >= target) {
				right = mid;
			}
			else {
				left = mid+1;
			}
		}
		
		return right;
	}
	
	public static void quickSort(int[][] wire, int left, int right) {
		
		if(left < right) {
			int mid = (left + right)/2;
			int pivot = partition(wire, left, right, mid);
			quickSort(wire, left, pivot-1);
			quickSort(wire, pivot+1, right);
		}
	}
	
	public static int partition(int[][] wire, int left, int right, int mid) {
		
		int r = wire[right][0];
		int j = left;
				
		for(int i=left;i<right;i++) {
			if(wire[i][0] < r) {
				swap(wire, i, j);
				j++;
			}
		}
		
		//j <--> right;
		swap(wire, j, right);
		right = j;
		return right;
	}
	
	public static void swap(int[][] wire, int i, int j) {
		
		int temp = wire[i][0];
		wire[i][0] = wire[j][0];
		wire[j][0] = temp;
		temp = wire[i][1];
		wire[i][1] = wire[j][1];
		wire[j][1] = temp;
	}
}
