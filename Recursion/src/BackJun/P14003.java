package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14003 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] sequence = new int[n+1];
			int[] lis = new int[n+1];
			String[] path = new String[n+1];
			StringBuilder sb = new StringBuilder();
			
			int count = 0;
			int max = 0;
			int l=0;
			String[] temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++) {
				sequence[i+1] = Integer.valueOf(temp[i]);
			}
			
			int j = 0;
			if(n>=1) {
				lis[1] = sequence[1];
				path[1] = sequence[1] + " "; 
				j = 1;				
			}
			
			for(int i=2;i<sequence.length;i++) {
				
				if(lis[j] < sequence[i]) {
					j+=1;
					lis[j] = sequence[i];
					
					sb.append(path[j]);
					sb.append(sequence[i]);
					sb.append(" ");
				}
				else {
					int idx = binarySearch(lis, 1, j, sequence[i]);
					lis[idx] = sequence[i];
					
					for(int k=1;k<=idx;k++) {
						sb.append(path[i]);
						sb.append(lis[k]);
						sb.append(" ");
					}
				}
				path[i] = sb.toString();
				sb.delete(0, sb.length());
				
				if(max < path[i].split(" ").length) {
					l = i;
				}

			}
			
			count = j;
			System.out.println(count);
			System.out.println(path[l].substring(0, path[l].length()-1));


		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int binarySearch(int[] lis, int start, int end, int target) {
		
		int mid = 0;
		
		while(start < end) {
			mid = (start + end)/2;
			
			if(lis[mid] >= target) {
				end = mid;
			}
			else {
				start = mid+1;
			}
		}
		
		return end;
	}
	
	
} 
