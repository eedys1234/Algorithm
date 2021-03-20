package Groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P01 {

	public static void main(String[] args) throws Exception {

		//1) ��ī �̿�ð��� �� ������ ��ȯ
		//2) 00:00 ~ 23:59�� ��Ÿ���� total_time �迭 ����
		//3) �� ����ڸ��� ���۽ð��� ����ð��� �� ������ ��ȯ�Ͽ� total �迭�� üũ
		//4) total_time �迭�� Ž���ϸ鼭 ��� ������� ���� �ִ� �� �������� ���� üũ
		//5) ���� ������Ŀ� �´� ���·� ��ȯ

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		//�ο� �� 
		int n = Integer.valueOf(inbr.readLine());
		String[] info = new String[n];
		
		for(int i=0;i<n;i++) 
		{
			info[i] = inbr.readLine();
		}
		
		int[] total_time = new int[1440];
		int[] info_start_minute = new int[n];
		int[] info_end_minute = new int[n];
		int start = 1440;
		int end = 0;
		
		for(int i=0;i<info.length;i++) 
		{
			String[] time = info[i].split(" ~ ");
			info_start_minute[i] = toMinute(time[0]);
			info_end_minute[i] = toMinute(time[1]);
		}
		
		for(int i=0;i<info.length;i++) 
		{
			for(int j=info_start_minute[i];j<=info_end_minute[i];j++) 
			{
				total_time[j] += 1;
			}
		}
		
		for(int i=1;i<total_time.length;i++) 
		{
			if(total_time[i] == n) {
				start = Math.min(start, i);
				end = Math.max(end, i);
			}
		}
		
		if(start == 1440 && end == 0) {
			System.out.println("-1");
			return ;
		}

		System.out.println(toStringTime(start) + " ~ " + toStringTime(end));
	}
	
	public static int toMinute(String str) {
		
		int minute = 0;
		String[] time = str.split(":");
		int i = time.length-1;
		int q = 1;
	
		while(i >= 0) {
			minute += Integer.valueOf(time[i]) * q;
			q *= 60;
			i--;
		}
		
		return minute;
	}
	
	public static String toStringTime(int minute) {
		
		StringBuilder sb = new StringBuilder();
		String[] str = new String[2];
		int i = str.length-1;

		while(i >= 0) {
			str[i] = String.format("%02d", minute%60);
			minute /= 60;
			i--;
		}
		
		sb.append(String.join(":", str));
		return sb.toString();
	}
}
