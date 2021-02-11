package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2262 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			
			String[] temp = inbr.readLine().split(" ");
			List<Integer> sequence = new ArrayList<>();
			int res = 0; 
			int diff = 0;

			for(int i=0;i<temp.length;i++) {
				sequence.add(Integer.valueOf(temp[i]));
			}
			
			
			int max = n;
			
			for(int i=0;i<n-1;i++) {
				
				int idx = sequence.indexOf(max);
				
				if(idx == 0) {
					diff = Math.abs(sequence.get(idx)-sequence.get(idx+1));
				}
				else if(idx == sequence.size()-1) {
					diff = Math.abs(sequence.get(idx-1)-sequence.get(idx));
				}
				else {
					diff = Math.min(Math.abs(sequence.get(idx-1)-sequence.get(idx)), Math.abs(sequence.get(idx)-sequence.get(idx+1)));
				}
				
				res += diff;
				sequence.remove(idx);
				max--;
			}
			
			System.out.println(res);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
