
import java.util.*;
import java.util.HashSet;
import java.util.LinkedList;

// LinkedList class

class Node {
	
	Node next;
	int data;
	
	public Node(int d) {
		data = d;
	}
	
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while(n.next != null) {
			n = n.next;
		}
		n.next = null;
	}
	
	
	
}


public class CTCIProblems {
	
	
	/*
	 * Problem.
	 * Remove duplicate from an unsorted linkedlist
	 */
	
	public static void removeDup(Node h) {
		HashSet<Integer> hs = new HashSet<Integer>();
		Node temp = h;
		if(temp == null) {
			return;
		}
		
		while(temp.next != null) {
			boolean isDup = hs.add(temp.next.data);
			if(!isDup) {
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}
	}
	
	
	
	

	public static void main(String[] args) {
		
		Node test = new Node(2);
		test.appendToTail(8);
		test.appendToTail(9);
		test.appendToTail(4);
		test.appendToTail(8);
		
		
		while (test != null) {
			System.out.println(test.data);
			test = test.next;
		}
		
		removeDup(test);
		
		while (test != null) {
			System.out.println(test.data);
			test = test.next;
		}

	}

}
