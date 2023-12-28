package solutions;

import java.util.*;

public class Problem17_LetterCombinationsOfAPhoneNumber {
    private static final Map<Integer, List<Character>> digitMap = new HashMap<>();

    static {
        digitMap.put(2, Arrays.asList('a', 'b', 'c'));
        digitMap.put(3, Arrays.asList('d', 'e', 'f'));
        digitMap.put(4, Arrays.asList('g', 'h', 'i'));
        digitMap.put(5, Arrays.asList('j', 'k', 'l'));
        digitMap.put(6, Arrays.asList('m', 'n', 'o'));
        digitMap.put(7, Arrays.asList('p', 'q', 'r', 's'));
        digitMap.put(8, Arrays.asList('t', 'u', 'v'));
        digitMap.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        return letterCombinations(digits, 0);
    }

    private List<String> letterCombinations(String digits, int curr) {
        List<String> letterCombinations = new ArrayList<>();

        if (curr == digits.length()) {
            return letterCombinations;
        }

        List<Character> chars = digitMap.get(Character.getNumericValue(digits.charAt(curr)));

        List<String> subLetterCombinations = letterCombinations(digits, curr + 1);
        if (subLetterCombinations.isEmpty()) {
            subLetterCombinations.add("");
        }

        for (char c : chars) {
            for (String subLetterCombination : subLetterCombinations) {
                String letterSubCombination = c + subLetterCombination;
                letterCombinations.add(letterSubCombination);
            }
        }

        return letterCombinations;
    }
}
