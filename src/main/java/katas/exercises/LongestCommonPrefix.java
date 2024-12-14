package katas.exercises;

public class   LongestCommonPrefix {

    /**
     * Finds the longest common prefix in an array of strings.
     *
     * @param strs the array of strings
     * @return the longest common prefix, or an empty string if none exists
     */
    public static String longestCommonPrefix(String[] strs) {
        int shortestString=strs[0].length(),i,j;
        char letter;
        String prefix="";
        if(strs.length==0 || strs==null)
        {
            return "";
        }
        for(String element:strs)
        {
            if(element.length()<shortestString)
            {
                shortestString=element.length();
            }
        }
        for(i=0;i<shortestString;i++)
        {

            letter= strs[0].charAt(i);

            for(j=0;j<strs.length;j++)
            {
               if(strs[j].charAt(i)!=letter)
               {
                  return prefix;
               }
            }

                prefix+=letter;


        }


        return prefix;
    }

    public static void main(String[] args) {
        String[] test1 = {"flower", "flow", "flight"};
        String[] test2 = {"dog", "racecar", "car"};
        String[] test3 = {"interspecies", "interstellar", "interstate"};
        String[] test4 = {"apple", "apricot", "ape"};

        System.out.println("Longest Common Prefix: " + longestCommonPrefix(test1)); // Output: "fl"
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(test2)); // Output: ""
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(test3)); // Output: "inter"
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(test4)); // Output: "ap"
    }
}
