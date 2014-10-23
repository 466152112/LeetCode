public void merge(int A[], int m, int B[], int n) {
    int i = m-- + n-- - 1;
    // no need to check i > 0, since m & n > 0 ensure i > 0
    while (m >= 0 && n >= 0) {
        A[i--] = A[m] > B[n]?A[m--]:B[n--];
    }
    // no need to set A[i] = A[remaining]
    while (n >= 0)
        A[i--] = B[n--];
}
