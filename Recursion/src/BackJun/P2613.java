package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2613 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);
			int[] marble = new int[n];
			int sum = 0;
			int left = 0;
			
			temp = inbr.readLine().split(" ");
			
			for(int i=0;i<n;i++) {
				marble[i] = Integer.valueOf(temp[i]);
				sum += marble[i];
				left = left > marble[i] ? left : marble[i];
			}
			
			int mid = 0;
			int right = sum;
			
			while(left <= right) {
				
				mid = (left + right)/2;
				
				if(isPossible(marble, mid, m)) {
					right = mid-1;
				}
				else {
					left = mid+1;
				}				
			}
			
			System.out.println(left);
			printGroup(marble, left, m);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean isPossible(int[] marble, int mid, int m) {
		
		int sum = 0;
		int groupCnt = 1;
		
		for(int i=0;i<marble.length;i++) {
			
			sum += marble[i];
			
			if(sum > mid) {
				sum = marble[i];
				groupCnt++;
			}
		}
		
		
		return groupCnt <= m;
	}
	
	public static void printGroup(int[] marble, int mid, int m) {
		
		int sum = 0;
		int marbleCnt = 0;
		StringBuilder sb = new StringBuilder();
				
		for(int i=0;i<marble.length;i++) {
			
			sum += marble[i];
			
			if(sum > mid) {				
				sum = marble[i];
				m--;
				sb.append(marbleCnt+" ");
				marbleCnt = 0;
			}
			
			marbleCnt++;
			//System.out.println(marble[i] + " " + sum + " " + marbleCnt);
			
			if(marble.length-i == m) break;
		}
		
		while(m > 0) {
			sb.append(marbleCnt+" ");
			marbleCnt = 1;
			m--;
		}
		
		System.out.println(sb.toString());
	}
}
