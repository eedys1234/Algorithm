package Programmers_2021;

import java.util.ArrayList;
import java.util.List;

public class P07 {

	public static int[][] dp;
	
	//DP 트리에서 동적프로그래밍
	public static void main(String[] args) {
		
		int[][] sales = {
			{14, 17, 15, 18, 1, 14, 13, 16, 1, 17},
			{5, 6, 5, 3, 4},
			{5, 6, 5, 1, 4},
			{10, 10, 1, 1}
		};
		
		int[][][] links = {
			{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}},
			{{2,3}, {1,4}, {2,5}, {1,2}},
			{{2,3}, {1,4}, {2,5}, {1,2}},
			{{3,2}, {4,3}, {1,4}}
		};


	}
	
    public static int solution(int[] sales, int[][] links) {
        int answer = 0;
        List<List<Integer>> adj1 = new ArrayList<>();        
        List<List<Integer>> adj2 = new ArrayList<>();
        dp = new int[sales.length][2];
        
        for(int i=0;i<sales.length;i++) {
        	adj1.add(new ArrayList<>());
        	adj2.add(new ArrayList<>());
        }
        
        for(int[] c : links) {
        	int parent = c[0];
        	int child = c[1];
        	
        	adj1.get(parent-1).add(child); 	
        }
        
        for(int i=0;i<dp.length;i++) 
        {
        	for(int j=0;j<dp[0].length;j++)
        	{
        		dp[i][j] = -1;
        	}
        }
                
        answer = Math.min(solve(1, adj1, 1, sales), solve(1, adj1, 0, sales));
        return answer;
    }
    
    
   public static int solve(int root, List<List<Integer>> adj, int attend, int[] sales) {
	   
	   if(adj.get(root-1).size() == 0) {
		   
		   if(attend == 1) {
			   return sales[root-1];
		   }
		   
		   return 0;
	   }
	   
	   int res = dp[root-1][attend];
	   if(res > 0) return res;
	   
	   
	   if(attend == 1) {
		   res = sales[root-1];
		   for(int next : adj.get(root-1)) {
			   res += Math.min(solve(next, adj, 0, sales), solve(next, adj, 1, sales));
		   }
		  		   
	   }
	   else {
		   res = 0;
		   boolean isAttend = false;
		   int min = Integer.MAX_VALUE;
		   //팀장이 0이면 팀원들 중 최소 한명은 1이여야함
		   //어떤 값이 1이었을때 나머지가 0

		   for(int next : adj.get(root-1)) {
			   res += solve(next, adj, 0, sales);
		   }
		   
		   for(int next : adj.get(root-1)) {
			   int resultY = solve(next, adj, 1, sales);
			   int resultN = solve(next, adj, 0, sales);
			   
			   //참석하지 않다고 했었다가 참석으로 바꾸는 경우
			   if(resultY < resultN) {
				   isAttend = true;
				   res += resultY - resultN;
				   continue;
			   }
			   
			   if(min > resultY - resultN) {
				   min = resultY - resultN;
			   }
		   }		 
		   
		   //아무도 참석하지 않을경우 참석하지않은 팀원 중 제일 작은 팀원을 선택
		   if(!isAttend) {
			  res += min;
		   }
	   }
	   
	   dp[root-1][attend] = res;
	   return res;
   }
}
