package BackJun2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class P1929 {
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			int m = Integer.valueOf(temp[0]);
			int n = Integer.valueOf(temp[1]);
			StringBuilder sb = new StringBuilder();
			
			for(int i=m;i<=n;i++) {
				if(isPrime(i)) {
					sb.append(i).append("\n");
				}
			}
			
			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isPrime(int k) {
		return k > 1 &&  IntStream.rangeClosed(2, (int) Math.sqrt(k)).noneMatch(divisor -> k % divisor==0);
	}
}
