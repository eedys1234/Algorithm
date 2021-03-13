package Prime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P1963 {

	public static boolean[] check;
	public static boolean[] visited;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int t = Integer.valueOf(inbr.readLine());
			check = new boolean[10000];
			
			for(int i=2;i<check.length;i++) {
				check[i] = true;
			}

			getPrimes(9999);
						
			while(t-- > 0) {
				String[] temp = inbr.readLine().split(" ");
				visited = new boolean[10000];
				
				int A = Integer.valueOf(temp[0]);
				int B = Integer.valueOf(temp[1]);
				
				int depth = bfs(A, B);
				if(depth == -1) {
					System.out.println("Impossible	");
				}
				else {					
					System.out.println(depth);
				}
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static int bfs(int A, int B) {
		
		Queue<Prime> queue = new LinkedList<>();		
		visited[A] = true;
		queue.offer(new Prime(A, 0));
		
		while(!queue.isEmpty()) {
			
			Prime prime = queue.poll();

			int value = prime.value;
			int depth = prime.depth;
			
			if(value == B) return depth;
			String changeValue = String.valueOf(value);
			
			for(int i=0;i<changeValue.length();i++) 
			{				
				for(int j=0;j<10;j++) 
				{
					String tmp = "";
					
					if(i == 0 && j == 0) continue;
					
					if(i == 0 && j != 0) {
						tmp = j + changeValue.substring(i+1, changeValue.length());												
					}
					else if(i == changeValue.length()-1) {
						tmp = changeValue.substring(0, i) + j;
					}
					else {
						tmp = changeValue.substring(0, i) + j + changeValue.substring(i+1, changeValue.length());
					}
					
					if(check[Integer.valueOf(tmp)] && !visited[Integer.valueOf(tmp)]) {
						visited[Integer.valueOf(tmp)] = true;
						queue.offer(new Prime(Integer.valueOf(tmp), depth+1));
					}					
				}
			}
		}
		
		return -1;
		
	}
	
	public static void getPrimes(int k) {
		
		for(int i=2;i*i<k;i++) {
			
			if(!check[i]) continue;
			
			for(int j=2*i;j<=k;j+=i) {
				check[j] = false;
			}
		}
	}
	
	public static class Prime {
		
		public int value;
		public int depth;
		
		public Prime(int value, int depth) {
			this.value = value;
			this.depth = depth;
		}
	}
}
