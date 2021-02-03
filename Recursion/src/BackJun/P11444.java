package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11444 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {

			long n = Long.valueOf(inbr.readLine());
			long[][] A = new long[3][3];
			
			A[1][1] = 0;
			A[1][2] = 1;
			A[2][1] = 1;
			A[2][2] = 1;
			
			long value = fibo(A, n);
			
			System.out.println(value);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static long fibo(long[][] A, long n) {
		
		long[][] C = solve(A, n);
		
		return C[1][2]%1000000007;
	}
	
	public static long[][] solve(long[][] A, long n) {

		if(n==1) {
			return A;
		}
		else if(n%2 == 1) {
			long[][] C = solve(A, (n-1)/2);
			long[][] result = multipleMatrix(C, C);
			return multipleMatrix(A, result);
		}
		else {
			long[][] C = solve(A, n/2);
			return multipleMatrix(C, C);
		}
	}
	
	public static long[][] multipleMatrix(long[][] A, long[][] B) {
		long[][] C = new long[A.length][A[0].length];

		for(int i=1;i<A.length;i++) 
		{
			for(int j=1;j<B[0].length;j++) 
			{
				for(int k=1;k<B.length;k++) 
				{
					C[i][j] += (A[i][k] * B[k][j])%1000000007;
					C[i][j] %= 1000000007;
				}
			}
		}
		return C;
	}
}
