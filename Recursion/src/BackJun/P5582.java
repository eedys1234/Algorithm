package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P5582 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String s = inbr.readLine();
			String t = inbr.readLine();
			
			int[][] result = new int[s.length()+1][t.length()+1];
			
			for(int i=0;i<s.length();i++) 
			{
				for(int j=0;j<t.length();j++) 
				{
					if(s.charAt(i) == t.charAt(j)) {
						
						result[i+1][j+1] = result[i][j]+1;													
					}
					else {
						
						if(result[i+1][j] < result[i][j+1]) {
							result[i+1][j+1] = result[i][j+1];
						}
						else {
							result[i+1][j+1] = result[i+1][j];
						}
					}
				}
			}
			
			System.out.println(result[s.length()][t.length()]);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
