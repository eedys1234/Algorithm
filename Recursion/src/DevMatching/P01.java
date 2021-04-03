package DevMatching;

import java.util.HashMap;
import java.util.Map;

public class P01 {
	
	public static void main(String[] args) throws Exception {
			
		int[] lottos = {
			44, 1, 0, 0, 31, 25	
		};
		int[] win_nums = {
			31, 10, 45, 1, 6, 19	
		};
		
		int[] answer = solution(lottos, win_nums);
		
		System.out.println(answer[0] + " " + answer[1]);
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        //최저 : 0이 다 안맞는경우
        //최고 : 0이 다 맞는경우
        Map<Integer, Integer> store = new HashMap<>();
        int min = 0;
        int add = 0;
        
        for(int i=0;i<win_nums.length;i++) 
        {
        	store.merge(win_nums[i], 1, (oldValue, newValue) -> ++oldValue);
        }
        
        for(int i=0;i<lottos.length;i++) 
        {
        	if(store.containsKey(lottos[i])) {
        		min++;
        	}
        	
        	if(lottos[i] == 0) {
        		add++;
        	}
        }

        
        answer[0] = getScore(min+add);
        answer[1] = getScore(min);
        
        return answer;
    }
	
	public static int getScore(int cnt) {
		int score = 6;
		
		switch(cnt) {
			case 6 : {
				score = 1;
				break;
			}
			case 5 : {
				score = 2;
				break;
			}
			case 4 : {
				score = 3;
				break;
			}
			case 3 : {
				score = 4;
				break;
			}
			case 2 : {
				score = 5;
				break;
			}
			default : {
				break;
			}
		}
		
		return score;
	}
}
