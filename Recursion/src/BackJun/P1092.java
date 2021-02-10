package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P1092 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int result = 0;
			int n = Integer.valueOf(inbr.readLine());
			List<Integer> crane = new ArrayList<>(n);
			boolean allMoved = false;
			String[] temp = inbr.readLine().split(" ");
			
			for(int i=0;i<n;i++) 
			{
				crane.add(Integer.valueOf(temp[i]));
			}
			
			int m = Integer.valueOf(inbr.readLine());
			List<Integer> box = new ArrayList<>();
			boolean[] moved = new boolean[m];
			
			temp = inbr.readLine().split(" ");

			for(int i=0;i<m;i++) 
			{
				box.add(Integer.valueOf(temp[i]));
			}						
			
			Collections.sort(crane, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o2, o1);
				}
			});
			
			Collections.sort(box, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o2, o1);
				}
				
			});
						
			if(crane.get(0) < box.get(0)) {
				System.out.println("-1");
				return ;
			}
			
			int i = 0;
			int j = 0;
			
			while(box.size() > 0) {
				
				while(i<crane.size()) 
				{	
					if(j >= box.size()) break;
					
					if(crane.get(i) >= box.get(j)) {
						i++;
						box.remove(j);
					}
					else {
						j++;																									
					}					
				}

				i=0;
				j=0;
				result++;				
			}
			
			System.out.println(result);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
