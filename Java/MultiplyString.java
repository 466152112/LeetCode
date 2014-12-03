// bit by bit multiply, one pass for a digit in num2, add them to result, and then the second digit
// c[i + j + 1] is the bit for a[i] b[j]
public String multiply(String num1, String num2) {
    if (num1 == null || num2 == null)
        return "";
    char[] a = num1.toCharArray();
    char[] b = num2.toCharArray();
    int [] c = new int[a.length + b.length];
    int carry = 0;
    for (int i = a.length - 1; i >= 0; i--) {
        int j = b.length - 1;
        for (; j >= 0; j--) {
            c[i + j + 1] += (a[i] - '0')*(b[j] - '0') + carry; // itself + product + carry
            carry = c[i + j + 1]/10; // update carry
            c[i + j + 1] = c[i + j + 1]%10; // update itselt
        }
        c[i + j + 1] = carry; // deal with the last carry
        carry = 0;
    }
    StringBuilder result = new StringBuilder();
    int i = 0;
    // skip leading 0s
    while (c[i] == 0 && i < c.length - 1)
        i++;
    while (i < c.length)
        result.append(c[i++]);
    return result.toString();
}
