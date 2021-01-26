package moe.tawawa.leetcode.q212_Word_Search_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GeeKaven
 * @date 2021/1/26 21:28
 */
public class Solution {

    private List<String> ans;
    private boolean[][] marked;
    private final int[] xx = {1,-1,0,0};
    private final int[] yy = {0,0,1,-1};
    public List<String> findWords(char[][] board, String[] words) {

        ans = new ArrayList<>();

        // 通过需要匹配的单词构造字典树
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.getNext().containsKey(c)) {
                    node.getNext().put(c, new TrieNode());
                }
                node = node.getNext().get(c);
            }
            node.setWord(word);
        }

        // 初始化表示，用于判断是否走过
        marked = new boolean[board.length][board[0].length];

        // 从board的每一个字母开始找首字母相同
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 找到有首字母相同，开始以当前字母开始搜索字典树
                if (root.getNext().containsKey(board[i][j])) {
                    search(board, i, j, root);
                }
            }
        }

        return ans;
    }

    private void search(char[][] board, int x, int y, TrieNode parent) {

        // 已经走过了不走了
        if (marked[x][y]) {
            return;
        }

        char c = board[x][y];
        TrieNode curNode = parent.getNext().get(c);

        // 找到已有word，则添加
        if (curNode.getWord() != null) {
            ans.add(curNode.getWord());
            // 已经找到的单词，则删掉
            curNode.setWord(null);
        }

        // 标记走过
        marked[x][y] = true;
        // 开始上，下，左，右遍历
        for (int i = 0; i < 4; i++) {
            int newX = x + xx[i];
            int newY = y + yy[i];
            // 超出边界继续
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) {
                continue;
            }
            // 相邻的字母在当前节点的下一个节点里有，则继续从相邻节点开始递归
            if (curNode.getNext().containsKey(board[newX][newY])) {
                search(board, newX, newY, curNode);
            }
        }
        // 回溯
        marked[x][y] = false;

        // 当前节点没子节点，可以删掉。枝剪
        if (curNode.getNext().isEmpty()) {
            parent.getNext().remove(c);
        }
    }
}

// 字典树，由于通过已有单词构造，可以使用首字母hashmap表示
class TrieNode {
    private String word;
    private Map<Character, TrieNode> next;

    TrieNode() {
        this.next = new HashMap<>();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Map<Character, TrieNode> getNext() {
        return next;
    }

    public void setNext(Map<Character, TrieNode> next) {
        this.next = next;
    }
}
