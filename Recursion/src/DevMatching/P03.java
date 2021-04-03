package DevMatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class P03 {


	public static void main(String[] args) throws Exception {
	
		String[] enroll = {
			"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"
		};
		
		String[] referral = {
			"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"
		};
		
		String[] seller = {
			"young", "john", "tod", "emily", "mary"
		};
		
		int[] amount = {
			12, 4, 2, 5, 10
		};
		
		int[] answer = solution(enroll, referral, seller, amount);

		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        List<List<Integer>> adj = new ArrayList<>();
        Map<String, Integer> store = new HashMap<>();
        Map<String, Integer> profit = new HashMap<>();
        
        for(int i=0;i<=enroll.length;i++) {
        	adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<enroll.length;i++) {
        	store.put(enroll[i], i+1);
        }        

        //0은 center        
//    	enroll[i], referral[i] 본인, 추천인 관계
        //자식에서 부모관계        
        for(int i=0;i<referral.length;i++) 
        {
        	if("-".equals(referral[i])) {
        		adj.get(i+1).add(0);
        	}
        	else {
        		adj.get(i+1).add(store.get(referral[i]));
        	}        	
        }

        
        for(int i=0;i<seller.length;i++) 
        {
        	int parent = adj.get(store.get(seller[i])).get(0);
        	int owner_benefit = (int) Math.round(amount[i] * 100 * 0.9);
        	int refer_benefit = (int) Math.round(amount[i] * 100 * 0.1);
        	profit.merge(seller[i], owner_benefit, (oldValue, newValue) -> oldValue + newValue);
        	
        	while(parent != 0) {        		
            	
            	owner_benefit = (int) Math.round(refer_benefit * 0.9);
            	refer_benefit = (int) Math.round(refer_benefit * 0.1); 
            	
            	profit.merge(enroll[parent-1], owner_benefit, (oldValue, newValue)-> oldValue+newValue);
            	parent = adj.get(parent).get(0);
        	}
        	
        	profit.put("center", refer_benefit);
        }
        
        for(int i=0;i<enroll.length;i++) {
        	if(!Objects.isNull(profit.get(enroll[i]))) {
        		answer[i] = profit.get(enroll[i]);
        	}
        }

        return answer;
    }
}
