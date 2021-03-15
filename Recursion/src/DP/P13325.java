package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//재귀
public class P13325 {

	public static int[] tree;
	public static int result = 0;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			tree = new int[1<<(n+1)+1];
			
			String[] temp = inbr.readLine().split(" ");
			
			//엣지 가중치를 node 값으로 변환하여 생각
			for(int i=0;i<temp.length;i++) {
				tree[i+2] = Integer.valueOf(temp[i]);
			}
			
			go(1);
			System.out.println(result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int go(int root) {

		//리프노드 일경우
		if(root * 2 >= tree.length-1) {			
			result += tree[root];
			return tree[root];
		}
		else {

			int leftNode = go(root * 2);
			int rightNode = go(root * 2 + 1);
			
			//현재노드와 왼쪽에서의 합과 오른쪽에서의 합 간 차를 더함(작은 쪽을 큰 쪽으로 변환하기 위해서)
			result += tree[root] + Math.abs(leftNode - rightNode);
			return tree[root] + Math.max(leftNode, rightNode);
		}
		
	}
}
