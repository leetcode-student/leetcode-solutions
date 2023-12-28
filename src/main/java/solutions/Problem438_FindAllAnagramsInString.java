package solutions;

import java.util.*;

public class Problem438_FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();

        if (s.length() < p.length()) {
            return anagrams;
        }

        int[] sHist = new int[26];
        int[] pHist = new int[26];

        for (int i = 0; i < p.length(); i++) {
            sHist[s.charAt(i) - 'a']++;
            pHist[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            //System.out.println("i=" + i);
            if (isEqual(sHist, pHist)) {
                anagrams.add(i);
            }

            sHist[s.charAt(i) - 'a']--;
            //System.out.println("  remove " + s.charAt(i));
            if (i < s.length() - p.length()) {
                //System.out.println("  add " + s.charAt(i + p.length()));
                sHist[s.charAt(i + p.length()) - 'a']++;
            }
        }

        return anagrams;
    }

    private boolean isEqual(int[] sHist, int[] pHist) {
        for (int i = 0; i < sHist.length; i++) {
            if (sHist[i] != pHist[i]) {
                return false;
            }
        }
        return true;
    }
}
