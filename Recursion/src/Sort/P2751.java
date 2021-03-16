package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2751 {
	
	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] value = new int[n];
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<n;i++) {
				value[i] = Integer.valueOf(inbr.readLine());				
			}
			
			mergeSort(value, 0, value.length-1);
			
			for(int i=0;i<n;i++) {
				sb.append(value[i]);
				sb.append("\n");
			}
						
			System.out.println(sb.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void mergeSort(int[] value, int left, int right) {
		
		if(left < right) {
			
			int mid = (left+right)/2;
			mergeSort(value, left, mid);
			mergeSort(value, mid+1, right);
			merge(value, left, mid, right);
		}		
	}
	
	public static void merge(int[] value, int left, int mid, int right) {
		
		int i = left;
		int j = mid+1;
		int k = 0;
		int m = left;
		
		int[] temp = new int[right - left + 1];
		
		while(i<=mid && j<=right) {
			if(value[i]<value[j]) {
				temp[k++] = value[i++];				
			}
			else {
				temp[k++] = value[j++];
			}
		}
		
		while(i<=mid) {
			temp[k++] = value[i++];
		}
		
		while(j<=right) {
			temp[k++] = value[j++];
		}
		
		for(int l=0;l<k;l++) {
			value[m++] = temp[l];
		}
	}
}
