package solutions;

import java.util.*;

public class Problem3_LongestSubstringWIthoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charInWindow = new HashSet<>();
        int longest = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            if (charInWindow.contains(s.charAt(end))) {
                while (s.charAt(start) != s.charAt(end)) {
                    charInWindow.remove(s.charAt(start));
                    start++;
                }
                charInWindow.remove(s.charAt(start));
                start++;
            }

            charInWindow.add(s.charAt(end));
            longest = Math.max(longest, end - start + 1);
        }

        return longest;
    }
}
