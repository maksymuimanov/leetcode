package easy;

public class FindIndexFirstOccurenceString {
    public int strStr(String haystack, String needle) {
        char firstChar = needle.charAt(0);
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == firstChar) {
                boolean toReturn = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        toReturn = false;
                        break;
                    }
                }

                if (toReturn) return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindIndexFirstOccurenceString findIndexFirstOccurenceString = new FindIndexFirstOccurenceString();
        System.out.println(findIndexFirstOccurenceString.strStr("hello", "ll"));
        System.out.println(findIndexFirstOccurenceString.strStr("aaaaa", "bba"));
        System.out.println(findIndexFirstOccurenceString.strStr("a", "a"));
    }
}
