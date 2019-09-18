
import java.util.*;
import java.io.*;

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
        if(p == null) {
            return "Linked List is null";
        }
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


    /**
     * 2.5 Sum Lists
     * Runtime - O(max(len(h1), len(h2)))
     * Space complexity - O(1)
     */
    public static Node sumLists(Node h1, Node h2) {
        Node result = new Node(0);
        Node p = h1, q = h2, r = result;
        int carry = 0, sum = 0, rem = 0;

        while(p != null || q != null) {
            if(p != null && q != null) {
                sum = p.val + q.val + carry;
                carry = sum / 10;
                rem = sum % 10;
                r.next = new Node(rem);
                p = p.next;
                q = q.next;
            }
            else if(p == null && q != null) {
                sum = q.val + carry;
                carry = sum / 10;
                rem = sum % 10;
                r.next = new Node(rem);
                q = q.next;
            }
            else if(q == null && p != null) {
                sum = p.val + carry;
                carry = sum / 10;
                rem = sum % 10;
                r.next = new Node(rem);
                p = p.next;
            }
            
            r = r.next;
        }

        if(carry != 0) {
            r.next = new Node(1);
        }
        return result.next;
    }

    /**
     * 2.6 Palindrome Linked List
     * @param Singly_Linked_List_of_characters
     * @return boolean
     */
    public static boolean isPalLinkedList(Node h) {
        if(h == null || h.next == null) {
            return false;
        }
        Node p = h, q = h, r = h, middle = null;
        //Find the middle node
        while(r != null && r.next != null) {
            q = q.next;
            r = r.next.next;
            System.out.println("Executed");
        }
        middle = q;

        Stack<Integer> halfList = new Stack<Integer>();
        while(q.next != null) {
            q = q.next;
            halfList.push(q.val);
            halfList.peek();
        }

        if(halfList.isEmpty()) {
            return false;
        }

        while(p != middle) {
            if(p.val != halfList.pop()) {
                return false;
            }           
            p = p.next; 
        }

        return true;
    }

     /**
      * 2.7 Intersection
      * @param 2 singly linked lists
      * @return intersecting node
      Detect if kth node of the first linked list is the exact smae node (by reference) as the jth node of the second linked list.
      */

      /**
       * Loop detection
       * @param circular_linked_list
       * @return boolean and print out the node where the loop occurs
       */
      public static Node isLoop(Node head) {
        if(head == null || head.next == null) {
            return null;
        }
        Node slow2 = new Node(0), slow = head, fast = head;
        slow2.next = head;

        while(fast.next != null || fast != null) {
            fast = fast.next.next;
            slow = slow.next;
            slow2 = slow2.next;
            if(fast == slow || fast == slow2) { 
                return fast;
            }
        }

        return head;
      }


    public static void main(String[] args) {

        Node head = new Node(9);
        Node secondNode = new Node(4);
        Node thirdNode = new Node(4);
        Node fourthNode = new Node(4);

        head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = secondNode;
        
        // head.appendToTail(9);
        // head.appendToTail(4);
        // head.appendToTail(9);

        Node head2 = new Node(4);
        // head2.appendToTail(3);
        // head2.appendToTail(9);

        // System.out.println(head.print());

        // System.out.println(removeDups(head).print());
        // System.out.println(kToLast(head, 3).print());
        // System.out.println(deleteMiddleNode(head));
        // System.out.println(sumLists(head, head2).print());
        // System.out.println(isPalLinkedList(head));
        // System.out.println(isLoop(head).print());
    }
}