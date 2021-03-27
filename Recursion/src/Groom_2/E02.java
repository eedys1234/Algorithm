package Groom_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//크루스카 mst 알고리즘
public class E02 {

	public static void main(String[] args) throws Exception {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(inbr.readLine());
		List<Street> streets = new ArrayList<>();
		Map<String, City> cities = new HashMap<>();
		
		for(int i=0;i<n;i++) 
		{
			String[] temp = inbr.readLine().split(" ");
			streets.add(new Street(temp[0], temp[1], Integer.valueOf(temp[2])));

			if(!cities.containsKey(temp[0])) {
				cities.put(temp[0], new City(temp[0]));
			}
			
			if(!cities.containsKey(temp[1])) {
				cities.put(temp[1], new City(temp[1]));				
			}
		}
				
		Collections.sort(streets);
		
		int min = mst(cities, streets);
		System.out.println(min);
	}
	
	public static int mst(Map<String, City> cities, List<Street> streets) {
		
		int sum = 0;
		
		for(int i=0;i<streets.size();i++) 
		{
			Street street = streets.get(i);
			City v = cities.get(street.getStart());
			City u = cities.get(street.getEnd());
			
			if(findSet(v) != findSet(u)) {
				union(v, u);
				sum += street.getWeight();
			}
		}		
		
		return sum;
	}
	
	public static void union(City x, City y) {
		
		City rootX = findSet(x);
		City rootY = findSet(y);
		
		if(rootX != rootY) {
			if(rootX.size > rootY.size) {
				rootY.setParent(rootX);
				rootX.setSize(rootX.getSize() + rootY.getSize());
			}
			else {
				rootX.setParent(rootY);				
				rootY.setSize(rootY.getSize() + rootX.getSize());
			}			
		}
	}
	
	public static City findSet(City x) {
		
		while(x.getParent() != x) {
			x.setParent(x.getParent().getParent());
			x = x.getParent();
		}
		
		return x;
	}
	
	public static class Street implements Comparable<Street> {

		private String start;
		private String end;		
		private int weight;		
		
		public Street(String start, String end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}		

		public String getStart() {
			return start;
		}
		
		public String getEnd() {
			return end;
		}

		public int getWeight() {
			return weight;
		}

		@Override
		public int compareTo(Street o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static class City {
		
		private String name;
		private City parent;
		private int size;
		
		public City(String name) {
			this.name = name;
			this.parent = this;
			this.size = 0;
		}
		
		public String getName() {
			return name;
		}

		public City getParent() {
			return parent;
		}
		
		public void setParent(City parent) {
			this.parent = parent;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}
	}
}
