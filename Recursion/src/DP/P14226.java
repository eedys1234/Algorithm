package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P14226 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			boolean[][] visited = new boolean[2001][2001];
			Queue<Emotion> queue = new LinkedList<>();
			
			visited[1][0] = true;
			queue.offer(new Emotion(1, 0, 0));
			
			while(!queue.isEmpty()) {
			
				Emotion emotion = queue.poll();
				
				int display = emotion.display;
				int clip = emotion.clip;
				int time = emotion.time;
				
				if(display == n) {
					System.out.print(time);
					return;
				}
				
				if(0 < display && display <= 2000) {

					if(!visited[display][display]) {
						visited[display][display] = true;						
						queue.offer(new Emotion(display, display, time+1));
					}
					
					if(!visited[display-1][clip]) {
						visited[display-1][clip] = true;
						queue.offer(new Emotion(display-1, clip, time+1));
					}
				}
				
				if(0 < clip && display+clip <= 2000) {
					
					if(!visited[display+clip][clip]) {						
						visited[display+clip][clip] = true;
						queue.offer(new Emotion(display+clip, clip, time+1));
					}
				}
				
			}			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Emotion {
		
		int display;
		int clip;
		int time;
		
		public Emotion(int display, int clip, int time) {
			this.display = display;
			this.clip = clip;
			this.time = time;
		}
		
	}
}
