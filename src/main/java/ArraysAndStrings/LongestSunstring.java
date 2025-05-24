package ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

public class LongestSunstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> res=new HashSet<>();
        int len=s.length(),left=0,right=1,longest=0;
        char chLeft=s.charAt(left);
        res.add(chLeft);
        char chRight;
        while(left<len && right<len)
        {
            chRight=s.charAt(right);
            if(res.contains(chRight))
            {
                if(res.size()>longest){longest=res.size();}

                res.clear();
                left++;
                right=left+1;
            }
            else{
                res.add(chRight);
                int longestupdate=res.size();
                if(longestupdate>longest)
                {
                    longest=longestupdate;
                }
            }


        }
        return longest;

    }
}
