package KakaoCommerce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P03 {

	public static void main(String[] args) throws Exception {

		int n = 7;
		int[] passenger = {
			1, 1, 1, 1, 1, 1
		};
		int[][] train = {
			{1, 2}, 
			{1, 3}, 
			{1, 4}, 
			{3, 5}, 
			{3, 6}	
		};
		
		int[] answer = solution(n, passenger, train);
		System.out.println(answer[0] + " " + answer[1]);
	}
	
    public static int[] solution(int n, int[] passenger, int[][] train) {
        
    	int[] answer = new int[2];
    	int start = 1;
    	int person = 0;
    	boolean[] visited = new boolean[n];
    	Queue<Node> queue = new LinkedList<Node>();
    	List<List<Integer>> adj = new ArrayList<>();
    	
    	for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
    	}
    	
    	for(int i=0;i<train.length;i++) 
    	{    		
			int s = train[i][0];
			int d = train[i][1];
			
			adj.get(s-1).add(d);
    	}
    	
    	
    	queue.offer(new Node(start, passenger[start-1]));
    	
    	while(!queue.isEmpty()) {
    		
    		Node node = queue.poll();
    		int num = node.getNum();
    		person= node.getPassenger();
    		
    		if(answer[1] <= person) {
    			
    			if(answer[1] == person && answer[0] > num) {
        			answer[1] = person;    			    				
    			}
    			else {    				
        			answer[1] = person;    			
        			answer[0] = num;
    			}
    		}
    		
    		for(int j=0;j<adj.get(num-1).size();j++) {
    			
    			int next = adj.get(num-1).get(j);
    			
    			if(!visited[next-1]) {    				
    				visited[next-1] = true;
    				queue.offer(new Node(next, person + passenger[next-1]));
    			}
    		}
    	}
        
        return answer;
    }
    
    public static class Node {
    	
    	private int num;
    	private int passenger;
    	
    	public Node(int num, int passenger) {
    		this.num = num;
    		this.passenger = passenger;
    	}

		public int getNum() {
			return num;
		}

		public int getPassenger() {
			return passenger;
		}	
    }
}
