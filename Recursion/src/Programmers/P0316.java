package Programmers;

//2021 KAKAO BLIND RECRUITMENT - 블라인드 신규아이디
//구현문제
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
		//1단계 모든 대문자를 대응되는 소문자로 치환
		//new_id의 모든 대문자를 소문자로 변경(대문자 -> 소문자)
        new_id = new_id.toLowerCase();
       
        //2단계 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        //정규식을 이용하여 Replace
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        //3단계 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        //정규식을 이용하여 .이 2번이상일경우 . 하나로 치환
        new_id = new_id.replaceAll("[.]{2,}+", ".");
        
        //4단계 마침표(.)가 처음이나 끝에 위치한다면 제거
        new_id = new_id.replaceAll("^[.]", "").replaceAll("[.]$", "");
        
        //5단계 빈 문자열이라면, new_id에 "a"를 대입
        new_id = new_id.length() == 0 ? "a" : new_id;
        
        //6단계 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
        new_id = new_id.length() >= 16 ? new_id.substring(0, 15) : new_id;
        new_id = new_id.replaceAll("[.]$", "");
        
        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙임        
        sb.append(new_id);

        while(sb.length() <= 2) {
        	sb.append(new_id.charAt(new_id.length()-1));
        }
        
        return sb.toString();
    }
}
