package Programmers;

//2021 KAKAO BLIND RECRUITMENT - ����ε� �űԾ��̵�
//��������
public class P0316 {
	
	public static void main(String[] args) {
		
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println(solution("z-+.^."));
		System.out.println(solution("=.="));
		System.out.println(solution("123_.def"));
		System.out.println(solution("abcdefghijklmn.p"));
				
	}	
	
	public static String solution(String new_id) {
		
		StringBuilder sb = new StringBuilder();
		//1�ܰ� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ
		//new_id�� ��� �빮�ڸ� �ҹ��ڷ� ����(�빮�� -> �ҹ���)
        new_id = new_id.toLowerCase();
       
        //2�ܰ� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� ����
        //���Խ��� �̿��Ͽ� Replace
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        //3�ܰ� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ
        //���Խ��� �̿��Ͽ� .�� 2���̻��ϰ�� . �ϳ��� ġȯ
        new_id = new_id.replaceAll("[.]{2,}+", ".");
        
        //4�ܰ� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� ����
        new_id = new_id.replaceAll("^[.]", "").replaceAll("[.]$", "");
        
        //5�ܰ� �� ���ڿ��̶��, new_id�� "a"�� ����
        new_id = new_id.length() == 0 ? "a" : new_id;
        
        //6�ܰ� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� ����
        //���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� ����
        new_id = new_id.length() >= 16 ? new_id.substring(0, 15) : new_id;
        new_id = new_id.replaceAll("[.]$", "");
        
        //7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ����        
        sb.append(new_id);

        while(sb.length() <= 2) {
        	sb.append(new_id.charAt(new_id.length()-1));
        }
        
        return sb.toString();
    }
}
