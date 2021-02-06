package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class P1339 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			List<String> solves = new ArrayList<>();
			Map<String, Integer> weight = new HashMap<>();
			String[][] chs = new String[n][10];
			int result = 0;
			int value = 0;
			int k = 9;
			
			for(int i=0;i<n;i++) {
				solves.add(inbr.readLine());
			}
			
			//sorting
			Collections.sort(solves, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return Integer.compare(o2.length(), o1.length());
				}				
			});
			
			for(int i=0;i<chs.length;i++) 
			{
				String solve = solves.get(i);
				int length = solve.length();
				for(int j=0;j<length;j++) 
				{
					chs[i][length-j-1] = String.valueOf(solve.charAt(j));
				}
			}
			
			for(int i=0;i<chs.length;i++) {
				value = 1;
				int degree = 1;
				for(int j=0;j<chs[0].length;j++) {
					String ch = chs[i][j];
					
					if(!Objects.isNull(ch)) {
						if(weight.containsKey(ch)) {							
							value += weight.get(ch);
						}
						
						weight.put(ch, value);						
						degree *= 10;
						value = degree;
					}					
				}				
			}
			
			LinkedList<String> keyList = new LinkedList<String>(weight.keySet());
			Collections.sort(keyList, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return Integer.compare(weight.get(o2), weight.get(o1));
				}
			});
			
			for(int i=0;i<keyList.size();i++) {
				result += weight.get(keyList.get(i)) * k;
				k--;
			}

			System.out.println(result);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
