package Programmers_0415;

public class P02 {
	
	public static void main(String[] args) throws Exception {
		
		System.out.println(solution("[](){}"));
		System.out.println(solution("}]()[{"));
		System.out.println(solution("[)(]"));
		System.out.println(solution("}}}"));
		System.out.println(solution("["));
	}
	
    public static int solution(String s) {
        int answer = 0;        
        int len = s.length();
        int[] cnt = new int[3];
        boolean isBracket = true;
        
        if(len%2 == 1) {
        	return 0;
        }
        for(int i=0;i<len;i++) 
        {
        	isBracket = true;
        	cnt[0] = cnt[1] = cnt[2] = 0;
            for(int j=i,k=0;k<len;j=(j+1)%len,k++) 
            {
            	char ch = s.charAt(j);
            	
            	switch(ch) {
            		case '(' : {
            			cnt[0]++;
            			break; 
            		}
            		case ')' : {
            			cnt[0]--;            			
            			break; 
            		}
            		case '[' : {
            			cnt[1]++;            			            			
            			break; 
            		}
            		case ']' : {
            			cnt[1]--;            			            			            			
            			break; 
            		}
            		case '{' : {
            			cnt[2]++;            			            			            			            			
            			break; 
            		}
            		case '}' : {
            			cnt[2]--;            			            			            			            			            			
            			break; 
            		}
            		default : {
            			break;
            		}
            	}
            	
            	for(int l=0;l<cnt.length;l++) {            		
                	if(cnt[l] < 0) {
                		isBracket = false;
            			break;
                	}  
            	}
            }
        	
            if(isBracket) {
            	answer++;
            }
        }
        
        return answer;
    }
}
