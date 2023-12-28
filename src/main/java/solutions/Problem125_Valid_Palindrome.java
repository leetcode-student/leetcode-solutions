package solutions;

public class Problem125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (left == right) {
            return true;
        }

        if (!Character.isLetterOrDigit(s.charAt(left))) {
            return isPalindrome(s, left + 1, right);
        }

        if (!Character.isLetterOrDigit(s.charAt(right))) {
            return isPalindrome(s, left, right - 1);
        }

        char leftC = Character.toUpperCase(s.charAt(left));
        char rightC = Character.toUpperCase(s.charAt(right));

        if (left + 1 == right && leftC == rightC) {
            return true;
        }

        return leftC == rightC && isPalindrome(s, left + 1, right - 1);
    }
}
