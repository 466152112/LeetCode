// too hard...
public double findMedianSortedArrays(int A[], int B[]) {
    if (A == null || B == null || A.length == 0 && B.length == 0)
        return Double.MIN_VALUE;
    int len = A.length + B.length;
    if (len % 2 == 0) {
        return (findKth(A, 0, B, 0, len/2) + findKth(A, 0, B, 0, len/2 + 1)) / 2;
    }
    else
        return findKth(A, 0, B, 0, len/2 + 1);
}
// find the Kth number in global sorted order
public double findKth(int A[], int A_start, int B[], int B_start, int k) {
    // A_start of out A, the global is only B[B_start:end]
    if (A_start >= A.length)
        return B[B_start + k - 1];
    // B_start of out B, the global is only A[A_start:end]    
    if (B_start >= B.length)
        return A[A_start + k - 1];
    // find the first one in the global
    if (k == 1)
        return Math.min(A[A_start], B[B_start]);
    // compare A_key with B_key, to decide which part to go next
    // A_index >= A.length means, we are not sure we can cut branch of A or not, just cut the smaller part of B
    // so that, we set A default value to Integer.MAX_VALUE
    int A_key = (A_start + k/2 - 1) < A.length ? A[A_start + k/2 - 1] : Integer.MAX_VALUE;
    int B_key = (B_start + k/2 - 1) < B.length ? B[B_start + k/2 - 1] : Integer.MAX_VALUE;
    if (A_key <= B_key)
        return findKth(A, A_start + k/2, B, B_start, k - k/2);
    return findKth(A, A_start, B, B_start + k/2, k - k/2);
}

// O(m + n), merge two array
public double findMedianSortedArrays(int A[], int B[]) {
    int[] C = new int[A.length + B.length];
    int i = 0, j = 0, k = 0;
    while (i < A.length && j < B.length) {
        if (A[i] < B[j])
            C[k++] = A[i++];
        else
            C[k++] = B[j++];
    }
    while (i < A.length)
        C[k++] = A[i++];
    while (j < B.length)
        C[k++] = B[j++];
    if (C.length%2 == 0)
        return (double)(C[C.length/2] + C[C.length/2 - 1]) / 2.0;
    return (double)C[C.length/2];
}
