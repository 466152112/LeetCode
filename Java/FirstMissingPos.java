// cannot use extra O(N) memory? no problem, use itself for swapping
public int firstMissingPositive(int[] A) {
    if (A == null && A.length == 0)
        return 1;
    for (int i = 0; i < A.length; i++) {
        // nagetive or itself safe location
        if (A[i] <= 0 || A[i] - 1 == i)
            continue;
        // positive, swap to safe location
        if (A[i] - 1 < A.length) {
            advancedSwap(A, i, A[i] - 1);
            i--;
        }
        // safe location out of boundary
        else
            A[i] = 0;
    }
    for (int i = 0; i < A.length; i++) {
        if (A[i] <= 0)
            return i + 1;
    }
    return A.length + 1;
}
// swap if there are not equal, otherwise set source to 0
private void advancedSwap(int[] A, int s, int d) {
    if (A[s] == A[d])
        A[s] = 0;
    else {
        int temp = A[s];
        A[s] = A[d];
        A[d] = temp;
    }
}
