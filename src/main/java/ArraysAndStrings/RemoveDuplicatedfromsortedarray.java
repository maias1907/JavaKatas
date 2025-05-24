package ArraysAndStrings;

public class RemoveDuplicatedfromsortedarray {
    public int removeDuplicates(int[] nums) {
        int i=0,j=1,len=nums.length,k=1;
        int [] expectedNums=new int[len];
        expectedNums[0]=nums[0];
        while(j<nums.length)
        {
            if(nums[i]!=nums[j])
            {
                expectedNums[k]=nums[j];
                k++;
            }
            i++;
            j++;
        }
     return expectedNums.length;
    }
}
