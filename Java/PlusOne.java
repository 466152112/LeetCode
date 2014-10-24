public int[] plusOne(int[] digits) {
    int len = digits.length;
    int[] result = new int[len];
    int carry = 1;
    for (int i = len -1; i >= 0; i--) {
        if (digits[i] + add > 9) {
            result[i] = 0;
            add = 1;
        }
        else {
            result[i] = digits[i] + add;
            add = 0;
        }
    }
    if (add == 0)
        return result;
    else {
        int[] newResult = new int[len+1];
        newResult[0] = 1;
        for (int i = 0; i < len; i++)
            newResult[i+1] = result[i];
        return newResult;
    }
}
