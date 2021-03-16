package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2879 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			List<Pair> pairs = new ArrayList<>();
			
			String[] temp1 = inbr.readLine().split(" ");
			String[] temp2 = inbr.readLine().split(" ");	

			for(int j=0;j<temp1.length;j++) 
			{
				int a = Integer.valueOf(temp1[j]);
				int b = Integer.valueOf(temp2[j]);
				pairs.add(new Pair(a, b, a-b));
			}
			
			int res = 0;
			int prev = pairs.get(0).diff;
			
			for(int i=1;i<pairs.size();i++) {
				
				Pair pair = pairs.get(i);
				
				if(pair.diff > 0) {
					//부호 다를경우
					if(prev <= 0) {
						res += Math.abs(prev);
						prev = pair.diff;
					}
					else if(prev < pair.diff){
						prev = pair.diff;
					}
					else {
						res += Math.abs(prev) - Math.abs(pair.diff);
						prev = pair.diff;
					}
					
				}
				else {
					//부호 다를경우
					if(prev > 0) {
						res += Math.abs(prev);
						prev = pair.diff;
					}
					else if(prev > pair.diff) {
						prev = pair.diff;
					}
					else {
						res += Math.abs(prev) - Math.abs(pair.diff);
						prev = pair.diff;
					}
				}
			}
			
			res += Math.abs(prev);
			
			System.out.println(res);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Pair {
		
		int current;
		int correct;
		int diff;
		
		public Pair(int current, int correct, int diff) {
			this.current = current;
			this.correct = correct;
			this.diff = diff;
		}
	}
}
