package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11049 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

		try {
			 String line = inbr.readLine();
			 
			 int n = Integer.valueOf(line);
			 int k = 1;
			 
			 int[][] matrix = new int[2][n+1];
			 
			 while(k<=n) {
				 line = inbr.readLine();
				 String[] temp = line.split(" ");
				 
				 int r = Integer.valueOf(temp[0]);
				 int c = Integer.valueOf(temp[1]);
				 
				 matrix[0][k] = r;
				 matrix[1][k++] = c;
			 }
			 
			 int min = calculate(matrix, n);
			 
			 System.out.println(min);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static int calculate(int[][] matrix, int n) {
		
		int[][] result = new int[n+1][n+1];
				
		for(int r=1;r<=n-1;r++) 
		{
			for(int i=1;i<=n-r;i++)
			{
				int j = i+r;
				result[i][j] = result[i][i] + result[i+1][j] + matrix[0][i]*matrix[1][i]*matrix[1][j];
				for(int k=i+1;k<=j-1;k++) 
				{
					if(result[i][j] > result[i][k] + result[k+1][j] + matrix[0][i]*matrix[1][k]*matrix[1][j]) {
						result[i][j] = result[i][k] + result[k+1][j] + matrix[0][i]*matrix[1][k]*matrix[1][j];
					}
				}
			}
		}
		
		return result[1][n];
	}
}
