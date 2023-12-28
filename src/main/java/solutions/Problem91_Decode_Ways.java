package solutions;

import java.util.*;

public class Problem91_Decode_Ways {
    public int numDecodings(String s) {
        return numDecodings(s, 0, new HashMap<>());
    }

    private int numDecodings(String s, int i, Map<Integer, Integer> cache) {
        if (cache.containsKey(i)) {
            return cache.get(i);
        }

        int numDecodings = 0;

        int singleDigitValue = Integer.parseInt("" + s.charAt(i));
        if (singleDigitValue > 0) {
            if (i + 1 < s.length()) {
                numDecodings += numDecodings(s, i + 1, cache);
            } else {
                numDecodings++;
            }
        }

        if (i + 1 < s.length()) {
            int doubleDigitValue = Integer.parseInt(s.charAt(i) + "" + s.charAt(i + 1));
            if (doubleDigitValue >= 10 && doubleDigitValue <= 26) {
                if (i + 2 < s.length()) {
                    numDecodings += numDecodings(s, i + 2, cache);
                } else {
                    numDecodings++;
                }
            }
        }

        cache.put(i, numDecodings);

        return numDecodings;
    }
}
