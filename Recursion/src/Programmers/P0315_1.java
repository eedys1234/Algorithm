package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

//2021 KAKAO BLIND RECRUITMENT - 블라인드 순위검색
//실제 SQL 구문을 데이터 캐시에 저장할 때 SQL 구문의 길이가 제각각이기 때문에 해싱함수를 적용하여 고정된 길이로 만들어주며 이 문제도 동일한 방법으로 풀이
public class P0315_1 {
	
	//쿼리에 대한 조합을 저장할 Map 선언
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
			//재귀함수를 통해 Info에 대한 부분집합을 구함
			powerSet(temp, include, 0);					
		}
		
		//각 정보에 대한 부분집합에 해당되는 점수를 오름차순으로 정렬
		for(Entry<String, List<Integer>> entry : store.entrySet()) {
			Collections.sort(store.get(entry.getKey()));
		}
		
		for(int i=0;i<query.length;i++) {
			
			//조회 조건 convert
			int idx = query[i].lastIndexOf(" ");
			int score = Integer.valueOf(query[i].substring(idx+1));
			String inString = query[i].substring(0, idx).replace("and", "").replace(" ", "").replace("-", "");
			
			//조회 조건(점수 제외)에 맞는 점수 리스트 가져옴
			List<Integer> scores = store.get(inString);
			
			//1) lower bound를 이용해 특정 점수 이상에 해당하는 개수를 구함
			//전체개수 - 1)에서 구했던 개수를 통해 조건에 해당하는 개수를 구함
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
