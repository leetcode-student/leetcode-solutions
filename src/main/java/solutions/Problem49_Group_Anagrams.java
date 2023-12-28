package solutions;

import java.util.*;

public class Problem49_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }

            anagrams.get(key).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }
}
