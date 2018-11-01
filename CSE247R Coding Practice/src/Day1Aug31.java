import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;

import javax.net.ssl.SSLEngine;

public class Day1Aug31 {
	//Problem1
	/*
	 * TwoSum: Given an array of integers, return indices of the two numbers such that they add up to
	 * a specific target. You may assume that each input would have exactly one solution, and
	 * you may not use the same element twice (What if there are duplicates?)
	 */
	public static int findTarget(int target, int[] array) {
		HashSet<Integer> mySet = new HashSet<Integer>();
		HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		int rem = 0;
		int index = 0;
		int index2 = 0;
		
		for (int i=0; i<array.length; i++) {
			myMap.put(array[i],  i);
			mySet.add(array[i]);
		}
		
		for (int i=0; i<array.length; i++) {
			rem = target - array[i];
			if(mySet.contains(rem)) {
				index = i;
				break;
			}
		}
		
		index2 = myMap.get(rem);
		System.out.println("Two indices are: " + index + " " + index2);
		return 0;
	}
	
	//Problem2
	/*
	 * Palindrome: Given a string, write a program that returns a boolean, indicating
	 * whether or not it is a palindrome. hint: .toCharArray();
	 */
	public static boolean isPal(String pal) {
		if(pal.length()==0 || pal.length()==1) {
			return true;
		}
		if (pal.charAt(0) == pal.charAt(pal.length()-1)) {
			return isPal(pal.substring(1, pal.length()-1));
		}
		return false;
	}
	
	//Problem3
	/*
	 * Reverse Strings: Given a string, write a function that returns a string with each
	 * word reversed individually (Reverse letters in each word).
	 */
	public static String reverse(String s) {
		if(s.length() == 0) {
			return s;
		}
		return s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
	}
	
	//Problem4
	/*
	 * Repeated words in a string: Given a sentence(string), write a function that returns a string
	 * with each word replaced by Y if it has been seen before or N otherwise.
	 * TRY THIS PROBLEM WITH RECURION!
	 */
	public static StringBuilder repeatWords(String word) {
		HashMap<Character,Integer> myMap = new HashMap<Character,Integer>();
		StringBuilder newStr = new StringBuilder();
		char[] words = word.toCharArray();
		for (int i = 0; i<words.length; i++) {
			if(!myMap.containsKey(words[i])) {
				myMap.put(words[i],  1);
			}
			else {
				myMap.put(words[i], myMap.get(words[i]) +1);
			}
		}
		//If the myMap.get(words[i]) is greater than one, you want to set that letter to Y. If not, N.
		
		for (int i = 0; i < words.length; i++) {
			if (myMap.get(words[i]) > 1) {
				//set that character to Y
				newStr.append('Y');
			}
			else {	
				//set that character to N
				newStr.append('N');
			}	
		}
		return newStr;
	}
	
	//Problem5
	/*
	 * Merge two sorted arrays: Given two sorted arrays, write a function 
	 * that returns an array with the elements of the arrays merged in sorted order.
	 */
	public static int[] sortedArray(int[] arr1, int[] arr2) {
		
		return arr1;
	}
	
	//My own practice problem
	/* Write a function that inserts the given letter in between the letters of a given string.
	 * E.g. "duck" would return "dauacak"
	 */
	public static String addsLetter(String s, String d) {
		if (s.length() == 1) {
			return s;
		}
		return s.charAt(0) + d + addsLetter(s.substring(1, s.length()),d);
	}

	
	
	
	
	//MAIN FUNCTION
	public static void main(String[] args) {
		//Problem1Test
//		int [] array = {1,1,2,2,4,6,2};
//		findTarget(7, array);
		
//		//Problem2Test
//		System.out.println(isPal("racecar"));
		
		//Problem3Test
//		System.out.println(reverse("bear"));
		
		//Problem4Test
		System.out.println(repeatWords("killing"));
		
		//MyPracticeProblemTest
		System.out.println(addsLetter("Washington", "a"));
	}

}
