package BackJun2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2878 {

	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			int m = Integer.valueOf(temp[0]);
			int n = Integer.valueOf(temp[1]);
			
			long[] freinds = new long[n+1];
			
			long sum = 0;
			for(int i=1;i<=n;i++) {
				freinds[i] = Integer.valueOf(inbr.readLine());
				sum += freinds[i];
			}
			
			sum -= m;
			Arrays.sort(freinds);
			long res = 0;
			
			for(int i=1;i<=n;i++)
			{
				long w = Math.min(freinds[i], sum/(n+1-i));
				res += w*w;
				sum -= w;
			}
			
			System.out.println(res);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
