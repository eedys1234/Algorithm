package Programmers_0415;

public class P01 {
	
	public static void main(String[] args) throws Exception {
		
	}
	
	public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0;i<absolutes.length;i++) {
            if(signs[i]) {
                answer += absolutes[i];
            }
            else {
            	answer -= absolutes[i];
            }
        }
        
        return answer;
    }
}
