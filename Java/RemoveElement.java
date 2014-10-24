public int removeElement(int[] A, int elem) {
    int len = A.length;
    for (int i = 0; i < len; i++) {
        // exchange with the tail until meet the front
        while (A[i] == elem && len > i) {
            len--;
            A[i] = A[len];
        }
    }
    return len;
}
