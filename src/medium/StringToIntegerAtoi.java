void main() {
    IO.println(myAtoi("42"));
    IO.println(myAtoi("042"));
    IO.println(myAtoi(" 42"));
    IO.println(myAtoi("+42"));
    IO.println(myAtoi("+042"));
    IO.println(myAtoi(" +42"));
    IO.println(myAtoi("-42"));
    IO.println(myAtoi("-042"));
    IO.println(myAtoi(" -42"));
    IO.println(myAtoi("0-1"));
    IO.println(myAtoi("4193 with words"));
    IO.println(myAtoi("+-12"));
    IO.println(myAtoi("2147483648"));
}

public int myAtoi(String s) {
    int result = 0, sign = 0, index = 0;
    char current;
    boolean started = false;
    while (index < s.length()
            && (Character.isDigit((current = s.charAt(index)))
            || Character.isWhitespace(current)
            || current == '-'
            || current == '+')) {
        if (!started && !Character.isWhitespace(current)) started = true;

        if (started) {
            if (Character.isWhitespace(current)) break;
            if (result > Integer.MAX_VALUE / 10) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else if (result == Integer.MAX_VALUE / 10
                    && (current - '0') > 7) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            boolean isSign = current == '-' || current == '+';
            if (sign == 0) {
                sign = current == '-' ? -1 : 1;
                if (isSign) index++;
                continue;
            } else if (isSign) {
                break;
            }

            result = result * 10 + current - '0';
        }

        index++;
    }

    return sign * result;
}