package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2980 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			int n =  Integer.valueOf(temp[0]);
			int l =  Integer.valueOf(temp[1]);
			int k = 0; //시간
			int position = 0; //위치
			int j = 0;
			boolean isWaiting = false;
			List<TrafficLight> lights = new ArrayList<>();			
			
			for(int i=0;i<n;i++) {				
				temp = inbr.readLine().split(" ");
				int x = Integer.valueOf(temp[0]);
				int red = Integer.valueOf(temp[1]);
				int green = Integer.valueOf(temp[2]);
				lights.add(new TrafficLight(x, red, green, red+green));
			}
			
			//좌표를 기준으로 정렬
			Collections.sort(lights, (TrafficLight t1, TrafficLight t2)-> t1.x-t2.x);
			
			while(true) {
				k++;
				
				if(!isWaiting) {
					position++;					
				}
				
				if(position == l) {
					break;
				}
				if(j<lights.size() && position == lights.get(j).x) {
					if(k % lights.get(j).sum < lights.get(j).red) {
						isWaiting = true;
					}
					else {
						isWaiting = false;
						j++;
					}
				}
			}
			
			System.out.println(k);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class TrafficLight {
		
		public int x;
		public int red;
		public int green;
		public int sum;
		
		public TrafficLight(int x, int red, int green, int sum) {
			this.x = x;
			this.red = red;
			this.green = green;
			this.sum = sum;
		}
	}
}
