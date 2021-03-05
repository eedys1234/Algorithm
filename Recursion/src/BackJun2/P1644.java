package BackJun2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class P1644 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isPrime(int k) {
		return k > 1 &&  IntStream.rangeClosed(2, (int) Math.sqrt(k)).noneMatch(divisor -> k % divisor==0);
	}
}
