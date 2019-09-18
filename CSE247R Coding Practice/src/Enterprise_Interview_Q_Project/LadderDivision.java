/**
 * isLadderDivision - original problem created by PTK
 * Given a non-zero array of integers, check to see if it follows this pattern:
 * [5, 8 , 23, 45,  2, 8, -43]
 *  %4, %3, %2, %1, %2, %3, %4 
 * In other words, the middle element should be divisible by 1 and the two elements next to the middle should be divisible by 2 and the elements next to the previous elements should be divisible by 3 and so on. The expansion goes outwards from the middle.
 * 
 * Runtime should be O(n)
 * Space complexity should be O(1)
 */

class LadderDivision {
    public static boolean isLadderDivision(int[] items) {
        if(items.length == 0) {
            return false;
        }

        int len = items.length/2;
        /* If the length is an odd number add len by 1 */
        if(items.length % 2 != 0) {
            len = len + 1;
        }

        for(int i = 0; i < len; i++) {
            int divisor = len - i;
            if(items[i] % divisor != 0 || items[items.length - 1 - i] % divisor != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] items = {6,8,4,2,-26,12};
        System.out.println(isLadderDivision(items));
    }
}
