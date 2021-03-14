package TwoPointer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1644 {
	
	public static boolean[] check;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			List<Integer> primes = new ArrayList<>();
			check = new boolean[n+1];
			int res = 0;
			int start = 0;
			int end = 0;
			long sum = 0;
			
			for(int i=2;i<=n;i++) {
				check[i] = true;
			}
			
			//n이하의 소수 구하기
			setPrime(primes, n);			
			
			while(true) {
				
				if(sum >= n) {
					sum -= primes.get(start++);
				}
				else if(end == primes.size()) {
					break;
				}
				else {					
					sum += primes.get(end++);
				}
				
				if(sum == n) res++;
			}
			
			System.out.println(res);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    //에라토스테네스의 체
    public static void setPrime(List<Integer> primes, int k) {
    	
    	for(int i=2;i*i<=k;i++) {
    		if(!check[i]) continue;
    		
    		for(int j=i*i;j<=k;j+=i) 
    		{
    			check[j] = false;
    		}
    	}
    	
		for(int i=2;i<=k;i++) {
			if(check[i]) {
				primes.add(i);
			}
		}
	}
}
