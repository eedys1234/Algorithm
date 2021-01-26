package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11054 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			
			int n = Integer.valueOf(line);
			int[][] length = new int[2][n+1];
			int[] sequence = new int[n+1];
			
			line = inbr.readLine();
			String[] temp = line.split(" ");
			
			
			for(int i=0;i<temp.length;i++) 
			{
				sequence[i+1] = Integer.valueOf(temp[i]);
			}
			
			for(int i=1;i<sequence.length;i++) 
			{
				length[0][i] = 1;
				for(int j=1;j<i;j++)
				{
					if(sequence[j] < sequence[i]) {
						length[0][i] = Math.max(length[0][i], length[0][j]+1);
					}
				}
			}
			
			for(int i=n;i>0;i--) 
			{
				length[1][i] = 1;
				for(int j=n;j>i;j--)
				{
					if(sequence[j] < sequence[i]) {
						length[1][i] = Math.max(length[1][i], length[1][j]+1);
					}
				}
			}
			
			
			int max = 0;
			
			for(int i=1;i<length[0].length;i++) {
				if(max < length[0][i] + length[1][i]) {
					max = length[0][i] + length[1][i];
				}
			}
			
			System.out.println(max-1);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
