package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (!set.add(s.charAt(j))) {
                    break;
                }
            }

            max = Math.max(max, set.size());
        }

        return max;
    }

    static void main() {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
    }
}
