
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int val) {
        this.val = val;
        next = null;
    }

    void appendToTail(int val) {
        Node end = new Node(val);
        Node n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    String print() {
        Node p = this;
        StringBuilder result = new StringBuilder();
        while(p != null) {
            result.append(p.val);
            p = p.next;
        }
        return result.toString();
    }
}


class C2_LinkedLists {
    /**
     * 2.1 Remove Dups - From an unsorted linked list.
     * Runtime - O(N^2)
     * Space - O(1)
     */
    public static Node removeDups(Node head) {
        Node p1 = head; 
        while(p1 != null) {
            Node p2 = p1;
            while(p2.next != null) {
                if(p2.next.val == p1.val) {
                    p2.next = p2.next.next;
                }
                else {
                    p2 = p2.next;
                }
            }
            p1 = p1.next;
        }
        return head;
    }

    /**
     * 2.2 Return Kth to Last
     */
    public static Node kToLast(Node head, int k) {
        Node p1 = head, p2 = head, iterator = head;
        int length = 0;

        while(iterator != null) {
            length++;
            iterator = iterator.next;
        }

        if(k >= length) {
            System.out.println("k is not valid");
            return head;
        }

        for(int i = 0; i < k; i++) {
            p2 = p2.next;
        }

        while(p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    /**
     * 2.3 Delete Middle Node
     */
    public static String deleteMiddleNode(Node head) {
        Node current = head, runner = head, toSkip = head;
        if(head == null) {
            return "Empty head";
        }
        while(runner != null && runner.next != null) {
            runner = runner.next.next;
            toSkip = current;
            current = current.next;
            if(runner.next != null && runner.next.next == null) { //If length of the linked list is even
                toSkip.next = toSkip.next.next;
                System.out.println("Middle value deleted list is: " + head.print());
                return "Middle value is is: " + current.val;
            }
        }
        toSkip.next = toSkip.next.next;
        System.out.println("Middle value deleted list is: " + head.print());

        return "Middle value is is: " + current.val;
    }

    public static void main(String[] args) {

        Node head = new Node(2);
        head.appendToTail(3);
        head.appendToTail(2);
        head.appendToTail(4);
        head.appendToTail(2);
        // head.appendToTail(4);

        System.out.println(head.print());
        // System.out.println(removeDups(head).print());
        // System.out.println(kToLast(head, 3).print());
        // System.out.println(deleteMiddleNode(head));

    }
}