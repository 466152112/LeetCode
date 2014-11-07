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
