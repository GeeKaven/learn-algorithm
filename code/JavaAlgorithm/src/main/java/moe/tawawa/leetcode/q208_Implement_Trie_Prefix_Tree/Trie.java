package moe.tawawa.leetcode.q208_Implement_Trie_Prefix_Tree;

/**
 * @author GeeKaven
 * @date 2021/1/25 20:44
 */
public class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.getNext()[c - 'a'] == null) {
                node.getNext()[c - 'a'] = new TrieNode();
            }
            node = node.getNext()[c - 'a'];
        }
        node.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.getNext()[c - 'a'] == null) {
                return false;
            }
            node = node.getNext()[c - 'a'];
        }
        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.getNext()[c - 'a'] == null) {
                return false;
            }
            node = node.getNext()[c - 'a'];
        }
        return true;
    }

    class TrieNode {
        private boolean isEnd;
        private TrieNode[] next;

        TrieNode() {
            this.isEnd = false;
            this.next = new TrieNode[26];
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public TrieNode[] getNext() {
            return next;
        }

        public void setNext(TrieNode[] next) {
            this.next = next;
        }
    }
}
