package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//���
public class P13325 {

	public static int[] tree;
	public static int result = 0;
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.valueOf(inbr.readLine());
			tree = new int[1<<(n+1)+1];
			
			String[] temp = inbr.readLine().split(" ");
			
			//���� ����ġ�� node ������ ��ȯ�Ͽ� ����
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

		//������� �ϰ��
		if(root * 2 >= tree.length-1) {			
			result += tree[root];
			return tree[root];
		}
		else {

			int leftNode = go(root * 2);
			int rightNode = go(root * 2 + 1);
			
			//������� ���ʿ����� �հ� �����ʿ����� �� �� ���� ����(���� ���� ū ������ ��ȯ�ϱ� ���ؼ�)
			result += tree[root] + Math.abs(leftNode - rightNode);
			return tree[root] + Math.max(leftNode, rightNode);
		}
		
	}
}
