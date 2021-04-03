package DevMatching;

public class P02 {

	public static void main(String[] args) throws Exception {
		
		int rows = 6;
		int columns = 6;
		
		int[][] queries = {
			{2, 2, 5, 4},
			{3, 3, 6, 6},
			{5, 1, 6, 3}				
		};
		
		solution(rows, columns, queries);
	}
	
    public static int[] solution(int rows, int columns, int[][] queries) {

    	int[] answer = new int[queries.length];
        int[][] metric = new int[rows+1][columns+1];
    	
        for(int i=1;i<metric.length;i++) 
        {
        	for(int j=1;j<metric[0].length;j++)
        	{
        		metric[i][j] = (i-1) * columns + j;
        	}
        }

        for(int i=0;i<queries.length;i++) {
            System.out.println(rotate(metric, queries[i], columns));        	            
        }        

        return answer;
    }
    
    public static void print(int[][] metric) {
    	 for(int i=1;i<metric.length;i++)
         {
         	for(int j=1;j<metric[0].length;j++)
         	{
         		System.out.print(metric[i][j] + " ");
         	}
         	System.out.println();
         }
    }
    
    public static int rotate(int[][] metric, int[] query, int columns) {
    	
    	int min = Integer.MAX_VALUE;
    	int y1 = query[0];
    	int x1 = query[1];
    	int y2 = query[2];
    	int x2 = query[3];
    	
		// x1줄은 아래에서 이동함
		// y1, x1 ~ x2 사이는 왼쪽에서 이동함
		// x2줄은 위에서 이동함
		// y2, x1 ~ x2 사이는 오른쪽에서 이동함
    	
//    	metric[x1][y1] = (i-1) * columns + j;
    	
    	int t = metric[y1][x1];
    	
    	for(int i=y1;i<y2;i++)
    	{
    		metric[i][x1] = metric[i+1][x1];
    		min = Math.min(min, metric[i][x1]);
    	}

    	for(int j=x1;j<x2;j++)
    	{
    		metric[y2][j] = metric[y2][j+1];
    		min = Math.min(min, metric[y2][j]);
    	}
    	
    	for(int i=y2;i>y1;i--) 
    	{
    		metric[i][x2] = metric[i-1][x2];
    		min = Math.min(min, metric[i][x2]);
    	}

    	for(int j=x2;j>x1;j--)
    	{
    		metric[y1][j] = metric[y1][j-1];
    		min = Math.min(min, metric[y1][j]);
    	}

    	metric[y1][x1+1] = t;
    	
    	min = Math.min(min, t);
    	return min;
    }
}
