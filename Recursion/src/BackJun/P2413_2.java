package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2413_2 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			boolean[] visited = new boolean[n+1];
			int[] sequence = new int[n+1];
			
			String[] temp = inbr.readLine().split(" ");

			for(int i=0;i<n;i++) {
				sequence[i+1] = Integer.valueOf(temp[i]);
			}
			
			for(int i=1;i<sequence.length-1;i++) 
			{
				int value = sequence[i];
				for(int j=i+1;j<sequence.length;j++) 
				{
					if(value-1 == sequence[j] && !visited[i] && !visited[j]) 
					{
						swap(sequence, visited, i, j);
					}
				}
			}
			
			for(int i=1;i<sequence.length;i++) 
			{
				sb.append(sequence[i]);
				if(i != sequence.length-1) {
					sb.append(" ");					
				}
			}
			
			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void swap(int[] sequence, boolean[] visited, int i, int j) {
		
		int temp = sequence[i];
		sequence[i] = sequence[j];
		sequence[j] = temp;
		
		visited[i] = visited[j] = true;
				
	}
}
