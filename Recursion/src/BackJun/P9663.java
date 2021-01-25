package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9663 {

	public static int[] cols;
	public static int count = 0;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = inbr.readLine();
			int n = Integer.valueOf(line);
			cols = new int[n+1];
			for(int i=0;i<cols.length;i++) {
				cols[i] = -1;
			}
			
			DFS(0);
			
			System.out.println(count);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean DFS(int depth) {
		
		if(!check(depth)){
			return false;
		}
		else if(depth == cols.length-1) {
			count++;
			return true;
		}
		else {
			for(int i=1;i<cols.length;i++) {
				cols[depth+1] = i;
				DFS(depth+1);
			}			
			return false;
		}
		
	}
	
	public static boolean check(int depth) {
		
		for(int i=1;i<depth;i++) {

			if(cols[i]==cols[depth]) {
				return false;
			}
			
			else if(depth-i == Math.abs(cols[depth]-cols[i])) {
				return false;
			}
		}
		
		return true;
	}
}

