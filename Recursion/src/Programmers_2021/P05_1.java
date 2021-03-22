package Programmers_2021;

public class P05_1 {

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
			
		System.out.println(toTimePeriod(359999));
//		System.out.println(solution(play_time, adv_time, logs));
	}
	
    public static String solution(String play_time, String adv_time, String[] logs) {

    	String answer = "";
    	
    	//비교하기 쉬운 초로 변환
    	int play_time_sec = toTimeSec(play_time);
    	int adv_time_sec = toTimeSec(adv_time);
    	
    	int[] logs_start_sec = new int[logs.length];
    	int[] logs_end_sec = new int[logs.length];
    	long[] total_time = new long[360000];
    	
    	long sum = 0;
    	long max = -1;
    	int result = 0;
    	
    	for(int i=0;i<logs.length;i++) 
    	{
    		String[] period = logs[i].split("-");
    		logs_start_sec[i] = toTimeSec(period[0]);
    		logs_end_sec[i] = toTimeSec(period[1]);
    	}
    	
    	//각 플레이 구간마다 재생구간 개수 구하기
    	//듬성듬성 있음
    	//swiping
    	for(int i=0;i<logs.length;i++) 
    	{
    		total_time[logs_start_sec[i]] += 1;
    		total_time[logs_end_sec[i]] -= 1;    		
    	}
    	
    	//재생되는 구간 개수 누적합
    	for(int i=1;i<total_time.length;i++) 
    	{
    		total_time[i] += total_time[i-1];
    	}
    	
    	//플레이 시간 누적합
    	for(int i=1;i<total_time.length;i++) 
    	{
    		total_time[i] += total_time[i-1];
    	}
    	
    	for(int i=adv_time_sec-1;i<play_time_sec;i++) 
    	{
    		if(i >= adv_time_sec)
    			sum = total_time[i] - total_time[i-adv_time_sec];
    		
    		else {
    			sum = total_time[i];
    		}
    		
    		if(max < sum) {
    			max = sum;
    			//시작시간 구하기
    			result = i - adv_time_sec + 1;
    		}
    	}    	    	
    	
    	return toTimePeriod(result);
    }
    
    public static int toTimeSec(String play) {
    	
    	String[] time = play.split(":");
    	int multi = 1;
    	int sec = 0;

    	for(int i=time.length-1;i>=0;i--) {    		
    		sec += Integer.valueOf(time[i]) * multi;
    		multi *= 60;
    	}
    	
    	return sec;
    }
    
    public static String toTimePeriod(int time) {

    	StringBuilder sb = new StringBuilder();
    	String[] C = new String[3];
    	int i = C.length-1;

    	while(i >= 1) {
    		C[i] = String.format("%02d", time%60);
    		time /= 60;
    		i--;
    	}

    	C[i] = String.format("%02d", time);
    	
    	sb.append(String.join(":", C));    	
    	return sb.toString();
    }
}
