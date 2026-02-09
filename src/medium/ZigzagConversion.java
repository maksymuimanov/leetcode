void main() {
    IO.println(convert("PAYPALISHIRING", 4));
    IO.println(convert("PAYPALISHIRING", 3));
    IO.println(convert("PAYPALISHIRING", 2));
    IO.println(convert("PAYPALISHIRING", 1));
    IO.println(convert("A", 1));
}

public String convert(String s, int numRows) {
    List<char[]> columns = new ArrayList<>();

    int columnIndex = 0, rowIndex = numRows - 1;
    for (int i = 0; i < s.length(); i++) {
        char[] tempColumn = new char[numRows];
        if (numRows == 1 || columnIndex % (numRows - 1) == 0) {
            rowIndex = numRows - 1;
            for (int j = i; j < i + numRows && j < s.length(); j++) {
                tempColumn[j - i] = s.charAt(j);
            }
            i += numRows - 1;
        } else {
            tempColumn[--rowIndex] = s.charAt(i);
        }

        columns.add(tempColumn);
        columnIndex++;
    }

    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
        for (char[] column : columns) {
            char current = column[i];
            if (current != '\0') {
                stringBuilder.append(current);
            }
        }
    }
    return stringBuilder.toString();
}