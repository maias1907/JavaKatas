package ArraysAndStrings;
//Given an integer array nums, find the subarray with the largest sum, and return its sum.
//
//
//
//Example 1:
//
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.
//Example 2:
//
//Input: nums = [1]
//Output: 1
//Explanation: The subarray [1] has the largest sum 1.
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
         int i=0;
         int currentSum=nums[0],maxSum=nums[0];
         for(i=1;i<nums.length;i++)
         {
             currentSum=Math.max(currentSum+nums[i],nums[i]);
             maxSum=Math.max(currentSum,maxSum);
         }
         return maxSum;
    }
}
