package foroffer;

public class Lcof35 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        cloneNodeList(head);
        linkCloneNodeRandom(head);
        return spiltCloneNode(head);
    }

    private void cloneNodeList(Node head) {
        Node currNode = head;
        while (currNode != null) {
            Node nextNode = currNode.next;
            Node cloneNode = new Node(currNode.val);
            cloneNode.next = currNode.next;
            currNode.next = cloneNode;
            currNode = nextNode;
        }
    }

    private void linkCloneNodeRandom(Node head) {
        Node currNode = head;
        while (currNode != null) {
            Node cloneNode = currNode.next;
            if (currNode.random != null) {
                cloneNode.random = currNode.random.next;
            }
            currNode = cloneNode.next;
        }
    }

    private Node spiltCloneNode(Node head) {
        Node currNode = head;
        Node cloneHead = null;
        Node cloneNode = null;
        if (currNode != null) {
            cloneHead = currNode.next;
            cloneNode = currNode.next;
            currNode.next = cloneNode.next;
            currNode = currNode.next;
        }
        while (currNode != null) {
            cloneNode.next = currNode.next;
            cloneNode = cloneNode.next;
            currNode.next = cloneNode.next;
            currNode = currNode.next;
        }
        return cloneHead;
    }
}


