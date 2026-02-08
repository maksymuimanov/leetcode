void main() {
    IO.println(longestPalindrome("babad")); //aba | bab
    IO.println(longestPalindrome("badbad")); //b
    IO.println(longestPalindrome("cbbd")); //bb
    IO.println(longestPalindrome("baabad")); //baab
    IO.println(longestPalindrome("cbbd")); //bb
    IO.println(longestPalindrome("cbbdab")); //bb
    IO.println(longestPalindrome("ccc")); //ccc
    IO.println(longestPalindrome("a")); //a
    IO.println(longestPalindrome("neon")); //n
    IO.println(longestPalindrome("nonno")); //onno
    IO.println(longestPalindrome("noonanoba")); //onano
}

public String longestPalindrome(String s) {
   int[] bounds = {-1, -1};
   int maxLength = 0, left = 0, right = 0;
   for (int i = 0; i < s.length(); i++) {
       char current = s.charAt(i);
       for (int j = s.length() - 1; j > i; j--) {
           if (s.charAt(j) == current
                   && (bounds[0] >= i || bounds[1] <= j)
                   && checkPalindrome(s, i, j)) {
               if (maxLength < j - i) {
                   left = i;
                   right = j;
                   bounds[0] = left;
                   bounds[1] = right;
                   maxLength = right - left;
               }
           }
       }
   }

    return s.substring(left, right + 1);
}

public boolean checkPalindrome(String s, int left, int right) {
    for (int i = left; i <= (left + right) / 2; i++) {
        char leftChar = s.charAt(i);
        char rightChar = s.charAt(left + right - i);
        if (leftChar != rightChar) {
            return false;
        }
    }

    return true;
}