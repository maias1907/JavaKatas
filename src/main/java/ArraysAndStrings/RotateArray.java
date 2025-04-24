package ArraysAndStrings;
//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
//Example 2:
//
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation:
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
//

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int i=0,j=n-1;
        if(n==1)
        {
            return ;
        }
        if(k>n)
        {
            k=k%n;
        }

        while(i<j) //flip all the array
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
        i=0;
        j=k-1;
        while(i<j) //flip the first numbers from 0-k-1
        {
            int temp=nums[i] ;
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;

        }
        i=k;
        j=n-1;
        while(i<j )//flip the last numbers  from k-n-1
        {
            int temp=nums[i] ;
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }


    }
}
