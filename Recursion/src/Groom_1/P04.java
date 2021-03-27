package Groom_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P04 {

	public static void main(String[] args) throws Exception {
		//우선순위 기준에 따른 ArrayList 생성
		//각 ArrayList를 선호도 기준에 따라 정렬		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = inbr.readLine().split(" ");
		float[] rate = new float[5];
		List<Content> hi_content = new ArrayList<>();
		List<Content> lo_content = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<temp.length;i++) 
		{
			rate[i] = Float.valueOf(temp[i]);
		}
		
		temp = inbr.readLine().split(" ");
		int n = Integer.valueOf(temp[0]);
		int m = Integer.valueOf(temp[1]);
		
		char[][] content_info = new char[n][m];
		char[][] preferences = new char[n][m];
		
		for(int i=0;i<n;i++) 
		{
			String str = inbr.readLine();
			for(int j=0;j<str.length();j++)
			{
				content_info[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0;i<n;i++) 
		{
			String str = inbr.readLine();
			for(int j=0;j<str.length();j++)
			{
				preferences[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0;i<n;i++) 
		{
			for(int j=0;j<m;j++)
			{
				if(content_info[i][j] == 'Y') {
					hi_content.add(new Content(i, j, preferences[i][j], rate[preferences[i][j] - 'A']));
				}
				else if(content_info[i][j] == 'O') {
					lo_content.add(new Content(i, j, preferences[i][j], rate[preferences[i][j] - 'A']));
				}
			}
		}
		
		Collections.sort(hi_content);
		Collections.sort(lo_content);
		
		for(int i=0;i<hi_content.size();i++)
		{
			Content content = hi_content.get(i);
			sb.append(content.getRate()).append(" ");
			sb.append(content.getRate_score()).append(" ");
			sb.append(content.getX()).append(" ");
			sb.append(content.getY()).append("\n");						
		}

		for(int i=0;i<lo_content.size();i++)
		{
			Content content = lo_content.get(i);
			sb.append(content.getRate()).append(" ");
			sb.append(content.getRate_score()).append(" ");
			sb.append(content.getX()).append(" ");
			sb.append(content.getY()).append("\n");						
		}
		
		System.out.println(sb.toString());

	}

	public static class Content implements Comparable<Content> {
		int x;
		int y;
		char rate;
		float rate_score;
		
		
		public Content(int x, int y, char rate, float rate_score) {
			this.x = x;
			this.y = y;
			this.rate = rate;
			this.rate_score = rate_score;
		}


		@Override
		public int compareTo(Content o) {			
			return Float.compare(o.rate_score, this.rate_score);
		}


		public int getX() {
			return x;
		}


		public int getY() {
			return y;
		}


		public char getRate() {
			return rate;
		}


		public float getRate_score() {
			return rate_score;
		}

	}
}
