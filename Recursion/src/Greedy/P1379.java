package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//Greedy
//P1374 프로그램과 동일한 로직으로, 강의실번호를 추가하는 로직만 추가되었다.
public class P1379 {
	
	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			List<Lecture> lectures = new ArrayList<>();
			List<Lecture> numbers = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			
			//강의실 번호
			int k = 1;
			
			PriorityQueue<Lecture> pq = new PriorityQueue<>((Lecture l1, Lecture l2)->{
				
				if(Integer.compare(l1.end, l2.end) == 0) {
					return Integer.compare(l1.start, l2.start);
				}
				return Integer.compare(l1.end, l2.end);
			});
			
			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");
				int index = Integer.valueOf(temp[0]);
				int start = Integer.valueOf(temp[1]);
				int end = Integer.valueOf(temp[2]);			
				Lecture lecture = new Lecture(index, start, end);

				lectures.add(lecture);
			}
			
			Collections.sort(lectures, (Lecture l1, Lecture l2) -> {
				
				if(Integer.compare(l1.start, l2.start) == 0) {
					return Integer.compare(l1.end, l2.end);
				}
				
				return Integer.compare(l1.start, l2.start);
			});
			
			//강의실 번호 추가
			lectures.get(0).lecNm = k++;
			pq.offer(lectures.get(0));
			numbers.add(lectures.get(0));
			
			for(int i=1;i<lectures.size();i++) {
				
				if(pq.peek().end <= lectures.get(i).start) {
					Lecture lecture = pq.poll();
					lectures.get(i).lecNm = lecture.lecNm;
					pq.offer(lectures.get(i));
				}
				else {
					lectures.get(i).lecNm = k++;
					pq.offer(lectures.get(i));					
				}				
				numbers.add(lectures.get(i));
			}
						
			sb.append(pq.size()).append("\n");
			
			Collections.sort(numbers, (Lecture l1, Lecture l2) -> l1.index - l2.index);

			for(int i=0;i<numbers.size();i++) {
				sb.append(numbers.get(i).lecNm).append("\n");
			}

			System.out.print(sb.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Lecture {
		
		public int index;
		public int start;
		public int end;
		public int lecNm;
		
		public Lecture(int index, int start, int end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}
	}
}
