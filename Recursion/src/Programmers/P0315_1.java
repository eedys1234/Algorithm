package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

public class P0315_1 {
	
	public static Map<String, List<Integer>> store;
	
	public static void main(String[] args) {
		
		String[] info = {
			"java backend junior pizza 150",
			"python frontend senior chicken 210",
			"python frontend senior chicken 150",
			"cpp backend senior pizza 260",
			"java backend junior chicken 80",
			"python backend senior chicken 50"
		};
		
		String[] query = {
			"java and backend and junior and pizza 100",
			"python and frontend and senior and chicken 200",
			"cpp and - and senior and pizza 250",
			"- and backend and senior and - 150",
			"- and - and - and chicken 100",
			"- and - and - and - 150"
		};
		
		int[] ans = solution(info, query);
		
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
	}
	
	public static int[] solution(String[] info, String[] query) {
		
		int[] answer = new int[query.length];
		store = new HashMap<>();
			
		for(int i=0;i<info.length;i++) {
			String[] temp = info[i].split(" ");
			boolean[] include = new boolean[temp.length];
			powerSet(temp, include, 0);					
		}
		
		for(Entry<String, List<Integer>> entry : store.entrySet()) {
			Collections.sort(store.get(entry.getKey()));
		}
		
		for(int i=0;i<query.length;i++) {
			
			int idx = query[i].lastIndexOf(" ");
			int score = Integer.valueOf(query[i].substring(idx+1));
			String inString = query[i].substring(0, idx).replace("and", "").replace(" ", "").replace("-", "");
			
			List<Integer> scores = store.get(inString);
			
			if(!Objects.isNull(scores)) {
				int index = lowerBound(scores, 0, scores.size(), score);
				answer[i] = scores.size() - index;
			}
		}
		
		return answer;
	}
	
	public static void powerSet(String[] str, boolean[] include, int k) {
		
		if(k == str.length-1) {
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<str.length-1;i++) {
				if(include[i]) {
					sb.append(str[i]);
				}
			}

			settingValue(sb.toString(), Integer.valueOf(str[str.length-1]));
			return;
		}

		include[k] = false;
		powerSet(str, include, k+1);
		include[k] = true;
		powerSet(str, include, k+1);						
	}
	
	public static void settingValue(String inString, int score) {

		if(!store.containsKey(inString)) {
			List<Integer> list = new ArrayList<>();
			list.add(score);
			store.put(inString, list);
		}
		else {
			store.get(inString).add(score);
		}	
	}
	
	public static int lowerBound(List<Integer> scores, int left, int right, int target) {
		
		int mid = 0;

		while(left < right) {
			mid = (left+right)/2;
			
			if(scores.get(mid) >= target) {
				right = mid;
			}
			else {
				left = mid+1;
			}
		}

		return right;
	}
}
