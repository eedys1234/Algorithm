package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1080 {

	public static void main(String[] args) {
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int n = Integer.valueOf(temp[0]);
			int m = Integer.valueOf(temp[1]);

			boolean[][] before = new boolean[n][m];
			boolean[][] after = new boolean[n][m];
			int result = 0;
			int cnt = 0;
			
			for(int i=0;i<n;i++) 
			{
				String line = inbr.readLine();
				for(int j=0;j<line.length();j++) 
				{
					before[i][j] = String.valueOf(line.charAt(j)).equals("1")?true:false;
				}
			}

			for(int i=0;i<n;i++) 
			{
				String line = inbr.readLine();
				for(int j=0;j<line.length();j++) 
				{
					after[i][j] = String.valueOf(line.charAt(j)).equals("1")?true:false;
				}
			}
			
			for(int i=0;i<=n-3;i++) 
			{
				for(int j=0;j<=m-3;j++) 
				{
					if(before[i][j] != after[i][j]) 
					{
						for(int k=i;k<=i+2;k++) 
						{
							before[k][j] = !before[k][j];
							before[k][j+1] = !before[k][j+1];
							before[k][j+2] = !before[k][j+2];
							
						}
						result++;
					}
				}
			}
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					if(before[i][j] == after[i][j]) 
					{
						cnt++;
					}
				}
			}
			
			if(cnt == n*m) 
			{			
				System.out.println(result);
			}
			else {
				System.out.println("-1");
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
