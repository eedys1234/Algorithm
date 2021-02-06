package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1038 {

	public static int cnt = 0;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		long[] jump = {98L, 210L, 987L, 3210L, 9876L, 43210L, 98765L, 543210L, 987654L, 6543210L, 
				9876543L, 76543210L, 98765432L, 876543210L, 987654321L, 9876543210L};
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			
			tracer(n, jump);
						
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void tracer(int n, long[] jump) {
		
		long i = 0;
		int j = 0;

		while(n > cnt) {
			
			i++;
			if(i > 9876543210L) {
				System.out.println("-1");
				return;
			}
			
			if(decreasing(i)) {
				cnt++;
			}
			
			if(j< jump.length && i > jump[j]) {				
				i = jump[j+1]-1;
				j+=2;
			}
		}
		
		System.out.println(i);
	}
	
	public static boolean decreasing(long a) {
		
		boolean isDecrease = true;
		
		if(a==0) {
			return isDecrease;
		}
		
		for(long i=a;i>=10;i=i/10) {
			
			if((i % 10) >= (i / 10) % 10) {
				isDecrease = false;
				return isDecrease;
			}			
		}
		
		return isDecrease;
	}
}
