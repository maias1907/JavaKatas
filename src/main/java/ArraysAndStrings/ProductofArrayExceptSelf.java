package ArraysAndStrings;
//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
//Example 2:
//
//Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];
        int[] output = new int[nums.length];
        suff[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            suff[i] = suff[i - 1] * nums[i - 1];
        }
        pref[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            pref[i] = pref[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            output[i] = suff[i] * pref[i];
        }
        return output;
    }

    }
