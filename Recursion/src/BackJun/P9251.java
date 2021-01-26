package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9251 {

	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String x = inbr.readLine();
			String y = inbr.readLine();
			
			int m = x.length();
			int n = y.length();
			int k = 0;
			int[][] result = new int[m+1][n+1];
			int[][] path = new int[m+1][n+1];
			char[] ch = new char[m>n?m:n];
			
			for(int i=0;i<m;i++) 
			{
				for(int j=0;j<n;j++) 
				{
					if(x.charAt(i) == y.charAt(j)) {
						result[i+1][j+1] = result[i][j] + 1;
						path[i+1][j+1] = 1;
					}
					else {
						if(result[i][j+1] > result[i+1][j]) {
							result[i+1][j+1] = result[i][j+1];
							path[i+1][j+1] = 2;
						}
						else {
							result[i+1][j+1] = result[i+1][j];							
							path[i+1][j+1] = 3;
						}
					}
				}
			}
			
			System.out.println(result[m][n]);

			int i=m, j=n;
			while(i >= 0 && j >= 0 && path[i][j] != 0) {
				
				if(path[i][j] == 1) {
					i--;
					j--;
					ch[k++] = x.charAt(i);
				}
				else if(path[i][j] == 2) {
					i--;
				}
				else {
					j--;
				}
			}
			
			for(int l=k-1;l>=0;l--) 
			{
				System.out.print(ch[l]);				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
