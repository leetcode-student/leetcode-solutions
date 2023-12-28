package solutions;

public class Problem8_StringToIntegerAtoi {
    private static final String INT_MIN_STRING = Integer.toString(Integer.MIN_VALUE);
    private static final String INT_MAX_STRING = Integer.toString(Integer.MAX_VALUE);

    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int start = 0;
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }

        if (start == s.length()) {
            return 0;
        }

        boolean isPositive = true;
        if (s.charAt(start) == '+') {
            start++;
        } else if (s.charAt(start) == '-') {
            isPositive = false;
            start++;
        }

        if (start == s.length()) {
            return 0;
        }

        int end = start;
        while (end < s.length() && Character.isDigit(s.charAt(end))) {
            end++;
        }

        if (start == end) {
            return 0;
        }

        while (start < s.length() && s.charAt(start) == '0') {
            start++;
        }

        String number;
        if (end - start == 0) {
            number = "0";
        } else if (isPositive) {
            number = s.substring(start, end);
        } else {
            number = "-" + s.substring(start, end);
        }

        if (isPositive) {
            if (number.length() > INT_MAX_STRING.length()) {
                number = INT_MAX_STRING;
            } else if (number.length() == INT_MAX_STRING.length()
                && number.compareTo(INT_MAX_STRING) > 0) {
                number = INT_MAX_STRING;
            }
        } else {
            if (number.length() > INT_MIN_STRING.length()) {
                number = INT_MIN_STRING;
            } else if (number.length() == INT_MIN_STRING.length()
                && number.substring(1).compareTo(INT_MIN_STRING.substring(1)) > 0) {
                number = INT_MIN_STRING;
            }
        }

        return Integer.parseInt(number);
    }
}
