package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

//조합을 이용한 브루트포스
//조합은 백트래킹으로 구현
public class P0317 {
	
	public static HashMap<Integer, Integer> maxLengthStore;
	public static Map<Integer, HashMap<String, Integer>> store;
	
	public static void main(String[] args) {
		
		String[] orders = {
			"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
		};
		
		int[] course = {
			2,3,4
		};
		
		String[] answer = solution(orders, course);
		
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static String[] solution(String[] orders, int[] course) {
		
		String[] answer;
		store = new HashMap<>();
		maxLengthStore = new HashMap<>();
		List<String> ansList = new ArrayList<>();

		for(int i=0;i<orders.length;i++)  
		{
			char[] order = orders[i].toCharArray();
			boolean[] visited = new boolean[order.length];
			Arrays.sort(order);

			//메뉴가 2개 이상인 조합을 구함
			for(int j=2;j<=order.length;j++) 
			{
				if(!store.containsKey(j)) {
					store.put(j, new HashMap<String, Integer>());
				}
				combination(order, visited, 0, j, j);
			}
		}
				
		for(int i=0;i<course.length;i++)
		{
			HashMap<String, Integer> map = store.get(course[i]);
			int max = maxLengthStore.get(course[i]);
			for(Entry<String, Integer> entry : map.entrySet()) {

				if(max >= 2 && entry.getValue() == max) {
					ansList.add(entry.getKey());
				}
			}
		}
		
		Collections.sort(ansList);
		answer = new String[ansList.size()];
		
		for(int i=0;i<ansList.size();i++) 
		{
			answer[i] = ansList.get(i);
		}
		
		return answer;
	}
	
	public static void combination(char[] order, boolean[] visited, int start,  int r, int j) {
		if(r == 0) {
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<visited.length;i++) 
			{
				if(visited[i]) sb.append(order[i]);
			}
			store.get(j).merge(sb.toString(), 1, (oldValue, newValue)->++oldValue);
			
			if(Objects.isNull(maxLengthStore.get(j))) {
				maxLengthStore.put(j, 0);
			}
			
			maxLengthStore.put(j, Math.max(maxLengthStore.get(j), store.get(j).get(sb.toString())));
		}
		
		for(int i=start;i<order.length;i++) 
		{
			visited[i] = true;
			combination(order, visited, i+1, r-1, j);
			visited[i] = false;
		}
	}
}
