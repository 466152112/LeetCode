// cannot use divied by 2, since we take int n as unsigned number, all the negitve number is larger then Integer.MAX_VALUE
// and, there +0 and -0 too.
// use bit & and shift, remember the predence of & and ==
public int hammingWeight(int n) {
    int result = 0;        
    for (int i = 0; i < 32; i++) {
        if ((n&1) == 1)
            result++;
        n = n>>1;
    }
    return result;
}
