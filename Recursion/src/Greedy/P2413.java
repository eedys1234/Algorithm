package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2413 {
	
	public static int[] next = {-1, 0, 1};
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			int[] sequence = new int[n]; 
			int[] result = new int[n];
			boolean[] visited = new boolean[n+1];
			String[] temp = inbr.readLine().split(" ");
			
			for(int j=0;j<temp.length;j++) {
				sequence[j] = Integer.valueOf(temp[j]);
			}

			search(sequence, result, visited, sequence[0], 0);
			
			for(int i=0;i<result.length;i++) {
				sb.append(result[i]);
				sb.append(" ");
			}
			
			System.out.println(sb.toString().substring(0, sb.toString().length()-1));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean search(int[] sequence, int[] result, boolean[] visited, int x, int k) {

		if(k == sequence.length) {
			return true;
		}		
		else {			
			for(int c : next) {				
				int nextX = x+c;

				if(nextX >= 1 && nextX <= sequence.length && !visited[nextX]) {
	 				visited[nextX] = true;
					result[k] = nextX;
					int value = k+1<sequence.length?sequence[k+1]:sequence[k];
					if(search(sequence, result, visited, value, k+1)) {
						return true;
					}

					visited[nextX] = false;
					result[k] = sequence[k];					
				}
			}
		}		
		
		return false;		
	}
}
