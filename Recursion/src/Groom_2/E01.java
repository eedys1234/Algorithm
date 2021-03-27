package Groom_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class E01 {

	public static void main(String[] args) throws Exception {
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		Queue<Location> queue = new LinkedList<Location>();
		
		String[] temp = inbr.readLine().split(" ");
		
		int n = Integer.valueOf(temp[0]);
		String play_time = temp[1];
		String[] info = new String[n];
		int[] info_time = new int[n];
		int total_time = 0;
		int cnt = 0;
		int start = 0;

		for(int i=0;i<n;i++) 
		{
			info[i] = inbr.readLine();
			info_time[i] = toMinute(info[i]);
		}
		
		total_time = toMinute(play_time);

		
		for(int i=0;i<info_time.length;i++) 
		{
			
			if(total_time >= info_time[i]) {
				total_time -= info_time[i];
				queue.offer(new Location(i+1, info_time[i]));
			}
			else {
				while(!queue.isEmpty() && total_time <= 0) {
					total_time += queue.poll().time;
				}
				
				total_time -= info_time[i];
				queue.offer(new Location(i+1, info_time[i]));
			}
			
			if(cnt < queue.size()) {
				start = queue.peek().index;
				cnt = queue.size();
			}
		}
		
		System.out.println(cnt + " " + start);
	}
	
	public static int toMinute(String play) {
		
		String[] time = play.split(":");
		int k = time.length-1;
		int q = 1;
		int sum = 0;

		while(k >= 0) {
			sum += Integer.valueOf(time[k]) * q; 
			q *= 60;
			k--;
		}
		
		return sum;
	}
	
	public static class Location {

		public int index;
		public int time; 
		
		public Location(int index, int time) {
			this.index = index;
			this.time = time;
		}
	
	}
}
