package trie;;

//https://leetcode.com/problems/implement-trie-prefix-tree/
public class ImplementTrie {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("vikas");
		System.out.println(trie.search("vikas"));
		System.out.println(trie.search("vik"));
		System.out.println(trie.startsWith("vik"));
		trie.insert("vik");
		System.out.println(trie.search("vik"));
	}

}


class Trie{
	TrieNode root;
	
	Trie(){
		root = new TrieNode('/');
	}
	
	
	public void insert(String word) {
		TrieNode ptr = root;
		
		for(char ch : word.toCharArray()) {
			//System.out.println("curr node = " + ptr.val);
			int index = ch - 'a';
			if(ptr.children[index] == null) {
				ptr.children[index] = new TrieNode(ch);
			}
			ptr = ptr.children[index];
			//System.out.println("next node = " + ptr.val);
		}
		//System.out.println("last node = " + ptr.val);
		ptr.isEnd = true;
	}
	
	public boolean search(String word) {
		TrieNode ptr = root;
		for(char ch : word.toCharArray()) {
			int index = ch - 'a';
			if(ptr.children[index] == null) return false;
			ptr = ptr.children[index];
		}
		return ptr.isEnd;
	}
	
	public boolean startsWith(String prefix) {
		TrieNode ptr = root;
		for(char ch : prefix.toCharArray()) {
			int index = ch - 'a';
			if(ptr.children[index] == null) return false;
			ptr = ptr.children[index];
		}
		return true;
	}
	
}


class TrieNode{
	public char val; //not needed. Useful for debugging purpose
	public boolean isEnd;
	public TrieNode[] children =  new TrieNode[26];;
	
	TrieNode(char ch){
		val = ch;
	}
}
