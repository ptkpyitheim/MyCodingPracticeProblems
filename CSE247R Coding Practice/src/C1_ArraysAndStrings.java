
import java.util.*;

public class C1_ArraysAndStrings {

    //1.1 Check if a string has unique characters
    public static boolean isUnique(String s) {
        if(s.length() == 0 || s.length() == 1) {
            return true;
        }
        /* 
            Using additional data structure - HashSet
            Runtime - O(n)
            Space complexity - O(n) 
        */
        HashSet<Character> mySet = new HashSet<Character>();
        for(int i = 0; i < s.length() - 1; i++) {
            mySet.add(s.charAt(i));
            if(mySet.contains(s.charAt(i + 1))) {
                return false;
            }
        }

        /* 
            Without using any additional data structure
            Runtime - O(n^2)
            Space complexity - O(1)
        */
        // for (int i = 0; i < s.length(); i++) {
        //     for(int j = i + 1; j < s.length(); j++) {
        //         if(s.charAt(i) == s.charAt(j)) {
        //             return false;
        //         }
        //     }
        // }

        return true;
    }

    /*********************************************/

    //1.2 Check Permutation
    public static boolean checkPerm(String a, String b) {
        /*
            Use HashMap to store counts of each character in String a and compare it with String b
            Runtime - O(max(a,b))
            Space - O(a)
        */

        HashMap<Character, Integer> firstMap = new HashMap<>();

        for(char ch: a.toCharArray()) {
            if(!firstMap.containsKey(ch)) {
                firstMap.put(ch, 1);
                continue;
            }
            firstMap.put(ch, firstMap.get(ch) + 1);
        }

        for(int i = 0; i < b.length(); i++) {
            if(firstMap.containsKey(b.charAt(i))) {
                firstMap.put(b.charAt(i), firstMap.get(b.charAt(i)) - 1);
            }
            else {
                return false;
            }
        }

        for (Map.Entry<Character,Integer> entry : firstMap.entrySet()) {
            if(entry.getValue() != 0) {
                return false;
            }
        }
        
        return true;
    }

    /*********************************************/

    /* 
        1.3 URLify: Replace all spaces in a string with %20. Assume the string has sufficient space at the end to hold the additional characters. Do the operation in place using character array.
        Example     Input: "Mr John Smith    ", 13
                    Output: "Mr%20John%20Smith"
    */
    public static String urlify(String s, int l) {
        /*
            Using StringBuilder
            Runtime - O(l)
            Space Complexity - O(s)
        */

        String[] splitted = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < splitted.length; i++) {
            result.append(splitted[i]);
            if(splitted.length - 1 == i) {
                break;
            }
            result.append("%20");
        }
        return result.toString();
        
    }
    

    public static void main (String[] args) {
        // String test = "abcdef";

        // System.out.print("Testing isUnique: ");
        // boolean result = isUnique(test);
        // System.out.println(result);

        // System.out.println(checkPerm("a", "a"));

        System.out.println(urlify("Mr John Smith      ", 8));
    }
}