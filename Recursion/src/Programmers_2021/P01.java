package Programmers_2021;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P01 {
	
	public static void main(String[] args) {
		
		String[] info = {
			"java backend junior pizza 150",
			"python frontend senior chicken 210",
			"python frontend senior chicken 150",
			"cpp backend senior pizza 260",
			"java backend junior chicken 80",
			"python backend senior chicken 50"
		};
		
		String[] query = {
			"java and backend and junior and pizza 100",
			"python and frontend and senior and chicken 200",
			"cpp and - and senior and pizza 250",
			"- and backend and senior and - 150",
			"- and - and - and chicken 100",
			"- and - and - and - 150"
		};
		
		int[] ans = solution(info, query);
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
	}
	
	public static void printList(List<Row> rows) {
		
		for(int i=0;i<rows.size();i++) {
			Row row = rows.get(i);
			System.out.println(row.lan+" "+row.duty+" "+row.career+" "+row.food+" "+row.score);
		}		
	}
	
	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		List<Row> rows = new ArrayList<>();
		
		for(int i=0;i<info.length;i++) {
			String[] temp = info[i].split(" ");
			rows.add(new Row(convertValue(temp[0]), convertValue(temp[1]), convertValue(temp[2]), convertValue(temp[3]), Integer.valueOf(temp[4])));
		}
		
		//정렬
		List<List<Row>> sortedList = new ArrayList<>();
		
		sortedList.add(createLanSortedList(rows)); //0
		sortedList.add(createDutySortedList(rows)); //1
		sortedList.add(createCareerSortedList(rows)); //2
		sortedList.add(createFoodSortedList(rows)); //3
		
		int result = 0;
		for(int i=0;i<query.length;i++) 
		{
			String[] temp = query[i].replace(" and", "").split(" ");
			
			int k = 0;
			result = 0;
			
			for(int j=0;j<temp.length-1;j++) 
			{
				if(!"-".equals(temp[j])) {
					k = j;
					break;
				}
			}

			int start = 0;
			int end = sortedList.get(k).size();

			for(int j=k;j<temp.length-1;j++) 
			{
				if("-".equals(temp[j])) {
					continue;
				}
				
				int loIdx = lowerBound(sortedList.get(k), start, end, convertValue(temp[j]), j);
				int upIdx = upperBound(sortedList.get(k), start, end, convertValue(temp[j]), j);
				
				start = loIdx;
				end = upIdx;
			}
			
			int score = Integer.valueOf(temp[4]);

			for(int j=start;j<end;j++) {
				if(Integer.valueOf(sortedList.get(k).get(j).score) >= score) {
					Row row = sortedList.get(k).get(j);
					System.out.println(row.lan+" "+row.duty+ " "+row.career+" "+row.food+" "+row.score);
					result++;
				}
			}
			
			answer[i] = result;
		}
		
		return answer;
	}
	
	public static int convertValue(String str) {
		
		if(str.equals("cpp") || str.equals("backend") || str.equals("junior") || str.equals("pizza")) {
			return 1;
		}
		else if(str.equals("java") || str.equals("frontend") || str.equals("senior") || str.equals("chicken")) {
			return 2;
		}
		else if(str.equals("python")) {
			return 3;
		}
		return Integer.valueOf(str);
	}
	
	public static List<Row> createLanSortedList(List<Row> rows) {
		//정렬
		return rows.stream().sorted(new Comparator<Row>() {

			@Override
			public int compare(Row o1, Row o2) {
				
				if(Integer.compare(o1.lan, o2.lan) == 0) 
				{				
					if(Integer.compare(o1.duty, o2.duty) == 0) 
					{				
						if(Integer.compare(o1.career, o2.career) == 0) 
						{
							return Integer.compare(o1.food, o2.food);
						}
						
						return Integer.compare(o1.career, o2.career);
					}				
					
					return Integer.compare(o1.duty, o2.duty);
				}
				
				return Integer.compare(o1.lan, o2.lan);
				}
			}).collect(Collectors.toList());
	}
	
	public static List<Row> createDutySortedList(List<Row> rows) {

		return rows.stream().sorted(new Comparator<Row>() {

			@Override
			public int compare(Row o1, Row o2) {
				
				if(Integer.compare(o1.duty, o2.duty) == 0) 
				{				
					if(Integer.compare(o1.career, o2.career) == 0) 
					{
						return Integer.compare(o1.food, o2.food);
					}
					
					return Integer.compare(o1.career, o2.career);
				}				
				
				return Integer.compare(o1.duty, o2.duty);
			}
		}).collect(Collectors.toList());
	}

	public static List<Row> createCareerSortedList(List<Row> rows) {
		return rows.stream().sorted(new Comparator<Row>() {

				@Override
				public int compare(Row o1, Row o2) {

					if(Integer.compare(o1.career, o2.career) == 0) 
					{
						return Integer.compare(o1.food, o2.food);
					}
					
					return Integer.compare(o1.career, o2.career);

				}
			}).collect(Collectors.toList());
	}
	
	public static List<Row> createFoodSortedList(List<Row> rows) {
		return rows.stream().sorted(new Comparator<Row>() {

				@Override
				public int compare(Row o1, Row o2) {
					return Integer.compare(o1.food, o2.food);
				}
			}).collect(Collectors.toList());
	}
	
	public static int lowerBound(List<Row> rows, int left, int right, int target, int j) {
		
		int mid = 0;

		while(left < right) {
			mid = (left+right)/2;
			Row row = rows.get(mid);			
			int value = 0;

			switch (j) {
				case 0:	
					value = row.lan;
					break;
				case 1:	
					value = row.duty;
					break;
				case 2:	
					value = row.career;
					break;
				case 3:	
					value = row.food;
					break;
				default:
					value = row.score;
					break;
			}
			
			if(value < target) {
				left = mid+1;
			}
			else {
				right = mid;
			}
		}
		
		return right;
	}
	
	public static int upperBound(List<Row> rows, int left, int right, int target, int j) {
		
		int mid = 0;

		while(left < right) {
			mid = (left+right)/2;
			Row row = rows.get(mid);			
			int value = 0;
			switch (j) {
				case 0:	
					value = row.lan;
					break;
				case 1:	
					value = row.duty;
					break;
				case 2:	
					value = row.career;
					break;
				case 3:	
					value = row.food;
					break;
				default:
					value = row.score;
					break;
			}

			if(value <= target) {
				left = mid+1;
			}
			else {
				right = mid;
			}				
		}
		
		return right;
	}
	
	public static class Row {

		public int lan;
		public int duty;
		public int career;
		public int food;
		public int score;
				
		public Row(int lan, int duty, int career, int food, int score) {
			this.lan = lan;
			this.duty = duty;
			this.career = career;
			this.food = food;
			this.score = score;
		}
	}
}
