package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10830 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			long m = Long.valueOf(temp[1]);
			
			int[][] matrix = new int[n+1][n+1];
			
			for(int i=1;i<=n;i++) 
			{
				temp = inbr.readLine().split(" ");
				for(int j=0;j<temp.length;j++)
				{
					matrix[i][j+1] = Integer.valueOf(temp[j]);
				}
			}
			
			int[][] C = multipleMatrix(matrix, m);
			
			for(int i=1;i<C.length;i++)
			{
				for(int j=1;j<C[0].length;j++)
				{
					System.out.print(C[i][j]+" ");
				}
				System.out.println();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int[][] multipleMatrix(int[][] A, long m) {
		if(m == 1) {
			return A;
		}
		else if(m%2 == 1) {
			return solve(A, multipleMatrix(A, m-1));
		}
		else {
			return solve(multipleMatrix(A, m/2), multipleMatrix(A, m/2));
		}
	}
	
	public static int[][] solve(int[][] A, int[][] B) {
		
		int[][] C = new int[A.length][A[0].length];
		
		for(int i=1;i<A.length;i++)
		{
			for(int j=1;j<B[0].length;j++) 
			{
				for(int k=1;k<B.length;k++) 
				{
					C[i][j] += A[i][k] * B[k][j];
					C[i][j] %= 1000;
				}
			}
		}
		
		return C;
	}
}
