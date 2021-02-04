package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class P13413 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			ArrayList<String> list = new ArrayList<>();
			ArrayList<Boolean> overlap = new ArrayList<>();
			Map<String, Integer> store = new HashMap<>();
			
			int n = Integer.valueOf(temp[0]);
			int k = Integer.valueOf(temp[1]);
			
			for(int i=0;i<k;i++) {
				String num = inbr.readLine();
				if(store.containsKey(num)) {
					int seq = store.get(num);					
					overlap.set(seq, true);
				}
				overlap.add(false);
				store.put(num, i);
				list.add(num);
			}
			
			for(int i=0,j=0;j<Math.min(n, k)&&i<list.size();i++) {
				if(!overlap.get(i)) {
					sb.append(list.get(i));
					sb.append("\n");					
					j++;
				}
			}
			
			System.out.println(sb.toString());

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
