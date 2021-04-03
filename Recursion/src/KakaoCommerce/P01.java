package KakaoCommerce;

public class P01 {

	public static void main(String[] args) throws Exception {
		
		int[] gift_cards = {
//			4, 5, 3, 2, 1
			5, 4, 5, 4, 5
		};
		
		int[] wants = {
//			2, 4, 4, 5, 1
			1, 2, 3, 5, 4
		};
		
		int answer = solution(gift_cards, wants);
		System.out.println(answer);
	}
	
    public static int solution(int[] gift_cards, int[] wants) {
        
    	int answer = 0;
    	boolean[] change = new boolean[gift_cards.length];
    	
    	for(int i=0;i<wants.length;i++) 
    	{    		
    		for(int j=0;j<gift_cards.length;j++) 
    		{
    			if(wants[i] == gift_cards[j]) {
    				
    				if(i != j && !change[j]) {
    					int t = gift_cards[i];
    					gift_cards[i] = gift_cards[j];
    					gift_cards[j] = t;
        				change[i] = true;
    				}
    				
    				if(i == j) {
        				change[i] = true;    					
    				}
    				
    				break;
    			}	
    		}
    		
    	}

    	for(int i=0;i<change.length;i++) {
    		if(!change[i]) {
    			answer++;
    		}
    	}
    	
        return answer;
    }
}
