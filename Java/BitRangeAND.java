// find common leading '1' bits between m and n
public int rangeBitwiseAnd(int m, int n) {
    int moveStep = 1;
    while (m != n) {
        m = m >> 1;
        n = n >> 1;
        moveStep = moveStep << 1;
    }
    return m * moveStep;
}
