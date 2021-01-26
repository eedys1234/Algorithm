package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P13711 {

	
	public static void main(String[] args) {
	
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String line = inbr.readLine();
			int t = Integer.valueOf(line);
			
			int[] x = new int[t+1];
			int[] y = new int[t+1];
			int[][] result = new int[t+1][t+1];
						
			line = inbr.readLine();
			String[] temp = line.split(" ");
			
			for(int i=0;i<temp.length;i++) {
				x[i+1] = Integer.valueOf(temp[i]);
			}

			line = inbr.readLine();
			temp = line.split(" ");

			for(int i=0;i<temp.length;i++) {
				y[i+1] = Integer.valueOf(temp[i]);
			}
			
			for(int i=1;i<x.length;i++) 
			{
				for(int j=1;j<y.length;j++)
				{
					if(x[i]==y[j])
					{
						result[i][j] = result[i-1][j-1] + 1;						
					}
					else 
					{
						result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
					}
				}
			}
			
			System.out.print(result[t][t]);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
