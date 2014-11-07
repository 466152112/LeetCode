public int singleNumber(int[] A) {
    if (A == null || A.length == 0)
        return Integer.MIN_VALUE;
    // one store the number only appear one time
    // two for twice, three for three time
    int one = 0, two = 0, three = 0;
    for (int i = 0; i < A.length; i++) {
        // two keep itself and adding new twice frequency numbers
        // | operation can keep itself and increase new values
        two |= one & A[i];
        // ^ operation take in new value, remove old value
        one ^= A[i];
        // if one and two are both "true", become three
        three = one & two;
        // update one and two, accoding to the value of three
        one &= ~three;
        two &= ~three;
    }
    return one;
}


// more intuition version, not space efficent
public int singleNumber(int[] A) {
    if (A == null || A.length == 0)
        return Integer.MIN_VALUE;
    int[] bits = new int[32];
    // compute bit by bit
    int result = 0;
    for (int i = 0; i < 32; i++) {
        for (int j = 0; j < A.length; j++) {
            // remember to & 1, so that just leave the last digit
            // can not use | operation, adding in the same bit location
            bits[i] += A[j] >> i & 1;
        }
        bits[i] %= 3;
        // add those bit up to the result
        // can use | operation, becaue every bit move up the next time
        result += bits[i] << i;
    }
    return result;
}
