package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P17619 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			String[] temp = inbr.readLine().split(" ");
			List<Line> sortedlines = new ArrayList<>();
			List<Line> lines = new ArrayList<>();
			List<Question> questions = new ArrayList<>();

			int n = Integer.valueOf(temp[0]);
			int q = Integer.valueOf(temp[1]);
			
			for(int i=0;i<n;i++) 
			{
				temp = inbr.readLine().split(" ");
				int x1 = Integer.valueOf(temp[0]);
				int x2 = Integer.valueOf(temp[1]);
				int y = Integer.valueOf(temp[2]);
				
				lines.add(new Line((i+1), x1, x2, y));
				sortedlines.add(lines.get(i));
			}
			
			for(int i=0;i<q;i++) 
			{
				temp = inbr.readLine().split(" ");
				
				int start = Integer.valueOf(temp[0]);
				int end = Integer.valueOf(temp[1]);
				
				questions.add(new Question(start, end));				
			}
			
			Collections.sort(sortedlines, new Comparator<Line>() {

				@Override
				public int compare(Line o1, Line o2) {
					return Integer.compare(o1.x1, o2.x1);
				}
			});
						
			for(int i=0;i<sortedlines.size()-1;i++) {
				
				if(sortedlines.get(i).x2 >= sortedlines.get(i+1).x1) {
					union(sortedlines.get(i), sortedlines.get(i+1));
					sortedlines.get(i+1).x2 = Math.max(sortedlines.get(i).x2, sortedlines.get(i+1).x2);
				}
			}
			
			
			for(int i=0;i<questions.size();i++) 
			{
				Question question = questions.get(i);
				int start = question.start; 
				int end = question.end;
				
				if(findSet(lines.get(start-1)) == findSet(lines.get(end-1))) {
					sb.append(1);
				}
				else {
					sb.append(0);					
				}
				if(i!=questions.size()-1) sb.append("\n");
			}
			
			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Line findSet(Line line) {
		
		while(line.parent != line) {
			line.parent = line.parent.parent;
			line = line.parent;			
		}
		
		return line;
	}
	
	public static void union(Line prev, Line next) {
		
		Line rootPrev = findSet(prev);
		Line rootNext = findSet(next);
		
		if(rootPrev.size > rootNext.size) {
			rootNext.parent = rootPrev;
			rootPrev.size += rootNext.size;
		}
		else {
			rootPrev.parent = rootNext;
			rootNext.size += prev.size;			
		}
	}
	
	public static class Line {
		
		int id;
		int x1;
		int x2;
		int y;	
		int size;
		Line parent;
		
		public Line(int id, int x1, int x2, int y) {
			this.id = id;
			this.x1 = x1;
			this.x2 = x2;
			this.y = y;
			this.parent = this;
			this.size = 1;
		}
		
	}
	
	public static class Question {
		
		int start;
		int end;
		
		public Question(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
