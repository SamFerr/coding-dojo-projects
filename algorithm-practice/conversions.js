// ASCII
// Question: Write functions to convert from ASCII to integer & integer to ASCII
// Sample Answer:
public static int asciiToInt(String str) {
    int result = 0;
    for (int i = 0; i < str.length(); i++) {
        result *= 10; result += str.charAt(i) - '0';
    }
    return result;
}
public static String intToAscii(int i) {
    StringBuilder sb = new StringBuilder();
    while (i != 0) {
        char c = (char)('0' + (i % 10)); sb.insert(0, c); i /= 10;
    }
    return sb.toString();
}


// Number conversion
// Question: Write a function to convert a number to its binary format and vice versa.
// Sample Answer:
public static String decimalToBinary(int n) {
    StringBuilder sb = new StringBuilder();
    while (n != 0) {
        sb.insert(0, n % 2); n /= 2;
    }
    return sb.toString();
}
public static int binaryToDecimal(String input) {
    int i = 0;
    int j = 1;
    for (int k = input.length() - 1; k >= 0; k--) {
        if (input.charAt(k) == '1') {
            i += j;
        } j *= 2;
    }
    return i;
}
