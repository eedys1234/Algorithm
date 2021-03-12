package Prime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//소수구하기
public class P2960 {

	public static boolean[] check;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			int n = Integer.valueOf(temp[0]);
			int k = Integer.valueOf(temp[1]);
			check = new boolean[n+1];
			
			for(int i=2;i<check.length;i++) {
				check[i] = true;
			}
			
			System.out.println(getPirmes(n, k));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int getPirmes(int n, int k) {
		
		int cnt = 0;

		for(int i=2;i<=n;i++) 
		{
			if(!check[i]) {
				continue;
			}
			
			for(int j=i;j<=n;j+=i) 
			{
				if(check[j]) {
					check[j] = false;
					cnt++;
				}
				
				if(cnt == k) {
					return j;
				}
			}
		}
		
		return 0;
	}
}
