package solutions;

public class Problem161_OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) {
            return false;
        }

        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }

        if (s.equals(t)) {
            return false;
        }

        if (s.length() == t.length()) {
            int numDiff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    numDiff++;
                }
            }

            return numDiff == 1;
        }

        String bigger = s.length() > t.length() ? s : t;
        String smaller = s.length() < t.length() ? s : t;

        int lastMatchingIdx = -1;
        for (int i = 0; i < smaller.length(); i++) {
            if (smaller.charAt(i) == bigger.charAt(i)) {
                lastMatchingIdx = i;
            } else {
                break;
            }
        }

        //System.out.println("lastMatchingIdx=" + lastMatchingIdx);

        for (int i = lastMatchingIdx + 1; i < smaller.length(); i++) {
            if (smaller.charAt(i) == bigger.charAt(i + 1)) {
                lastMatchingIdx = i;
            } else {
                break;
            }
        }

        return lastMatchingIdx == smaller.length() - 1;
    }
}
