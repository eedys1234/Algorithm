package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P1826 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int res = 0;
			int n = Integer.valueOf(inbr.readLine());
			List<Pair> pairs = new ArrayList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o2, o1);
				}
			});
			
			String[] temp;
			
			for(int i=0;i<n;i++) {
				temp = inbr.readLine().split(" ");
				int a = Integer.valueOf(temp[0]);
				int b = Integer.valueOf(temp[1]);					
				pairs.add(new Pair(a, b));
			}
			
			//일직선 상을 걸으며 주유소를 찾기 때문에 주유소 위치에 따라 오름차순정렬
			Collections.sort(pairs, new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					return Integer.compare(o1.a, o2.a);
				}
			});
			
			temp = inbr.readLine().split(" ");
			int destination = Integer.valueOf(temp[0]);
			int use = Integer.valueOf(temp[1]);
			int idx = 0;
			
			//거리가 1~목적지까지
			for(int i=1;i<=destination;i++) {

				//연료를 다 사용했으면 이전 주유소에서 기름이 가장많은 주유소를 꺼낸다.
				if(use == 0) {
					if(!pq.isEmpty()) {
						use += pq.poll();
						res++;						
					}
					//없을경우 -1
					else {
						System.out.println("-1");
						return;
					}
				}

				//각 거리에 따른 주유소 추가
				while(idx >= 0 && idx < pairs.size() && pairs.get(idx).a <=i) {
					pq.offer(pairs.get(idx++).b);
				}

				use--;
				
			}
			
			System.out.println(res);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Pair {
		
		int a;
		int b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
