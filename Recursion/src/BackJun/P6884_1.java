package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P6884_1 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String line = inbr.readLine();
			int t = Integer.valueOf(line);
			
			for(int i=0;i<t;i++) {
				line = inbr.readLine();
				String[] temp = line.split(" ");
				int digit = Integer.valueOf(temp[0]);
				int[] n = new int[digit];
				
				for(int j=0;j<n.length;j++) {
					n[j] = Integer.valueOf(temp[j+1]);
				}
				
				int start = -1;
				for(int m=2;m<=n.length;m++) {
					start = powerset(n, m, 0);
					if(start > -1) {
						System.out.print("Shortest primed subsequence is length " + m + ": ");
						int limit = 0;
						if(n.length < start + m) {
							limit = n.length;
						}
						else {
							limit = start+m;
						}
						for(int j=start;j<limit;j++) {
							System.out.print(n[j] + " ");
						}
						System.out.println();
						break;
					}					
				}
				
				if(start == -1) {
					System.out.println("This sequence is anti-primed.");
				}
				
			}			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int powerset(int[] n, int m, int k) {
				
		boolean result = false;
		int start = -1;
		int i = k;
		int sum = 0;
		
		while(i+m <= n.length) {
			sum = sum(n, m, i, sum);				
			result = isprime(sum);	

			if(result) {
				start = i;
				break;
			}
			i++;
		}
		
		return start;

	}
	
	
	public static int sum(int[] n, int m, int start, int sum) {

		int limit = 0;
		
		if(n.length < start + m) {
			limit = n.length;
		}
		else {
			limit = start+m;
		}
		
		if(start == 0) {
			for(int j=start;j<limit;j++) {
				sum += n[j];
			}
		}
		else {
			sum = sum - n[start-1] + n[limit-1];
		}
		
		return sum;		
	}
	
	public static boolean isprime(int prime) {
		return prime > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(prime)).noneMatch(divisor -> prime%divisor==0);
	}

}
