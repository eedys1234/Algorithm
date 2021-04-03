package KakaoCommerce;

import java.util.ArrayList;
import java.util.List;

public class P02 {

	public static List<Integer> robot = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		
		int[][] needs = {
			{1, 0, 0}, 
			{1, 1, 0}, 
			{1, 1, 0}, 
			{1, 0, 1}, 
			{1, 1, 0}, 
			{0, 1, 1}
		};
		
		int r = 2;
		
		int answer = solution(needs, r);
		System.out.println(answer);
		
	}
	
    public static int solution(int[][] needs, int r) {
        
    	int answer = 0;
    	int cnt = 0;
    	List<Integer> store = new ArrayList<>();
        boolean[] comb = new boolean[needs[0].length];

        //bit 연산을 통해 Map에 저장
    	
//		{1, 0, 0}, 1
//		{1, 1, 0}, 3
//		{1, 1, 0}, 3
//		{1, 0, 1}, 5
//		{1, 1, 0}, 3
//		{0, 1, 1}  6
    	
    	for(int i=0;i<needs.length;i++) 
    	{
    		int sum = 0;
    		for(int j=0;j<needs[0].length;j++) 
    		{
    			if(needs[i][j] == 1) {
    				sum += 1 << j;
    			}
    		}
    		
    		store.add(sum);
    	}
    	
    	
    	combination(comb, r, 0);
    	
//      r = 2 -> 110, 101, 011 조합
//    	--> 3, 5, 6
    	for(int i=0;i<robot.size();i++) 
    	{
    		cnt = 0;
    		for(int j=0;j<store.size();j++) {
    			
    			if((robot.get(i) & store.get(j)) == store.get(j)) {
    				cnt++;
    			}
    		}
    		
    		answer = Math.max(answer, cnt);    		
    	}
    	
        
        return answer;
    }
    
    public static void combination(boolean[] comb, int r, int start) {
    	
    	if(r == 0) {
    		int sum = 0;
    		for(int i=0;i<comb.length;i++) 
    		{
    			if(comb[i]) {
    				sum += 1 << i;
    			}
    		}
    		
    		robot.add(sum);
    	}
    	
    	for(int i=start;i<comb.length;i++) {
    		
    		if(!comb[i]) {
    			comb[i] = true;
    			combination(comb, r-1, i+1);
    			comb[i] = false;
    		}
    	}
    }
}
