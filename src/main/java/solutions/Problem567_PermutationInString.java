package solutions;

import java.util.*;

public class Problem567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        String s1Sorted = sorted(s1);

        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            String s2SubSorted = sorted(s2.substring(i, i + s1.length()));
            if (s1Sorted.equals(s2SubSorted)) {
                return true;
            }
        }

        return false;
    }

    private String sorted(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
