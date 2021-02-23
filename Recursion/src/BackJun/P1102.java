package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1102 {

	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[][] cost = new int[n][n];
			boolean[] power = new boolean[n];
			
			for(int i=0;i<cost.length;i++) {
				String[] temp = inbr.readLine().split(" ");
				for(int j=0;j<temp.length;j++) {
					cost[i][j] = Integer.valueOf(temp[j]);
				}
			}
			
			String YN = inbr.readLine();
			for(int i=0;i<YN.length();i++) {
				if(YN.charAt(i) == 'Y') {
					power[i] = true;
				}
			}
			
			int p = Integer.valueOf(inbr.readLine());
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
