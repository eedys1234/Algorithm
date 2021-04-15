package Programmers_0415;

import java.util.ArrayList;
import java.util.List;

public class P03 {

	public static void main(String[] args) throws Exception {
		
		int[] a = {
			-5, 0, 2, 1, 2	
		};
		
		int[][] edges = {
			{0, 1}, {3, 4}, {2, 3}, {0, 3}
		};
		
		System.out.println(solution(a, edges));
		
	}
	
    public static long solution(int[] a, int[][] edges) {
        long answer = 0;                
        List<List<Integer>> adj = new ArrayList<>();
        int sum = 0;
        
        for(int i=0;i<a.length;i++) 
        {
        	sum += a[i];
        	adj.add(new ArrayList<>());
        }   
        
        if(sum != 0) {
        	return -1;
        }
        
        for(int i=0;i<edges.length;i++) 
        {
    		adj.get(edges[i][0]).add(edges[i][1]);
    		adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        for(int i=0;i<adj.size();i++) 
        {
        	for(int j=0;j<adj.get(i).size();j++)
        	{	
        		int start = i;
            	int end = adj.get(i).get(j);        		
            	
        	}
        }
        
        return answer;
    }
        
}
