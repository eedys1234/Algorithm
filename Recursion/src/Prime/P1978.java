package Prime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

//소수 구하기 
public class P1978 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			int[] input = new int[n];
			int cnt = 0;
			
			String[] temp = inbr.readLine().split(" ");
			
			for(int i=0;i<n;i++) {
				input[i] = Integer.valueOf(temp[i]);
			}
			
			for(int i=0;i<input.length;i++) {
				if(isPrime(input[i])) cnt++;
			}
			
			System.out.println(cnt);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isPrime(int k) {		
		return k > 1 && IntStream.rangeClosed(2, (int)Math.sqrt(k)).noneMatch(divisor->k%divisor==0);		
	}
}
