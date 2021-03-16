package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P2812 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			Stack<Pair> stack = new Stack<>();
			Stack<Pair> queue = new Stack<>();
			
			String[] temp = inbr.readLine().split(" ");
			StringBuilder sb = new StringBuilder();
						
			int n = Integer.valueOf(temp[0]);
			int k = Integer.valueOf(temp[1]);
			
			String input = inbr.readLine();
			int[] num = new int[n];
			
			for(int i=0;i<input.length();i++) {
				num[i] = Integer.valueOf(String.valueOf(input.charAt(i)));
			}
			
			stack.push(new Pair(num[0], 0));
			
			int m = 0;

			for(int i=1;i<num.length;i++) {
								
				while(!stack.isEmpty() && m < k) {
					Pair pair = stack.peek();
					if(pair.value < num[i]) {
						stack.pop();
						m++;		
					}
					else {
						break;
					}
				}
				stack.push(new Pair(num[i], i));					
				
			}
			
			
			while(!stack.isEmpty()) {
				queue.push(stack.pop());
			}

			if(queue.size() > n-k) {
				int l = 0;
				while(l < n-k) {
					sb.append(queue.pop().value);				
					l++;
				}				
			}
			else {
				while(!queue.isEmpty()) {
					sb.append(queue.pop().value);				
				}				
			}
			
			System.out.println(sb.toString());
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Pair {
		int value;
		int index;
		
		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}		
		
	}
}
