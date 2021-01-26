package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1149 {
	
	public static int[] red;
	public static int[] blue;
	public static int[] green;	
	public static int[] colors;
	
	public static final int RED = 1;
	public static final int GREEN = 2;
	public static final int BLUE = 3;
	
			
	public static void main(String[] args) {
		 
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			int t = Integer.valueOf(line);
			int i = 1;
			red = new int[t+1];
			blue = new int[t+1];
			green = new int[t+1];
			colors = new int[t+1];
			int[][] result = new int[3][t+1];
			
			while(i<=t) {
				line = inbr.readLine();
				String[] temp = line.split(" ");
				
				red[i] = Integer.valueOf(temp[0]);
				green[i] = Integer.valueOf(temp[1]);
				blue[i] = Integer.valueOf(temp[2]);				
				i++;
			}
						
			for(int k=1;k<result[0].length;k++) {								
				result[0][k] = Math.min(result[1][k-1], result[2][k-1]) + red[k];
				result[1][k] = Math.min(result[0][k-1], result[2][k-1]) + green[k];
				result[2][k] = Math.min(result[1][k-1], result[0][k-1]) + blue[k];
			}			
			
			int min = 0;
			if(result[0][t] < result[1][t]) {
				min = Math.min(result[0][t], result[2][t]);
			}
			else {
				min = Math.min(result[1][t], result[2][t]);				
			}
			
			System.out.println(min);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean check(int level) {		
		return false;
	}

}
