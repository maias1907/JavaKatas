package ArraysAndStrings;

import java.util.Arrays;

public class TwoSum {
    //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    //
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //
    //You can return the answer in any order.
   public int[] twoSum(int[] nums, int target) {
       int [] res={-1,-1};
       int i=0,num2=0,heigh=nums.length-1,low=0,mid;
       Arrays.sort(nums);
       for(i=0;i<nums.length;i++)
       {
            res[0]=i;
            num2=target-nums[i];
            while(low<=heigh)
            {
               mid=(low+heigh) /2;
               if(nums[mid]==num2 && mid!=res[0])
               {
                   res[1]=mid;
                   return res;
               }
               else if(nums[mid]<num2)
               {
                   low=mid+1;

               }
               else{
                   heigh=mid-1;
               }
            }

       }

      int[] res1={-1, -1};
       return res1;
    }
}
