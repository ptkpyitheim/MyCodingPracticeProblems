

import java.util.*;

/**
 * Google Interview Question for Sophomores
 * I got this sample question from Google Interview Prep Workshop at WashU
 * Given an unsorted array nums, reorder it in-place such that nums[0]<=nums[1]>=nums[2]<=nums[3]...
 * Example: Input = [5,2,3,1,4,8]
 *          Output = [2,5,1,4,3,8] 
 */

class wiggleSort {

    public int[] wiggle(int[] items) {
        boolean up = true;
        int len = items.length;
        for(int i = 0; i < len - 1; i++) {
            if((up && items[i] > items[i + 1]) || (!up && items[i] < items[i + 1])) {
                int temp = items[i];
                items[i] = items[i + 1];
                items[i + 1] = temp;
            }
            up = !up;
        }
        return items;
    }

    public String wiggledResult(int[] result) {
        return Arrays.toString(result);
    }

    public static void main(String[] args) {
        wiggleSort ws = new wiggleSort();

        int[] items = {5,2,3,1,4,8};
        int[] wiggled = ws.wiggle(items);

        System.out.println(ws.wiggledResult(wiggled));
        
    }
}