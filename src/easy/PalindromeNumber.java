package easy;

public class PalindromeNumber {
    public static void main() {
        PalindromeNumber solution = new PalindromeNumber();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(123));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(11));
        System.out.println(solution.isPalindrome(10));
        System.out.println(solution.isPalindrome(1));
        System.out.println(solution.isPalindrome(1000000001));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        long highestPlace = 1;
        while (highestPlace <= x) highestPlace *= 10;
        highestPlace /= 10;

        long reversed = 0;
        int digitExtractor = 10;
        int current = x;
        while (current > 0) {
            reversed += highestPlace * (current % digitExtractor);
            highestPlace /= 10;
            current /= 10;
        }

        return reversed == x;
    }
}
