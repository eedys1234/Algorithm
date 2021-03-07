package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

public class P1797 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			List<Person> people = new ArrayList<>();
			int sum = 0;
			
			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");
				int sex = Integer.valueOf(temp[0]);
				int x = Integer.valueOf(temp[1]);
				
				if(sex == 0) {
					sex = -1;
				}
				
				people.add(new Person(sex, x, i));
			}
			
			Collections.sort(people, (Person p1, Person p2)-> Integer.compare(p1.getX(), p2.getX()));
			
			if(n==2) {
				System.out.println(people.get(1).x - people.get(0).x);
				return;
			}
			
			for(int i=0;i<people.size();i++) {
				sum += people.get(i).sex;
				people.get(i).setS(sum);
			}
			
			Map<Integer, List<Person>> group = people.stream().collect(Collectors.groupingBy(Person::getS));
			
			int max = 0;
			
			for(Entry<Integer, List<Person>> entry : group.entrySet()) {
				List<Person> p = entry.getValue();				
				if(p.size() >= 2) {
					max = Math.max(max, p.get(p.size()-1).x - people.get(p.get(0).index+1).x);
				}
			}
			
			System.out.println(max);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Person {
		int sex;
		int x;
		int s;		
		int index;
		
		public Person(int sex, int x, int index) {
			this.sex = sex;
			this.x = x;
			this.index = index;
		}

		public int getSex() {
			return sex;
		}

		public int getX() {
			return x;
		}

		public int getS() {
			return s;
		}

		public void setS(int s) {
			this.s = s;
		}
		
		
	}
}
