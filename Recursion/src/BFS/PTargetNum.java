package BFS;

public class PTargetNum {

    public static boolean[] visited;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        visited = new boolean[numbers.length];
        
        answer = go(numbers, target, 0);
        return answer;
    }
    
    public static int go(int[] numbers, int target, int k) {
        
        if(k == numbers.length) {
            
            int sum = 0;
            for(int i=0;i<numbers.length;i++) {
                if(visited[i]) {
                    sum += numbers[i];
                }
                else {
                    sum -= numbers[i];
                }
            }
            
            if(sum == target) {
                return 1;
            }
            return 0;
        } 
        int cnt = 0;
        
        for(int i=0;i<2;i++) {
            visited[k] = !visited[k];
            cnt += go(numbers, target, k+1);
        }
        
        return cnt;        
    } 
}
