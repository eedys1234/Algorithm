package Programmers;

//플로이드 와샬 사용
//다익스트라를 사용하지 못하는 이유 : 단순히 어느 한 출발점에서 출발하여 도착지로 가는 것이 아닌 합승하여 출발했을 떄 도착지 이전에 내릴 수도 있기 때문에 구현에 따라 최악의 시간복잡도가 나올 수 있음
//경우의 수 1) 특정 k 지점까지 합승한 후 k지점에서 각자의 목적지까지 가는 경우
//경우의 수 2) 처음부터 각자의 목적지까지 가는 경우
//특정 k지점이 출발지랑 같을경우도 존재하기 때문에 경우의 수 1)로 생각하면 됨
public class P0318 {

	public static void main(String[] args) {
		
//		int n = 6;
//		int s = 4;
//		int a = 6;
//		int b = 2;
//		int[][] fares = {
//			{4, 1, 10}, 
//			{3, 5, 24}, 
//			{5, 6, 2}, 
//			{3, 1, 41}, 
//			{5, 1, 24}, 
//			{4, 6, 50}, 
//			{2, 4, 66}, 
//			{2, 3, 22}, 
//			{1, 6, 25}
//		};

		int n = 7;
		int s = 3;
		int a = 4;
		int b = 1;
		
		int[][] fares = {
			{5, 7, 9}, 
			{4, 6, 4}, 
			{3, 6, 1}, 
			{3, 2, 3}, 
			{2, 1, 6}
		};
		
		System.out.println(solution(n, s, a, b, fares));
	}
	
    public static int solution(int n, int s, int a, int b, int[][] fares) {    	
        int[][] w = new int[n+1][n+1];
        final int INF = 100000000;
        int answer = INF;
        
        for(int i=1;i<=n;i++)
        {
        	for(int j=1;j<=n;j++)
        	{
        		if(i==j) {
            		w[i][j] = 0;        			
        		}
        		else {
        			w[i][j] = INF;
        		}
        	}
        }

        //가중치 행렬
        for(int i=0;i<fares.length;i++) 
        {
        	w[fares[i][0]][fares[i][1]] = fares[i][2];
        	w[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        //all to all 모든 출발지에서 모든 목적지까지 최소비용을 구함        
        for(int k=1;k<=n;k++) 
        {
        	for(int i=1;i<=n;i++)
        	{
        		for(int j=1;j<=n;j++)
        		{
        			w[i][j] = Math.min(w[i][j], w[i][k]+w[k][j]);
        		}
        	}
        }
        
        //출발지 s에서 특정 k지점까지 합승 후 k지점에서 각자의 목적지까지의 비용 계산        
        for(int j=1;j<w[0].length;j++) 
        {
        	answer = Math.min(answer, w[s][j] + w[j][a] + w[j][b]);
        }
        
        return answer;
    }
    
}
