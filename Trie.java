/**
 * Problem statement:
 * Implement a trie with insert, search, and startsWith methods
 *
 * Assumption:
 * You may assume that all inputs are consist of lowercase letter a-z.
 */
public class Trie {
	static class TrieNode {
		TrieNode[] children;
		boolean isWord;
		TrieNode() {
			children = new TrieNode[26];
			isWord = false;
		}
	}

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	/* insert a word into the trie */
	public void insert(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); ++i) {
			int index = word.charAt(i) - 'a';
			if (cur.children[index] == null) {
				cur.children[index] = new TrieNode();
			}
			cur = cur.children[index];
		}
		cur.isWord = true;
	}

	/* return if the word is in the trie */
	public boolean search(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); ++i) {
			int index = word.charAt(i) - 'a';
			if (cur.children[index] == null) {
				return false;
			}
			cur = cur.children[index];
		}
		return cur.isWord;
	}

	/* return if there is any word in the trie that starts with the given prefix */
	public boolean startsWith(String prefix) {
		TrieNode cur = root;
		for (int i = 0; i < prefix.length(); ++i) {
			int index = prefix.charAt(i) - 'a';
			if (cur.children[index] == null) {
				return false;
			}
			cur = cur.children[index];
		}
		return true;
	}
}
