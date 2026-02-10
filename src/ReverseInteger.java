void main() {
    IO.println(reverse(123));
    IO.println(reverse(-321));
    IO.println(reverse(1534236469));
    IO.println(reverse(Integer.MIN_VALUE));
    IO.println(reverse(Integer.MAX_VALUE));
    IO.println(reverse(-2147483412));
}

public static byte[] maxDigits = {2, 1, 4, 7, 4, 8, 3, 6, 4, 7};

public int reverse(int x) {
    int result = 0;

    int sign = 1;
    if (x < 0) sign = -1;

    List<Byte> digits = new ArrayList<>();

    int number = Math.abs(x);
    while (number > 0) {
        byte lastDigit = (byte) (number % 10);
        digits.add(lastDigit);
        number /= 10;
    }

    if (digits.size() == maxDigits.length) {
        for (int i = 0; i < digits.size(); i++) {
            byte currentDigit = digits.get(i);
            byte maxDigit = maxDigits[i];
            if (currentDigit > maxDigit) return 0;
            else if (currentDigit < maxDigit) break;
        }
    }

    for (byte digit : digits) {
        result = result * 10 + digit;
    }

    return result * sign;
}

