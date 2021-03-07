package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P1966 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int t = Integer.valueOf(inbr.readLine());
			
			while(t-->0) {
				String[] temp = inbr.readLine().split(" ");
				int n = Integer.valueOf(temp[0]);
				int idx = Integer.valueOf(temp[1]);
				int[] priority = new int[n];
				Queue<Document> queue = new LinkedList<>();
				boolean isPrint = true;
				int k=0;
				
				temp = inbr.readLine().split(" ");
				for(int i=0;i<temp.length;i++) {
					priority[i] = Integer.valueOf(temp[i]);
					queue.offer(new Document(priority[i], i));
				}
				
				
				while(!queue.isEmpty()) {

					isPrint = true;
					
					for(int j=0;j<priority.length;j++) {
						if(priority[j] == 0) continue;
						if(queue.peek().priority < priority[j]) {
							queue.offer(queue.poll());
							isPrint = false;
						}
					}
					
					if(isPrint) {
						int index = queue.poll().index;
						priority[index] = 0;
						k++;
						if(idx == index) {
							System.out.println(k);
							break;
						}
					}
					
				}
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Document {
		public int priority;
		public int index;
		
		public Document(int priority, int index) {
			this.priority = priority;
			this.index = index;
		}
	}
}
