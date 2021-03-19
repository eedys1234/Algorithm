package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//스위핑 문제?
//시작점을 기준으로 
public class P0319 {
	
	public static void main(String[] args) {
		
//		String play_time = "02:03:55";
//		String adv_time = "00:14:15";
//		String play_time = "99:59:59";
//		String adv_time = "25:00:00";
		String play_time = "50:00:00";
		String adv_time = "50:00:00";

		String[] logs = {
//			"01:20:15-01:45:14", 
//			"00:40:31-01:00:00", 
//			"00:25:50-00:48:29", 
//			"01:30:59-01:53:29", 
//			"01:37:44-02:02:30"	
//				---------------
//			"69:59:59-89:59:59", 
//			"01:00:00-21:00:00", 
//			"79:59:59-99:59:59", 
//			"11:00:00-31:00:00"
				
			"15:36:51-38:21:49", 
			"10:14:18-15:36:51", 
			"38:21:49-42:51:45"
		};
			
		System.out.println(solution(play_time, adv_time, logs));
	}

    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int cnt = 0;
        
        PriorityQueue<PlayTime> pq = new PriorityQueue<PlayTime>(new Comparator<PlayTime>() {

			@Override
			public int compare(PlayTime o1, PlayTime o2) {
				return o1.end.compareTo(o2.end);
			}

		});

        //정렬
        Arrays.sort(logs);
        
        String[] time = logs[0].split("-");

        if(comparePlayTime(play_time, adv_time) == 0 && 
    		comparePlayTime(subPlayTime(play_time, adv_time), time[0]) < 0) {
        	return "00:00:00";
        }
        
        for(int i=0;i<logs.length;i++) 
        {
        	time = logs[i].split("-");
        	String start = time[0];
        	String end = time[1];
        	
        	pq.offer(new PlayTime(start, end, i));
        	
        	while(!pq.isEmpty() && comparePlayTime(start, pq.peek().end) > 0) {
        		pq.poll();
        	}
        	
        	if(cnt < pq.size()) {  
        		if(comparePlayTime(subPlayTime(pq.peek().end, adv_time), pq.peek().start) < 0) {
            		answer = pq.peek().start;        			
        		}
        		else {
        			time = logs[pq.peek().index+1].split("-");
        			answer = time[0];
        		}
        		cnt = pq.size();
        	}
        }
        
        return answer;
    }
    
    public static String addPlayTime(String str1, String str2) {
    	
    	StringBuilder sb = new StringBuilder();
    	
    	String[] A = str1.split(":");
    	String[] B = str2.split(":");
    	String[] C = new String[3];
    	int sum = 0;
    	int q = 0;
    	
    	for(int i=A.length-1;i>=0;i--) 
    	{
    		sum = Integer.valueOf(A[i]) + Integer.valueOf(B[i]) + q;
    		C[i] = String.valueOf(sum%60<10?"0"+sum%60:sum%60);    		
    		q = sum/60;
    	}	
    	
    	sb.append(String.join(":", C));
    	return sb.toString();
    }
    
    public static String subPlayTime(String str1, String str2) {

    	StringBuilder sb = new StringBuilder();
    	
    	String[] A = str1.split(":");
    	String[] B = str2.split(":");
    	String[] C = new String[3];
    	int diff = 0;
    	int q = 0;
    	
    	for(int i=A.length-1;i>=0;i--) 
    	{
    		diff = Integer.valueOf(A[i]) - Integer.valueOf(B[i]) - q;
    		if(diff < 0 && i > 0) {
    			q = 1;
    			diff += 60;
    		}
    		else {
    			q = 0;
    		}
    		C[i] = String.valueOf(String.valueOf(diff).length()<2?"0"+diff:diff);
    	}
    			
    	sb.append(String.join(":", C));
    	return sb.toString();
    }
    
    public static int comparePlayTime(String str1, String str2) {
    	
    	String[] A = str1.split(":");
    	String[] B = str2.split(":");
    	int i = A.length;
    	int playA = 0;
    	int playB = 0;
    	int multi = 1;
    	
    	while(i-- > 0) {

    		playA += Integer.valueOf(A[i]) * multi;    			
    		playB += Integer.valueOf(B[i]) * multi;    			
    		multi *= 60;    		
    	}
    	    	
    	return playA-playB;
    }
    
    public static class PlayTime {
    	
    	String start;
    	String end;
    	int index;
    	
    	public PlayTime(String start, String end, int index) {
    		this.start = start;
    		this.end = end;
    		this.index = index;
    	}
    }
}
