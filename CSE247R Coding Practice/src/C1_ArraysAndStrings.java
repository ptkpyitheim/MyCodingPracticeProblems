
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
            Runtime - O(s)
            Space Complexity - O(s)
        */

        // String[] splitted = s.split(" ");
        // StringBuilder result = new StringBuilder();
        // for(int i = 0; i < splitted.length; i++) {
        //     result.append(splitted[i]);
        //     if(splitted.length - 1 == i) {
        //         break;
        //     }
        //     result.append("%20");
        // }
        // return result.toString();

        /**
         * In place using characters.
         * Runtime - O(N)
         * Space complexity - O(1)
         */
        int spaceCount = 0;
        char[] strChar = s.toCharArray();
        for(int i = 0; i < l; i++) {
            if(strChar[i] == ' ') {
                spaceCount ++;
            }
        }

        int newLength = l + spaceCount * 2; //*2 because space itself is a count of %20
        // strChar[newLength] = '\0';
        for(int i = l - 1; i >= 0; i--) {
            // System.out.println("asdf");
            if(strChar[i] == ' ') {
                strChar[newLength - 1] = '0';
                strChar[newLength - 2] = '2';
                strChar[newLength - 3] = '%';
                newLength = newLength - 3;
            }
            else {
                strChar[newLength - 1] = strChar[i];
                newLength = newLength - 1;
            }
        }

        return new String(strChar); 
    }

    /*********************************************/

    /**
     * 1.4 Palindrome Permutation
     */
    public static boolean PalPerm(String s) {
        /**
         * Use HashMap to count
         * Runtime - O(N)
         * Space - O(N)
         */
        HashMap<Character, Integer> myMap = new HashMap<>();
        char[] str = s.toLowerCase().toCharArray();
        for(int i = 0; i < str.length; i++) {
            if(!myMap.containsKey(str[i])) {
                myMap.put(str[i], 1);
            }
            else {
                myMap.put(str[i], myMap.get(str[i]) + 1);
            }
        }

        int isOneCount = 0;
        for(Map.Entry<Character,Integer> entry : myMap.entrySet()) {
            if(isOneCount > 1) {
                return false;
            }
            if(entry.getValue() == 1) {
                isOneCount += 1;
            }
            if(entry.getValue() > 2) {
                return false;
            }

        }
        return true;
    }


    /*********************************************/

    /**
     * 1.5 One Away
     */
    public static boolean oneAway(String s, String d) {
        char[] a = s.toCharArray();
        char[] b = d.toCharArray();
        if(Math.abs(a.length - b.length) > 1) {
            return false;
        }
        int aIndex = 0;
        int bIndex = 0;
        int oneCount = 0;
        while(aIndex < a.length && bIndex < b.length) {
            if(oneCount > 1) {
                return false;
            }
            if(a[aIndex] != b[bIndex]) {
                oneCount++;
            }
            aIndex++;
            bIndex++;
        }
        return true;

    }

    /*********************************************/

    /**
     * 1.6 String Compression
     */
    public static String stringCompression(String s) {
        char[] str = s.toLowerCase().toCharArray();
        StringBuilder result = new StringBuilder();

        if(str.length <= 1) {
            return s;
        }

        int count = 1;
        int p1 = 0;
        int p2 = 1;
        while(p2 < str.length) {
            if(str[p1] == str[p2]) {
                count++;
            }
            else {
                result.append(str[p1]);
                result.append(count);
                count = 1;
                p1 = p2;
            }
            // System.out.println(str[p1]);
            p2++;
        }
        return (result.toString().length() >= s.length()) ? s : result.toString();
        
    }

    /*********************************************/

    /**
     * 1.9 String Rotation
     */
    public static boolean stringRotation(String s1, String s2) {
        return true;
    }


    public static void main (String[] args) {
        // String test = "abcdef";

        // System.out.print("Testing isUnique: ");
        // boolean result = isUnique(test);
        // System.out.println(result);

        // System.out.println(checkPerm("a", "a"));

        // System.out.println(urlify("Mr John Smith      ", 13));

        // System.out.println(PalPerm("abcdefedcba"));

        // System.out.println(oneAway("pale", "bake"));

        System.out.println(stringCompression("abbbccdd"));
    }
}