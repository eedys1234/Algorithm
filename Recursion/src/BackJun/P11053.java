package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11053 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			 
			String line = inbr.readLine();
			int n = Integer.valueOf(line);
			int[] sequence = new int[n+1];
			int[] length = new int[n+1];
			line = inbr.readLine();
			String[] temp = line.split(" ");
			
			for(int i=0;i<temp.length;i++) {
				sequence[i+1] = Integer.valueOf(temp[i]);
			}
			
			for(int i=1;i<sequence.length;i++) 
			{
				length[i] = 1;
				for(int j=1;j<i;j++) 
				{
					if(sequence[j] < sequence[i]) {
						length[i] = Math.max(length[i], length[j]+1);
					}
				}
			}
			
			int max = 0;
			for(int i=1;i<length.length;i++) {
				if(max<length[i]) {
					max = length[i];
				}
			}
			System.out.println(max);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
