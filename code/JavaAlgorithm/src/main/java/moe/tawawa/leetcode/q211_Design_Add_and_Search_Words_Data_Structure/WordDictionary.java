package moe.tawawa.leetcode.q211_Design_Add_and_Search_Words_Data_Structure;

/**
 * @author GeeKaven
 * @date 2021/1/26 21:05
 */
public class WordDictionary {

    WNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new WNode();
    }

    public void addWord(String word) {
        WNode node = root;
        for (char c : word.toCharArray()) {
            if (node.getNext()[c - 'a'] == null) {
                node.getNext()[c - 'a'] = new WNode();
            }
            node = node.getNext()[c - 'a'];
        }
        node.setEnd(true);
    }

    public boolean search(String word) {
        return match(word, root, 0);
    }

    private boolean match(String word, WNode node, int start) {
        if (start == word.length()) {
            return node.isEnd();
        }
        char c = word.charAt(start);
        if (c == '.') {
            // 遇到通配符，则每一项不为null的都来匹配
            for (int i = 0; i < 26; i++) {
                if (node.getNext()[i] != null && match(word, node.getNext()[i], start + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.getNext()[c - 'a'] == null) {
                return false;
            }
            return match(word, node.getNext()[c - 'a'], start + 1);
        }
    }

    class WNode {
        private boolean isEnd;
        private WNode[] next;

        WNode() {
            this.isEnd = false;
            this.next = new WNode[26];
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public WNode[] getNext() {
            return next;
        }

        public void setNext(WNode[] next) {
            this.next = next;
        }
    }
}
