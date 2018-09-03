import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;

import javax.net.ssl.SSLEngine;

public class Day1Aug31 {
	//Problem1
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
	public static String reverse(String s) {
		if(s.length() == 0) {
			return s;
		}
		return s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
	}
	
	//Problem4
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
	}

}
