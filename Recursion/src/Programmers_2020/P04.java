package Programmers_2020;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//2020 - 가사검색
public class P04 {

	public static void main(String[] args) throws Exception {
			
		String[] words = {
			"frodo", "front", "frost", "frozen", "frame", "kakao"				
		};
		
		String[] queries = {
			"fro??", "????o", "fr???", "fro???", "pro?"				
		};
		
		int[] answer = solution(words, queries);
		
		for(int i=0;i<answer.length;i++) 
		{
			System.out.print(answer[i]+ " ");
		}
	}
	
	public static int[] solution(String[] words, String[] queries) {
		
		int[] answer = new int[queries.length];
		Map<Integer, Trie> prefixStore = new HashMap<>();
		Map<Integer, Trie> suffixStore = new HashMap<>();
		Map<Integer, Integer> entire = new HashMap<>();
		
		for(int i=0;i<words.length;i++) 
		{
			int len = words[i].length();
			if(!prefixStore.containsKey(len)) {
				Trie t = new Trie();
				t.insert(words[i]);
				prefixStore.put(len, t);
			}
			else {
				Trie t = prefixStore.get(len);
				t.insert(words[i]);
			}

			StringBuilder sb = new StringBuilder(words[i]);
			
			if(!suffixStore.containsKey(len)) {
				Trie t = new Trie();
				t.insert(sb.reverse().toString());
				suffixStore.put(len, t);
			}
			else {
				Trie t = suffixStore.get(len);
				t.insert(sb.reverse().toString());				
			}
			
			entire.merge(len, 1, (oldValue, newValue) -> ++oldValue);
		}
		
		for(int i=0;i<queries.length;i++) 
		{
			int len = queries[i].length();
			if(queries[i].charAt(0) == '?' && queries[i].charAt(len-1) == '?') {
				if(!Objects.isNull(entire.get(len))) {
					answer[i] = entire.get(len);					
				}
			}
			//suffix
			else if(queries[i].charAt(0) == '?') {
				StringBuilder sb = new StringBuilder(queries[i]);
				Trie t = suffixStore.get(len);
				if(!Objects.isNull(t)) {
					answer[i] = t.size(sb.reverse().toString());					
				}
			}			
			//prefix
			else if(queries[i].charAt(len-1) == '?') {				
				Trie t = prefixStore.get(len);
				if(!Objects.isNull(t)) {
					answer[i] = t.size(queries[i]);					
				}
			}
		}
		
		return answer;
	}
	
	public static class Trie {
		
		private TrieNode rootNode;
		
		public Trie() {
			this.rootNode = new TrieNode();
		}
		
		//추가
		public void insert(String word) {
			
			TrieNode thisNode = this.rootNode;
			
			for(int i=0;i<word.length();i++)
			{
//				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
				thisNode = thisNode.getChildNodes().merge(word.charAt(i), new TrieNode(), (oldTrieNode, newTrieNode)-> oldTrieNode.addSubTreeSize());
			}
			
			thisNode.setLastChar(true);
		}
		
		//특정 단어가 존재하는지 확인
		public boolean contains(String word) {
			
			TrieNode thisNode = this.rootNode;
			
			for(int i=0;i<word.length();i++)
			{
				char charater = word.charAt(i);
				TrieNode node = thisNode.getChildNodes().get(charater);
				
				if(Objects.isNull(node)) {
					return false;
				}
				
				thisNode = node;
			}
			
			return thisNode.isLastChar();
		}
		
		public int size(String word) {
			
			TrieNode thisNode = this.rootNode;
			for(int i=0;i<word.length();i++) 
			{
				char charater = word.charAt(i);
				if(charater == '?') break;
				TrieNode node = thisNode.getChildNodes().get(charater);				
				
				if(Objects.isNull(node)) return 0;				
				thisNode = node;
			}
			
			return thisNode.getSubTreeSize();
		}
		
		public static int dfs(TrieNode root, int len) {
			
			int cnt = 0;
			
			if(len == 0) {	
				if(root.getChildNodes().size() > 0) return 0;
				return 1;
			}
			
			for(TrieNode node : root.getChildNodes().values()) {
				cnt += dfs(node, len-1);
			}
			return cnt;
		}
		
		public void delete(String word) {
			delete(this.rootNode, word, 0);
		}
		
		private void delete(TrieNode thisNode, String word, int index) {
			
			char charater = word.charAt(index);
			
			if(!thisNode.getChildNodes().containsKey(charater)) {
				throw new IllegalArgumentException();
			}
			
			TrieNode childNode = thisNode.getChildNodes().get(charater);
			index++;
			
			if(index == word.length()) {
				
				if(!childNode.isLastChar()) {
					throw new IllegalArgumentException();
				}
				
				childNode.setLastChar(false);
				
				if(childNode.getChildNodes().isEmpty()) {
					thisNode.getChildNodes().remove(charater);
				}
			}
			else {

				delete(childNode, word, index);
				
				if(!childNode.isLastChar() && childNode.getChildNodes().isEmpty()) {
					thisNode.getChildNodes().remove(charater);
				}
			}
			
		}
	}
	
	public static class TrieNode {
		
		private Map<Character, TrieNode> childNodes = new HashMap<>();
		private boolean isLastChar;
		private int subTreeSize;
				
		public TrieNode() {
			this.subTreeSize = 1;
		}
		
		public Map<Character, TrieNode> getChildNodes() {
			return childNodes;
		}

		public void setChildNodes(Map<Character, TrieNode> childNodes) {
			this.childNodes = childNodes;
		}
		
		public boolean isLastChar() {
			return isLastChar;
		}
		
		public void setLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}

		public int getSubTreeSize() {
			return subTreeSize;
		}

		public TrieNode addSubTreeSize() {
			this.subTreeSize += 1;
			return this;
		}

	}
}
