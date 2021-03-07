package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1713 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int pictureCnt = Integer.valueOf(inbr.readLine());
			int n = Integer.valueOf(inbr.readLine());
			int[] recomments = new int[n];
			List<Picture> list = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			
			String[] temp = inbr.readLine().split(" ");
			
			for(int i=0;i<n;i++) {
				recomments[i] = Integer.valueOf(temp[i]);
			}
			
			for(int i=0;i<recomments.length;i++) {
				if(list.size() < pictureCnt) {
					boolean isAdd = true;
					
					for(int j=0;j<list.size();j++) {
						if(list.get(j).num == recomments[i]) {
							list.get(j).recomment++;
							isAdd = false;
							break;
						}
					}
					if(isAdd) {
						list.add(new Picture(recomments[i], 1));						
					}
				}
				else {
					int min = 1001;
					int k = 0;
					boolean isDelete = false;
					for(int j=list.size()-1;j>=0;j--) {
						if(list.get(j).num == recomments[i]) {
							list.get(j).recomment++;
							isDelete = false;
							break;
						}
						if(list.get(j).recomment <= min) {
							min = list.get(j).recomment ;
							k = j;
							isDelete = true;
						}
					}
					
					if(isDelete) {
						list.remove(k);
						list.add(new Picture(recomments[i], 1));						
					}
//					System.out.println(list.get(0).num + " "+list.get(1).num + " "+list.get(2).num);
				}
			}
			
			Collections.sort(list, (Picture p1, Picture p2)-> p1.num - p2.num);

			for(int i=0;i<list.size();i++) {
				sb.append(list.get(i).num).append(" ");
			}

			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Picture {
		
		public int num;
		public int recomment;
		
		public Picture(int num, int recomment) {
			this.num = num;
			this.recomment = recomment;
		}
	}
}
