package com.general;

public class ShortestUniquePrefix {

	public static void main(String[] args) {
		ShortestUniquePrefix sePrefix = new ShortestUniquePrefix();
		String[] strArray = { "zebra", "dog", "duck", "dove" };
		sePrefix.search(strArray);

	}

	static class Trie {
		Trie[] child = new Trie[256];
		int freq;

		Trie() {
			freq = 1;
			for (int i = 0; i < 256; i++)
				child[i] = null;
		}
	}

	void insert(String word, Trie root) {
		int len = word.length();
		for (int i = 0; i < len; i++) {
			if (root.child[word.charAt(i)] == null) {
				root.child[word.charAt(i)] = new Trie();
			} else
				root.child[word.charAt(i)].freq++;
			root = root.child[word.charAt(i)];
		}
	}

	void searchPrefixUtils(Trie root, char[] prefix, int indx) {
		if (root == null)
			return;
		if (root.freq == 1) {
			prefix[indx] = '\0';
			int i = 0;
			while (prefix[i] != '\0') {
				System.out.print(prefix[i++]);
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < 256; i++) {
			if (root.child[i] != null) {
				prefix[indx] = (char) i;
				searchPrefixUtils(root.child[i], prefix, indx + 1);
			}
		}
	}

	void search(String[] words) {
		Trie root = new Trie();
		root.freq = 0;
		for (String word : words) {
			insert(word, root);
		}
		searchPrefixUtils(root, new char[256], 0);
	}
}
