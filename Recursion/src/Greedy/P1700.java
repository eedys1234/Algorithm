package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P1700 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			Map<Integer, Integer> tab = new HashMap<>();
			int n = Integer.valueOf(temp[0]);
			int k = Integer.valueOf(temp[1]);
			int[] order = new int[k];
			int res = 0;
			int idx = 0;
			int l = 0;
			
			temp = inbr.readLine().split(" ");
			
			for(int i=0;i<temp.length;i++) {
				order[i] = Integer.valueOf(temp[i]);
			}
			
			for(int i=0;i<order.length;i++) {

				if(idx < n) {
					if(!tab.containsKey(order[i])) {
						tab.put(order[i], k+1);						
						idx++;
					}
				}					
				else {
					if(!tab.containsKey(order[i])) {
						//꼽혀있는것중 가장 나중에 사용할 기기를 제거한다.
						l = order.length-1;

						while(i < l) {
							if(tab.containsKey(order[l])) {
								tab.put(order[l], l);
							}
							l--;
						}
						
						//정렬
						LinkedList<Integer> keySetList = new LinkedList<Integer>(tab.keySet());
						Collections.sort(keySetList, new Comparator<Integer>() {

							@Override
							public int compare(Integer o1, Integer o2) {
								return Integer.compare(tab.get(o2), tab.get(o1));
							}
						});
						
						tab.remove(keySetList.get(0));
						tab.put(order[i], k+1);
						res++;
					}
					else {
						tab.put(order[i], k+1);
					}
				}				
			}
			
			System.out.println(res);
					
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
