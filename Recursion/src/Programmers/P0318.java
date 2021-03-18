package Programmers;

//�÷��̵� �ͼ� ���
//���ͽ�Ʈ�� ������� ���ϴ� ���� : �ܼ��� ��� �� ��������� ����Ͽ� �������� ���� ���� �ƴ� �ս��Ͽ� ������� �� ������ ������ ���� ���� �ֱ� ������ ������ ���� �־��� �ð����⵵�� ���� �� ����
//����� �� 1) Ư�� k �������� �ս��� �� k�������� ������ ���������� ���� ���
//����� �� 2) ó������ ������ ���������� ���� ���
//Ư�� k������ ������� ������쵵 �����ϱ� ������ ����� �� 1)�� �����ϸ� ��
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

        //����ġ ���
        for(int i=0;i<fares.length;i++) 
        {
        	w[fares[i][0]][fares[i][1]] = fares[i][2];
        	w[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        //all to all ��� ��������� ��� ���������� �ּҺ���� ����        
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
        
        //����� s���� Ư�� k�������� �ս� �� k�������� ������ ������������ ��� ���        
        for(int j=1;j<w[0].length;j++) 
        {
        	answer = Math.min(answer, w[s][j] + w[j][a] + w[j][b]);
        }
        
        return answer;
    }
    
}
