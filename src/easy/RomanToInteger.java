package easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static Map<Character, Integer> romanMap = new HashMap<>();

    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean isLastChar = i == s.length() - 1;
            char currentChar = s.charAt(i);
            Integer currentValue = romanMap.get(currentChar);
            if (isLastChar || currentValue >= romanMap.get(s.charAt(i + 1))) {
                result += currentValue;
            } else {
                result -= currentValue;
            }
        }

        return result;
    }

    public static void main() {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("III")); // 3
        System.out.println(romanToInteger.romanToInt("LVIII")); // 58
        System.out.println(romanToInteger.romanToInt("MCMXCIV")); // 1994
    }
}
