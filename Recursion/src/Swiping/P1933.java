package Swiping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class P1933 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {				
			StringBuilder sb = new StringBuilder();
			int n = Integer.valueOf(inbr.readLine());
			List<Build> builds = new ArrayList<>();
			List<Build> ansList = new ArrayList<>();
			
			TreeMap<Integer, Integer> tm = new TreeMap<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o2, o1);
				}
			});
			
			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");
				int l = Integer.valueOf(temp[0]);
				int h = Integer.valueOf(temp[1]);
				int r = Integer.valueOf(temp[2]);
				
				builds.add(new Build(l, h, 0));
				builds.add(new Build(r, h, 1));
			}
			
			//Á¤·Ä
			Collections.sort(builds);
			
//			for(int i=0;i<builds.size();i++) {
//				System.out.println(builds.get(i).l+" "+builds.get(i).h);
//			}
			
			for(int i=0;i<builds.size();i++) {

				Build cur = builds.get(i);
				
				if(cur.type == 0) {	
					tm.put(cur.h, tm.getOrDefault(cur.h, 0)+1);
				}
				else {
					int val = tm.get(cur.h);
					if(val == 1) {
						tm.remove(cur.h);
					}
					else {
						tm.put(cur.h, val-1);
					}
				}
				
				if(tm.size() == 0) {
					ansList.add(new Build(cur.l, 0, 0));
					continue;
				}
				
				
				ansList.add(new Build(cur.l, tm.firstKey(), 0));
			}
			
			for(int i=0;i<ansList.size();i++) {
				System.out.println(ansList.get(i).l+" " + ansList.get(i).h);
			}

			sb.append(ansList.get(0).l).append(" ")
			.append(ansList.get(0).h).append(" ");
			
			int previous = ansList.get(0).h;
			
			for(int i=1;i<ansList.size();i++) {
				if(previous != ansList.get(i).h)
				{
					sb.append(ansList.get(i).l).append(" ")
					.append(ansList.get(i).h).append(" ");
					
					previous = ansList.get(i).h;
				}
			}
			
//			System.out.println(sb.toString());			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Build implements Comparable<Build>{
		
		int l;
		int type;
		int h;
		
		public Build(int l, int h, int type) {
			this.l = l;
			this.h = h;
			this.type = type;
		}

		@Override
		public int compareTo(Build o) {
			if(Integer.compare(this.l, o.l) == 0) {
				return Integer.compare(o.h, this.h);
			}
			return Integer.compare(this.l, o.l);
		}
	}
}
