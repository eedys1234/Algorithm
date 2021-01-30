package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11399 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			
			int n = Integer.valueOf(line);
			int[] p = new int[n+1];
			int result = 0;
			
			line = inbr.readLine();
			String[] temp = line.split(" ");
						
			for(int i=0;i<temp.length;i++) 
			{
				p[i+1] = Integer.valueOf(temp[i]);
			}
			
			Arrays.sort(p);
			
			for(int i=0;i<p.length;i++) 
			{
				for(int j=0;j<=i;j++) 
				{
					result += p[j];
				}
			}
			
			System.out.println(result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
