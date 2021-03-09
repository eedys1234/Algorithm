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
			
			//����
			Collections.sort(commutes, (Commute c1, Commute c2) -> Integer.compare(c1.work, c2.work));
			
			//�� ���и��� ������ ������ �������� �Ͽ� ������ ��ġ�� ������ �ִ��� üũ
			for(int i=0;i<commutes.size();i++) {

				//���� ���� ������ ���� �ּ� ��
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
