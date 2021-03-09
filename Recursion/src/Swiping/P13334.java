package Swiping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class P13334 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {				
			int n = Integer.valueOf(inbr.readLine());
			List<Commute> commutes = new ArrayList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			int max = 0;
			
			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");
				int a = Integer.valueOf(temp[0]);
				int b = Integer.valueOf(temp[1]);
				
				if(a > b) {
					commutes.add(new Commute(b, a));					
				}
				else {
					commutes.add(new Commute(a, b));										
				}
			}
			
			int d = Integer.valueOf(inbr.readLine());
			
			//정렬
			Collections.sort(commutes, (Commute c1, Commute c2) -> Integer.compare(c1.work, c2.work));
			
			//각 선분마다 오른쪽 끝점을 기준으로 하여 나머지 겹치는 선분이 있는지 체크
			for(int i=0;i<commutes.size();i++) {

				//선분 왼쪽 끝점을 갖는 최소 힙
				pq.offer(commutes.get(i).house);
				
				while(!pq.isEmpty() && pq.peek() < commutes.get(i).work - d) {
					pq.poll();
				}
				
				max = Math.max(max, pq.size());
			}
			
			System.out.println(max);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static class Commute {
		
		public int house;
		public int work;
		
		public Commute(int house, int work) {
			this.house = house;
			this.work = work;
		}
	}
}
