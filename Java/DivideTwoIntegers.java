// bit manipulation, O(lgN)
public int divide(int dividend, int divisor) {
    if (divisor == 0)
        return Integer.MAX_VALUE;
    int negtive = dividend < 0 && divisor > 0 || 
                dividend > 0 && divisor < 0? -1: 1;
    long up = Math.abs((long)dividend);	// (long)Math.abs(dividend) is not gonna work
    long down = Math.abs((long)divisor);	// since abs(int) will produce a problem for Integer.MIN_VALUE
    long result = 0;
    while (up >= down) {
        int shift = 0;
        // shift down just larger than up
        while ((down << shift) <= up)
            shift++;
        // shift 1 to after times*down just smaller than up
        result += 1 << (shift - 1);
        // reduce up by times*down
        up -= down << (shift - 1);
    }
    return (int)result*negtive;
}
