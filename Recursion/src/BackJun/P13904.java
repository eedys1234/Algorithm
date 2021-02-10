package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P13904 {

	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			int result = 0;
			int k = 0;
			boolean isVisited = false;
			List<Pair> works = new ArrayList<>();
			boolean[] visited = new boolean[n];

			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");
				works.add(new Pair(Integer.valueOf(temp[0]), Integer.valueOf(temp[1])));
			}
						
			for(int i=n;i>=1;i--) 
			{
				int max = 0;
				for(int j=0;j<works.size();j++) 
				{
					Pair work = works.get(j);
					
					if(i <= work.deadline) {
						if(max < work.score && !visited[j]) {
							max = work.score;
							k = j;
							isVisited = true;
						}
					}
				}
				
				if(isVisited) {
					visited[k] = true;
					result += max;
					//System.out.println(works.get(k).deadline+", "+works.get(k).score);
					k = 0;					
				}
				
				isVisited = false;
			}
			
			System.out.println(result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Pair {
		
		int deadline;
		int score;
		
		
		public Pair(int deadline, int score) {
			this.deadline = deadline;
			this.score = score;			
		}
		
	}
}
