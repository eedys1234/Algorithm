package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class P1744 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			long result = 0;
			 
			int n = Integer.valueOf(inbr.readLine());			 
			List<Integer> sequence = new ArrayList<>(n);
			Queue<Integer> nQueue = new LinkedList<>();
			Queue<Integer> oneQueue = new LinkedList<>();
			Stack<Integer> pStack = new Stack<>();
			 
			for(int i=0;i<n;i++) 
			{
				sequence.add(Integer.valueOf(inbr.readLine()));
			}
			 
			List<Integer> sortedSequence = sequence.stream().sorted(new Comparator<Integer>() {
	
				@Override
				public int compare(Integer o1, Integer o2) {					
					return Integer.compare(o1, o2);
				}
			}).collect(Collectors.toList());
			 
			int i = 0;

			while(i < sortedSequence.size()) {
		
				int value = sortedSequence.get(i);
				
				if(value <= 0) {
					nQueue.offer(value);
				}
				else if(value == 1) {
					oneQueue.offer(value);
				}
				else {
					pStack.push(value);
				}
				i++;
			}
			
			int j = nQueue.size();
			while(!nQueue.isEmpty()) {
				if(j >= 2) {
					int x = nQueue.poll();
					int y = nQueue.poll();
					result += x*y;
					j-=2;
				}
				else {
					result += nQueue.poll();
				}
			}
			
			while(!oneQueue.isEmpty()) {
				result += oneQueue.poll();
			}
			
			j = pStack.size();
			while(!pStack.isEmpty()) {
				if(j >= 2) {
					int x = pStack.pop();
					int y = pStack.pop();;
					result += x*y;
					j-=2;
				}
				else {
					result += pStack.pop();
				}
			}
			 
			System.out.println(result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
