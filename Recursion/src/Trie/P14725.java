package Trie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P14725 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(inbr.readLine());
		Trie trie = new Trie();
		
		for(int i=0;i<n;i++) 
		{
			String[] temp = inbr.readLine().split(" ");
			int k = Integer.valueOf(temp[0]);
			String[] words = new String[k];

			for(int j=0;j<k;j++) 
			{
				words[j] = temp[j+1];
			}
			
			trie.insert(words);
			
		}
		
		trie.print();
				
	}
	
	public static class Trie {
		
		private TrieNode rootNode;
		
		public Trie() {
			this.rootNode = new TrieNode("");
		}
		
		public void insert(String[] words) {
			
			TrieNode thisNode = this.rootNode;
			
			for(int i=0;i<words.length;i++) 
			{
				thisNode = thisNode.getChildNodes().computeIfAbsent(words[i], TrieNode::new);
			}
			
			thisNode.setLastChar(true);
		}
		
		public void print() {
			print(this.rootNode, 0);
		}
		
		private void print(TrieNode thisNode, int level) {
			
			//thisNode childNodes 사전순으로 sort 
			
			if(!thisNode.getChildNodes().isEmpty()) {

				Set<String> keys = thisNode.getChildNodes().keySet();			
				List<String> keyList = new LinkedList<>(keys);
				
				Collections.sort(keyList, new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						if(o1.compareTo(o2) == 0) {
							return Integer.compare(o1.length(), o2.length());
						}
						return o1.compareTo(o2);
					}
				});

				for(int i=0;i<keyList.size();i++)
				{
					TrieNode t = thisNode.getChildNodes().get(keyList.get(i));
					
					for(int j=0;j<level;j++) {
						System.out.print("--");
					}
					System.out.println(keyList.get(i));
					print(t, level+1);
				}
			}
		}		
	}
	
	public static class TrieNode {
		
		private Map<String, TrieNode> childNodes = new HashMap<>();
		private boolean isLastChar;
		private String name;
		
		public TrieNode(String name) {
			this.name = name;
		}
		
		public Map<String, TrieNode> getChildNodes() {
			return childNodes;
		}
		
		public void setChildNodes(Map<String, TrieNode> childNodes) {
			this.childNodes = childNodes;
		}
		
		public boolean isLastChar() {
			return isLastChar;
		}
		
		public void setLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}
	
	}
}
