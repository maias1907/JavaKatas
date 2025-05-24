package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;

public class intersactionTwo {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> res=new HashSet();
        int [ ] result = new int[0];
        int len=0,i=0,j=0;
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]==nums2[j])
            {
                res.add(nums1[i]);
            }
            if(nums1[i]<nums2[j])
            {
                i++;
            }
            else {
            j++;
        }
            result=new int[res.size()];
            int idx = 0;
            for (int num : res) {
                result[idx++] = num;
            }


        }
        return  result;
    }

}
