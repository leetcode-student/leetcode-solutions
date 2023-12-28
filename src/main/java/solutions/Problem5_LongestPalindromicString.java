package solutions;

public class Problem5_LongestPalindromicString {
    public String longestPalindrome(String s) {
        int longest = 0;
        int longestStart = 0;
        int longestEnd = 0;

        for (int i = 0; i < s.length(); i++) {
            int longestOddPalindrome = 1 + longestPalindrome(s, i - 1, i + 1);
            int longestEvenPalindrome = longestPalindrome(s, i, i + 1);

            if (longestOddPalindrome > longestEvenPalindrome && longestOddPalindrome > longest) {
                longest = longestOddPalindrome;
                longestStart = i - (longestOddPalindrome - 1) / 2;
                longestEnd = i + (longestOddPalindrome - 1) / 2;
            } else if (longestEvenPalindrome > longestOddPalindrome && longestEvenPalindrome > longest) {
                longest = longestEvenPalindrome;
                longestStart = i - longestEvenPalindrome / 2 + 1;
                longestEnd = i + longestEvenPalindrome / 2;
            }
        }

        return s.substring(longestStart, longestEnd + 1);
    }

    public int longestPalindrome(String s, int left, int right) {
        if (left < 0 || right == s.length() || s.charAt(left) != s.charAt(right)) {
            return 0;
        }

        return 2 + longestPalindrome(s, left - 1, right + 1);
    }
}
