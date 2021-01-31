package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2805 {

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

		try {			
			String line = inbr.readLine();
			
			String[] temp = line.split(" ");
			
			int m = Integer.valueOf(temp[0]);			
			int n = Integer.valueOf(temp[1]);
			
			int[] value = new int[m+1];
			
			line = inbr.readLine();
			
			temp = line.split(" ");
			
			for(int i=0;i<temp.length;i++) 
			{
				value[i+1] = Integer.valueOf(temp[i]);
			}
			
			Arrays.sort(value);
			
			long start = 0;
			long mid = 0;
			long end = value[value.length-1];
			long result = 0;
						
			while(start <= end) {
				
				mid = (start + end)/2;
				
				for(int i=1;i<value.length;i++)
				{
					long diff = (value[i]-mid) < 0 ? 0 : (value[i]-mid);
					result += diff;
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
