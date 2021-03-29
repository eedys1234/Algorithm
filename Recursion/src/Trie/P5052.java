package Trie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class P5052 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.valueOf(inbr.readLine());
		
		while(t-- > 0) {
			
			boolean isConsistence = true;
			int n = Integer.valueOf(inbr.readLine());
			String[] words = new String[n];
			Trie trie = new Trie();
			
			for(int i=0;i<n;i++) 
			{
				words[i] = inbr.readLine();
				trie.insert(words[i]);
			}
			
			for(int i=0;i<words.length;i++) 
			{
				if(trie.size(words[i]) > 0) {
					isConsistence = false;
					break;
				}
			}
	
			if(isConsistence) {
				sb.append("YES").append("\n");
			}
			else {
				sb.append("NO").append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static class Trie {
		
		TrieNode rootNode;
		
		public Trie() {
			rootNode = new TrieNode();
		}
		
		public void insert(String word) {
			
			TrieNode thisNode = this.rootNode;
			
			for(int i=0;i<word.length();i++)
			{
				thisNode = thisNode.getChildNode().computeIfAbsent(word.charAt(i), c -> new TrieNode());
			}
			
			thisNode.setLastChar(true);
		}
		
		public boolean contains(String word) {
			
			TrieNode thisNode = this.rootNode;
			
			for(int i=0;i<word.length();i++) 
			{
				char charater = word.charAt(i);
				TrieNode node = thisNode.getChildNode().get(charater);
				
				if(Objects.isNull(node)) return false;
				
				thisNode = node;
			}
			
			return thisNode.isLastChar();
		}
		
		public int size(String word) {
			
			TrieNode thisNode = this.rootNode;
			
			for(int i=0;i<word.length();i++) 
			{
				char character = word.charAt(i);
				TrieNode node = thisNode.getChildNode().get(character);
				
				if(Objects.isNull(node)) {
					return 0;
				}
				
				thisNode = node;
			}
			
			return thisNode.getChildNode().size();
		}
				
		public void delete(String word) {			
			delete(this.rootNode, word, 0);
		}
		
		private void delete(TrieNode thisNode, String word, int index) {
			
			char charater = word.charAt(index);

			if(!thisNode.getChildNode().containsKey(charater)) {
				throw new IllegalArgumentException();
			}
			
			TrieNode childNode = thisNode.getChildNode().get(charater);
			index++;
			
			if(index == word.length()) {
				
				if(!childNode.isLastChar()) {
					throw new IllegalArgumentException();
				}
				
				childNode.setLastChar(false);
				
				if(childNode.getChildNode().isEmpty()) {
					thisNode.getChildNode().remove(charater);
				}
			}
			else {
				delete(childNode, word, index);
				
				if(!childNode.isLastChar() && childNode.getChildNode().isEmpty()) {
					thisNode.getChildNode().remove(charater);
				}
			}
		}
	}
	
	public static class TrieNode {
		
		private Map<Character, TrieNode> childNode = new HashMap<>();
		private boolean isLastChar;
		
		public Map<Character, TrieNode> getChildNode() {
			return childNode;
		}
		
		public void setChildNode(Map<Character, TrieNode> childNode) {
			this.childNode = childNode;
		}
		
		public boolean isLastChar() {
			return isLastChar;
		}
		
		public void setLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}
		
		
	}
}
