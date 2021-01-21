package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P6884_2 {
	
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
				
				System.out.print("n list : ");
				for(int j=0;j<n.length;j++) {
					n[j] = Integer.valueOf(temp[j+1]);
					System.out.print(n[j] + " ");
				}
				
				boolean result = false;
				
				for(int m=2;m<n.length;m++) {
					result = powerset(n, m, 0);
					if(result) {
						System.out.print("Shortest primed subsequence is length " + m + ": ");
						for(int j=0;j<m;j++) {
							System.out.print(n[j] + " ");
						}
						System.out.println();
						break;
					}					
				}
				
				if(!result) {
					System.out.println("This sequence is anti-primed.");
				}
				
			}			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean powerset(int[] n, int m, int k) {
		
		if(k == m) {
			int sum = 0;
			for(int j=0;j<m;j++) {
				sum += n[j];
			}
			
			return isprime(sum);			
		}
		
		boolean result = false;
		for(int i=k;i<n.length;i++) {
			swap(n, i, k);
			result = powerset(n, m, k+1);
			if(result) {
				break;
			}
			swap(n, i, k);
		}
		
		return result;

	}
	
	public static void swap(int[] n, int x, int y) {
		int temp = n[x];
		n[x] = n[y];
		n[y] = temp;
	}
	
	public static boolean isprime(int prime) {
		return prime > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(prime)).noneMatch(divisor -> prime%divisor==0);
	}

}
