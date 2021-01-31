package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1645 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

		try {
			 String line = inbr.readLine();
			 String[] temp = line.split(" ");
			 
			 int k = Integer.valueOf(temp[0]);
			 int n = Integer.valueOf(temp[1]);
			 int[] lan = new int[k];
			 
			 for(int i=0;i<k;i++) {
				 line = inbr.readLine();
				 lan[i] = Integer.valueOf(line);
			 }

			 long mid = 0;
			 long start = 0;
			 long end = 0;
			 long result = 0;
			 			 
			 end = lan[0];

			 while(start <= end) {

				mid = (start+end)/2;

				if(mid == 0)
				{
					break;
				}
				for(int i=lan.length-1;i>=0;i--) 
				{
					result+=lan[i]/mid; 
				}	
				
				if(result >= n) {
					start = mid+1;
				}		
				else {
					end = mid-1;
				}
				
				result = 0;
			 }
			 
			 System.out.println(end);
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
