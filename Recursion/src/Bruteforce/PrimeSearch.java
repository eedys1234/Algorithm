package Bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrimeSearch {
	
	public static boolean[] primes;
	public static boolean[] visited;
	public static Set<Integer> store;
	
	public static void main(String[] args) throws Exception {
		
		String numbers = "17";
		
		int result = solution(numbers);
		System.out.println(result);
	}
	
    public static int solution(String numbers) {
        int answer = 0;

        List<Integer> each_digit = new ArrayList<>();
        store = new HashSet<>();
        visited = new boolean[numbers.length()];
        
        for(int i=0;i<numbers.length();i++) {
        	each_digit.add(Integer.valueOf(numbers.charAt(i) - '0'));
        }
                
        Collections.sort(each_digit, Collections.reverseOrder());        
        int maxValue = Integer.valueOf(each_digit.stream().map(String::valueOf).collect(Collectors.joining()));

        primes = new boolean[maxValue + 1];
        Arrays.fill(primes, true);
        primes[1] = primes[0] = false;
        
        //maxValue까지 소수구하기
        isPrime(maxValue);
        
        //each_digit의 모든 경우의 수 구하기
        int len = numbers.length();
        
        for(int i=1;i<=len;i++) 
        {
        	int[] temp = new int[i];
        	combination(each_digit, temp, i, 0, i);
        	Arrays.fill(visited, false);        	
        }
        
        answer += store.stream().filter(value -> primes[value]).count();
                
        return answer;
    }
    
    public static void combination(List<Integer> each_digit, int[] temp, int r, int k, int end) {
    	
    	if(r == 0) {    		
    		StringBuilder sb = new StringBuilder();
    		
    		for(int i=0;i<temp.length;i++)
    		{
				sb.append(temp[i]);
    		}
    		
    		store.add(Integer.valueOf(sb.toString()));    	

    		return ;
    	}
    	
    	for(int i=0;i<each_digit.size();i++)
    	{    		
    		if(!visited[i]) {
        		visited[i] = true;
        		temp[k] = each_digit.get(i);
				combination(each_digit, temp, r-1, k+1, end);    			
				visited[i] = false;
    		}
    	}
    	
    }
    
    public static void isPrime(int maxValue) {
    	
    	for(int i=2;i*i<maxValue;i++)
    	{
    		if(!primes[i]) {
    			continue;
    		}
    		
    		for(int j=2*i;j<=maxValue;j+=i)
    		{
    			primes[j] = false;
    		}
    		
    	}
    }
}
