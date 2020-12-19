package moe.tawawa.foroffer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lcof36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    private Node headNode = null;
    private Node preNode = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        buildDoublyList(root);
        headNode.left = preNode;
        preNode.right = headNode;
        return headNode;
    }

    public void buildDoublyList(Node curNode) {
        if (curNode == null) {
            return;
        }

        if (curNode.left != null) {
            buildDoublyList(curNode.left);
        }

        curNode.left = preNode;

        if (preNode != null) {
            preNode.right = curNode;
        } else {
            headNode = curNode;
        }

        preNode = curNode;

        if (curNode.right != null) {
            buildDoublyList(curNode.right);
        }

    }

    @Test
    public void test() {
        Node node10 = new Node(10);
        Node node6 = new Node(6);
        Node node4 = new Node(4);
        Node node8 = new Node(8);
        Node node14 = new Node(14);
        Node node12 = new Node(12);
        Node node16 = new Node(16);
        node10.left = node6;
        node10.right = node14;
        node6.left = node4;
        node6.right = node8;
        node14.left = node12;
        node14.right = node16;
        Node list = treeToDoublyList(node10);
        Assertions.assertTrue(true);
    }
}
