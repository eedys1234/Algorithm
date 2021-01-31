package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P14003 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();

		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] sequence = new int[n+1];
			int[] lis = new int[n+1];
			int[] path = new int[n+1];
			
			int count = 0;
			int l=0;
			String[] temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++) {
				sequence[i+1] = Integer.valueOf(temp[i]);
			}
			
			int j = 0;
			if(n>=1) {
				lis[1] = sequence[1];
				path[1] = 1;
				j = 1;				
				l = 1;
			}
			
			for(int i=2;i<sequence.length;i++) {
				
				if(lis[j] < sequence[i]) {
					j+=1;
					lis[j] = sequence[i];
					path[i] = j;
				}
				else {
					int idx = binarySearch(lis, 1, j, sequence[i]);
					lis[idx] = sequence[i];

					path[i] = idx;
				}
			}
			
			count = j;
			System.out.println(count);
						
			for(int i=path.length-1;i>=1;i--) {
				if(count==path[i]) {
					stack.push(sequence[i]);
					count--;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
				sb.append(" ");
			}

			System.out.print(sb.toString().substring(0, sb.toString().length()-1));

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
