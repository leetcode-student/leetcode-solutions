package solutions;

import java.util.*;

public class Problem13_RomanToInteger {
    private static final Map<Character, Integer> intValues = new HashMap<>();
    private static final Map<String, Integer> subtractions = new HashMap<>();

    static {
        intValues.put('I', 1);
        intValues.put('V', 5);
        intValues.put('X', 10);
        intValues.put('L', 50);
        intValues.put('C', 100);
        intValues.put('D', 500);
        intValues.put('M', 1000);

        subtractions.put("I_V", 1);
        subtractions.put("I_X", 1);
        subtractions.put("X_L", 10);
        subtractions.put("X_C", 10);
        subtractions.put("C_D", 100);
        subtractions.put("C_M", 100);
    }

    public int romanToInt(String s) {
        int intValue = 0;

        Character lastCharacter = null;
        for (int i = s.length() - 1; i >= 0; i--) {
            String subtractionsKey = s.charAt(i) + "_" + lastCharacter;
            if (subtractions.containsKey(subtractionsKey)) {
                intValue -= subtractions.get(subtractionsKey);
            } else {
                intValue += intValues.get(s.charAt(i));
            }
            lastCharacter = s.charAt(i);
        }

        return intValue;
    }
}
