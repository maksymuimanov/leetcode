package easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        String shortestString = strs[0];
        int shortestIndex = 0;
        for (int i = 1; i < strs.length; i++) {
            String string = strs[i];
            if (shortestString.length() > string.length()) {
                shortestString = string;
                shortestIndex = i;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        outer:
        for (int i = 0; i < shortestString.length(); i++) {
            char currentChar = shortestString.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (j == shortestIndex) continue;
                if (currentChar != strs[j].charAt(i)) {
                    break outer;
                }
            }

            stringBuilder.append(currentChar);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"})); //fl
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"dog","race","racecar"})); //
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"ab","a"})); //a
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"cir","car"})); //c
    }
}
