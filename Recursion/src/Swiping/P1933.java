package Swiping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1933 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {				
			StringBuilder sb = new StringBuilder();
			int n = Integer.valueOf(inbr.readLine());
			List<Build> builds = new ArrayList<>();
			int end = 0;
			int height = 0;

			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");
				int l = Integer.valueOf(temp[0]);
				int h = Integer.valueOf(temp[1]);
				int r = Integer.valueOf(temp[2]);
				
				builds.add(new Build(l, r, h));
			}
			
			//Á¤·Ä
			Collections.sort(builds);
			
			end = builds.get(0).r;
			height = builds.get(0).h;
			sb.append(builds.get(0).l).append(" ")
			  .append(builds.get(0).h).append(" ");

			/*
			for(int i=1;i<builds.size();i++) {
				
				if(builds.get(i).l < end && height < builds.get(i).h) {
					sb.append(builds.get(i).l).append(" ")
					  .append(builds.get(i).h).append(" ");
					end = Math.max(end, builds.get(i).r);
					height = Math.max(height, builds.get(i).h);
				}
				else {
					sb.append(builds.get(i).l).append(" ")
					  .append(builds.get(i).h).append(" ");
					
					end = builds.get(i).r;
					height = builds.get(i).h;					
				}
			}
			*/
			
			System.out.println(sb.toString());			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Build implements Comparable<Build>{
		
		int l;
		int r;
		int h;
		
		public Build(int l, int r, int h) {
			this.l = l;
			this.r = r;
			this.h = h;
		}

		@Override
		public int compareTo(Build o) {
			if(Integer.compare(this.l, o.l) == 0) {
				return Integer.compare(this.r, o.r);
			}
			return Integer.compare(this.l, o.l);
		}
	}
}
