package Bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PracticeTest {
	
	public static void main(String[] args) throws Exception {
		
		int[] answers = {
//			1, 2 ,3, 4, 5
			1, 3, 2, 4, 2
		};
		
		int[] answer = solution(answers);
		
		for(int i=0;i<answer.length;i++) 
		{
			System.out.print(answer[i] + " ");
		}
	}
	
    public static int[] solution(int[] answers) {
        
    	Map<Integer, Integer> store = new HashMap<>();        
        List<List<Integer>> mathematics = init();
        List<Integer> result = new ArrayList<>();
        
        init();
        
        for(int i=0;i<answers.length;i++) 
        {
        	for(int j=0;j<mathematics.size();j++)
        	{
        		int len = mathematics.get(j).size();
        		
        		if(answers[i] == mathematics.get(j).get(i % len)) {
        			store.merge(j+1, 1, (oldValue, newValue) -> ++oldValue);
        		}
        	}
        }

        List<Integer> answerList = new LinkedList<Integer>(store.keySet());
        
        Collections.sort(answerList, (Integer i1, Integer i2) -> { 
        	if(Integer.compare(store.get(i2), store.get(i1)) == 0) {
        		return Integer.compare(i1, i2);
        	}
        	return Integer.compare(store.get(i2), store.get(i1));
        });
        
        int maxKey = answerList.get(0);
        int maxValue = store.get(maxKey);
        int key = 0;
        int value = 0;
        
        result.add(maxKey);

        for(int i=1;i<answerList.size();i++) 
        {
        	key = answerList.get(i);
        	value = store.get(key);
 
        	if(maxValue <= value) {
        		result.add(key);
        	}

        }

        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++) 
        {
        	answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    public static List<List<Integer>> init() {
    	
        List<List<Integer>> mathematics = new ArrayList<>();

//		1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//		2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//		3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

        mathematics.add(Arrays.asList(1, 2, 3, 4, 5));
        mathematics.add(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
        mathematics.add(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
                
        return mathematics;
    }

}
