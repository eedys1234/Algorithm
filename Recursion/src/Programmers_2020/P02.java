package Programmers_2020;

//����
public class P02 {
	
	public static void main(String[] args) {
		
		String[] p = {
			"()))((()",
			"(()())()",
			")(",
			")()()()("
		};
		
		for(int i=0;i<p.length;i++) {
			System.out.println(solution(p[i]));			
		}
	}
	
    public static String solution(String p) {

    	int bracketCnt = 0;
        int j = 0;
    	StringBuilder sb = new StringBuilder();        
        
        //1. �Է��� �� ���ڿ��� ���, �� ���ڿ��� ��ȯ
        if(p.length() == 0) {
        	return p;
        }
        
        //2. ���ڿ� w�� �� �������� ���ڿ� u, v�� �и�, u�� "�������� ��ȣ ���ڿ�"�� �� �̻� �и��� �� ����� �ϸ�, v�� �� ���ڿ�        
        for(int i=0;i<p.length();i++) {
 
        	if(p.charAt(i) == '(') {
        		bracketCnt++;
        	}
        	else {
        		bracketCnt--;
        	}
        	
        	if(bracketCnt == 0) {
        		j = i;
        		break;
        	}
        }
        
        String u = p.substring(0, Math.min(j+1, p.length()));
        String v = "";
        if(p.length() > j+1) {
        	v = p.substring(j+1);	
        }
        
        //4�ܰ�
        if(!isProperString(u)) {
        	sb.append("(");
        	sb.append(solution(v));
        	sb.append(")");
        	sb.append(reverseString(u.substring(1, u.length()-1)));
        }
        //3�ܰ�
        else {
        	sb.append(u);
        	sb.append(solution(v));
        }

        return sb.toString();
    }
    
    public static String reverseString(String u) {
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0;i<u.length();i++) {
    		if(u.charAt(i) == ')') {
        		sb.append("(");    			
    		}
    		else {
        		sb.append(")");
    		}
    	}
    	
    	return sb.toString();
    }
    
    public static boolean isProperString(String u) {
    	
    	int bracketCnt = 0;
    	boolean isProper = true;

    	for(int i=0;i<u.length();i++) 
    	{        	
        	if(u.charAt(i) == '(') {
        		bracketCnt++;
        	}
        	else {
        		bracketCnt--;
        	}
        	
        	if(bracketCnt < 0) {
        		isProper = false;
        		break;
        	}
        }
    	
    	return isProper;
    }
}
