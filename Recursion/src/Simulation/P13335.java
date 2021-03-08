package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//시뮬레이션
public class P13335 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");

			int n = Integer.valueOf(temp[0]);
			int w = Integer.valueOf(temp[1]);
			int l = Integer.valueOf(temp[2]);
			int[] truck = new int[n];
			Queue<Integer> bridge = new LinkedList<>();
			int len = 0;
			int k = 0;
			int j = 0;
			
			temp = inbr.readLine().split(" ");
			
			for(int i=0;i<n;i++) {
				truck[i] = Integer.valueOf(temp[i]);
			}			
			
			for(int i=0;i<w;i++) {
				bridge.offer(0);
			}
			
			//초 단위로 로직구현
			while(!bridge.isEmpty()) {
				if(j < truck.length) {
					if(l >= truck[j]) {
						l += bridge.poll();
						bridge.offer(truck[j]);
						l -= truck[j++];					
					}
					else {
						l += bridge.poll();
						if(l >= truck[j]) {
							l -= truck[j];
							bridge.offer(truck[j++]);
						}
						else {
							bridge.offer(0);							
						}
					}									
				}
				else {
					l += bridge.poll();
				}
				k++;				
			}
			
			len = k;
			System.out.println(len);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
