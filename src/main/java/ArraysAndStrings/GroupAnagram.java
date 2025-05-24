package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        String [] temp=strs;
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> result=new ArrayList<>();
        String wordOrigin;
        for (String word : temp) {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String sortedWord = new String(ch);
            if (map.containsKey(sortedWord)) {
                map.get(sortedWord).add(word);
            }
            else {
                List<String> newList = new ArrayList<>();
                newList.add(word);
                map.put(sortedWord, newList);
            }
        }
        return new ArrayList<>(map.values());
    }
}
