package easy;

import java.util.Map;

public class ValidParentheses {
    private static final Map<Character, Character> PARENTHESES = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
    );

    // Could be enhanced with Stack<Character> :D
    public boolean isValid(String s) {
        int index = 0;
        char currentChar = s.charAt(index);
        if (!PARENTHESES.containsKey(currentChar)) return false;
        while (true) {
            index = isValid(s, index, currentChar) + 1;
            if (index == s.length()) return true;
            if (index == 0) return false;
            currentChar = s.charAt(index);
        }

    }

    public int isValid(String s, int index, char openingParentheses) {
        if (index == -1 || index == s.length() - 1 || !PARENTHESES.containsKey(openingParentheses)) return -1;
        int nextIndex = index + 1;
        char nextChar = s.charAt(nextIndex);
        if (PARENTHESES.get(openingParentheses) == nextChar) {
            return nextIndex;
        } else if (PARENTHESES.containsKey(nextChar)) {
            int newIndex = isValid(s, nextIndex, nextChar);
            return isValid(s, newIndex, openingParentheses);
        } else {
            return -1;
        }
    }

    public static void main() {
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.isValid("()[]{}")); // true
        System.out.println(solution.isValid("([{}])")); // true
        System.out.println(solution.isValid("([])")); // true
        System.out.println(solution.isValid("(]")); // false
        System.out.println(solution.isValid("([)")); // false
        System.out.println(solution.isValid("(][)")); // false
        System.out.println(solution.isValid("(")); // false
        System.out.println(solution.isValid("(){}}{")); // false
    }
}
