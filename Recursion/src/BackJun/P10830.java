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
			
			long[][] matrix = new long[n+1][n+1];
			
			for(int i=1;i<=n;i++) 
			{
				temp = inbr.readLine().split(" ");
				for(int j=0;j<temp.length;j++)
				{
					matrix[i][j+1] = Integer.valueOf(temp[j]);
				}
			}
			
			long[][] C = multipleMatrix(matrix, m);
			
			for(int i=1;i<C.length;i++)
			{
				for(int j=1;j<C[0].length;j++)
				{
					System.out.print((C[i][j])%1000+" ");
				}
				System.out.println();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static long[][] multipleMatrix(long[][] A, long m) {
		if(m == 1) {
			return A;
		}
		else if(m%2 == 1) {
			long[][] half = multipleMatrix(A, (m-1)/2);
			return solve(A, solve(half, half));
		}
		else {
			long[][] half = multipleMatrix(A, m/2);
			return solve(half, half);
		}
	}
	
	public static long[][] solve(long[][] A, long[][] B) {
		
		long[][] C = new long[A.length][A[0].length];
		
		for(int i=1;i<A.length;i++)
		{
			for(int j=1;j<B[0].length;j++) 
			{
				for(int k=1;k<B.length;k++) 
				{
					C[i][j] = C[i][j] + (A[i][k]%1000 * B[k][j]%1000)%1000;
					C[i][j] %= 1000;
				}
			}
		}
		
		return C;
	}
}
