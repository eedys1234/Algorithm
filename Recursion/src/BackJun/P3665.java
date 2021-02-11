package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P3665 {

	public static void main(String[] args) {
	
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int t = Integer.valueOf(inbr.readLine());
			
			while(t-- > 0) {
				StringBuilder sb = new StringBuilder();
				int n = Integer.valueOf(inbr.readLine());
				int[] order = new int[n];
				int[][] ads = new int[n+1][n+1];
				int[] in = new int[n+1];
				List<Integer> res = new ArrayList<>();
				
				Queue<Integer> queue = new LinkedList<Integer>();				
				String[] temp = inbr.readLine().split(" ");
				
				for(int i=0;i<temp.length;i++) 
				{
					order[i] = Integer.valueOf(temp[i]);
				}
				
				for(int i=0;i<order.length;i++) 
				{
					for(int j=i+1;j<order.length;j++) 
					{
						ads[order[i]][order[j]] = 1;
						in[order[j]]+=1;
					}
				}
				
				int m = Integer.valueOf(inbr.readLine());
				
				for(int i=0;i<m;i++) 
				{
					temp = inbr.readLine().split(" ");
					int a = Integer.valueOf(temp[0]);
					int b = Integer.valueOf(temp[1]);
										
					if(ads[a][b] == 1) {
						ads[a][b] = 0;
						ads[b][a] = 1;
						in[a]++;
						in[b]--;
					}
					else {
						ads[a][b] = 1;
						ads[b][a] = 0;
						in[b]++;
						in[a]--;
					}
				}
				
				for(int i=1;i<=n;i++) 
				{
					if(in[i] == 0) {
						queue.offer(i);
					}
				}
				
				while(!queue.isEmpty()) {
					
					if(queue.size() > 1) {
						System.out.println("?");
						return ;
					}
					int x = queue.poll();
					
					res.add(x);
					
					for(int next=1;next<ads[x].length;next++) {
						if(ads[x][next] == 1) {
							if(--in[next] == 0) {
								queue.offer(next);
							}
						}
					}
				}
				
				if(res.size() == n) {
					for(int i=0;i<res.size();i++) {
						sb.append(res.get(i) + " ");
					}
				}
				else {
					sb.append("IMPOSSIBLE");
				}						
				
				System.out.println(sb.toString());
			}			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
