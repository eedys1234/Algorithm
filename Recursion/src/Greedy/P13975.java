package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P13975 {

public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

		try {
			 String line = inbr.readLine();
			 
			 int t = Integer.valueOf(line);
			 int k = 1;
			 while(k<=t) {
				 line = inbr.readLine();
				 int n = Integer.valueOf(line);
				 long[] value = new long[n+1];
				 String[] temp = inbr.readLine().split(" ");
				 for(int i=0;i<temp.length;i++) {
					 value[i+1] = Integer.valueOf(temp[i]);
				 }
				 
				 long min = calculate(value);
				 System.out.println(min);
				 k++;
			 }
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static long calculate(long[] value) {
		
		PriorityQueue<Long> heap = new PriorityQueue<Long>();
		long result = 0;
		
		for(int i=1;i<value.length;i++) {
			heap.offer(value[i]);
		}
		
		while(heap.size()>1) {
			long n1 = heap.poll();
			long n2 = heap.poll();
			
			long n = n1+n2;
			result += n;
			heap.offer(n);
			
		}
	
		return result;
	}
}
