package Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P7568 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			List<Person> people = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			int big = 0;
			int middle = 0;
			
			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");
				int w = Integer.valueOf(temp[0]);
				int h = Integer.valueOf(temp[1]);
				
				people.add(new Person(w, h));
			}
			
			for(int i=0;i<people.size();i++)
			{
				big = 0;
				middle = 0;
				Person p1 = people.get(i);
				
				for(int j=0;j<people.size();j++)
				{
					if(i!=j) {
						Person p2 = people.get(j);
						if(p1.w >= p2.w && p1.h >= p2.h) {
							big++;
						}				
						else if(p1.w <= p2.w && p1.h >= p2.h) {
							middle++;
						}
						else if(p1.w >= p2.w && p1.h <= p2.h) {
							middle++;
						}
					}
				}
				
				sb.append(n-big-middle).append(" ");
			}
			
			System.out.println(sb.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static class Person {
		int w;
		int h;
		
		public Person(int w, int h) {
			this.w = w;
			this.h = h;
		}
	}
}
