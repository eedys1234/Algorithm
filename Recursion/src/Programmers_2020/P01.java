package Programmers_2020;

public class P01 {

	public static void main(String[] args) {
		
		String[] s = {
			"aabbaccc",
			"ababcdcdababcdcd",
			"abcabcdede",
			"abcabcabcabcdededededede",
			"xababcdcdababcdcd"
		};
		
		for(int i=0;i<s.length;i++) {
			System.out.println(solution(s[i]));
		}
	}
	
	
    public static int solution(String s) {
        int answer = 0;
        int digit = s.length()/2;
        int cnt = 0;
        String compress = s;
        StringBuilder sb = new StringBuilder();
        
        for(int i=1;i<=digit;i++) 
        {
    		cnt = 1;
    		String ch = s.substring(0, i);	

        	for(int j=i;j<s.length();j+=i)
        	{
        		String value = s.substring(j, Math.min(j+i, s.length()));
        		if(ch.equals(value)) {
        			cnt++;
        		}
        		else {
        			if(cnt > 1) {
            			sb.append(cnt).append(ch);        				
        			}
        			else {
        				sb.append(ch);
        			}
        			ch = value;
        			cnt = 1;
        		}
        	}
        	
			if(cnt > 1) {
    			sb.append(cnt).append(ch);        				
			}
			else {
				sb.append(ch);
			}
			
        	if(compress.length() > sb.toString().length()) {
        		compress= sb.toString();
        	}
    		sb = new StringBuilder();
        }
        
        answer = compress.length();
        return answer;
    }
}
